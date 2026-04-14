package idat.com.biblioteca.service.impl;

import idat.com.biblioteca.dto.request.LibroRequestDto;
import idat.com.biblioteca.dto.response.LibroResponseDto;
import idat.com.biblioteca.entity.Libro;
import idat.com.biblioteca.mapper.LibroMapper;
import idat.com.biblioteca.repository.LibroRepository;
import idat.com.biblioteca.service.LibroService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;
    private final EntityManager entityManager;

    @Override
    @Transactional
    public LibroResponseDto  crear(LibroRequestDto libroRequestDto) {
        log.info("create libro: {}",libroRequestDto);
        Libro libroGuardado = libroRepository.save(libroMapper.toEntity(libroRequestDto));
        libroRepository.flush();
        // Recargar la entidad para obtener las fechas generadas
        entityManager.refresh(libroGuardado);
        return libroMapper.toResponseDto(libroGuardado);
    }



    @Transactional
    @Override
    public LibroResponseDto actualzar(Long idLibro, LibroRequestDto libroRequestDto) {
        // 1. Buscar el libro existente o lanzar excepción
        Libro libro = libroRepository.findById(idLibro)
                .orElseThrow(() -> new RuntimeException("Error al buscar libro"));

        // Mapeo automático de nombre y autor
        libroMapper.actualizarFromRequest(libroRequestDto, libro);

        // Validación manual del estado (por si el mapper tiene conflictos con booleanos)
        if (libroRequestDto.getEstado() != null) {
            libro.setEstado(libroRequestDto.getEstado());
        }

        Libro libroActualizado = libroRepository.save(libro);
        libroRepository.flush();
        entityManager.refresh(libroActualizado);

        return libroMapper.toResponseDto(libroActualizado);
    }

    @Override
    public List<LibroResponseDto> ListarLibros() {


        return libroMapper.toResponseList(libroRepository.findAll());
    }


    @Transactional(readOnly = true)
    @Override
    public LibroResponseDto listarLibroPorId(Long idLibro) {
        Libro libro = libroRepository.findById(idLibro).orElseThrow(()-> new RuntimeException("Error al buscar el libro"));
        return libroMapper.toResponseDto(libro);
    }

    @Override
    @Transactional
    public void borrar(Long idLibro) {
        if (!libroRepository.existsById(idLibro)){
            throw new RuntimeException("no existe el id del libro");
        }

        libroRepository.deleteById(idLibro);

    }

    @Override
    @Transactional
    public void eliminarLogico(Long idLibro) {
        // 1. Buscar el libro
        Libro libro = libroRepository.findById(idLibro)
                .orElseThrow(() -> new RuntimeException("No se encontró el libro con ID: " + idLibro));

        // 2. Cambiar el estado a false (Eliminado lógico)
        libro.setEstado(false);

        // 3. Guardar cambios
        // Al guardar, @UpdateTimestamp actualizará automáticamente fechaDeUltimaActualizacion
        libroRepository.save(libro);

        log.info("Libro con ID {} ha sido marcado como inactivo (eliminado lógico)", idLibro);
    }


}
