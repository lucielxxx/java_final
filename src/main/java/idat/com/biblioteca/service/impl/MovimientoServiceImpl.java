package idat.com.biblioteca.service.impl;

import idat.com.biblioteca.dto.request.MovimientoRequestDto;
import idat.com.biblioteca.dto.response.MovimientoResponseDto;
import idat.com.biblioteca.entity.Libro;
import idat.com.biblioteca.entity.Movimiento;
import idat.com.biblioteca.mapper.MovimientoMapper;
import idat.com.biblioteca.repository.LibroRepository;
import idat.com.biblioteca.repository.MovimientoRepository;
import idat.com.biblioteca.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final LibroRepository libroRepository;
    private final MovimientoMapper movimientoMapper;

    @Override
    @Transactional
    public MovimientoResponseDto registrar(MovimientoRequestDto dto) {
        // 1. Validar que el libro existe
        Libro libro = libroRepository.findById(dto.getIdLibro())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        // 2. Lógica de cambio de estado del libro
        if (dto.getTipoSolicitud() == 1) { // Pedir prestado
            if (!libro.getEstado()) {
                throw new RuntimeException("El libro ya se encuentra prestado");
            }
            libro.setEstado(false); // Cambia a no disponible
        } else if (dto.getTipoSolicitud() == 2) { // Retornar
            libro.setEstado(true); // Cambia a disponible
        }

        // 3. Guardar el estado actualizado del libro
        libroRepository.save(libro);

        // 4. Registrar el movimiento
        Movimiento movimiento = movimientoMapper.toEntity(dto);
        return movimientoMapper.toResponseDto(movimientoRepository.save(movimiento));
    }

    @Override
    public List<MovimientoResponseDto> listarPorUsuario(Long idUsuario) {
        return movimientoRepository.findByUsuario_IdUsuario(idUsuario)
                .stream()
                .map(movimientoMapper::toResponseDto)
                .toList();
    }
}