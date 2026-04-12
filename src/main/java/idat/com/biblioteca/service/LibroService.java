package idat.com.biblioteca.service;

import idat.com.biblioteca.dto.request.LibroRequestDto;
import idat.com.biblioteca.dto.response.LibroResponseDto;
import jakarta.transaction.Transactional;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public interface  LibroService {

    LibroResponseDto crear(LibroRequestDto libroRequestDto);

    LibroResponseDto actualzar(Long idLibro, LibroRequestDto libroRequestDto);


    List<LibroResponseDto> ListarLibros();
    LibroResponseDto listarLibroPorId(Long idLibro);
    void borrar(Long idLibro);
}
