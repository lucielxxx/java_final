package idat.com.biblioteca.service;

import idat.com.biblioteca.dto.request.UsuarioRequestDto;
import idat.com.biblioteca.dto.response.UsuarioResponseDto;
import java.util.List;

public interface UsuarioService {

    UsuarioResponseDto crear(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto actualizar(Long idUsuario, UsuarioRequestDto usuarioRequestDto);

    List<UsuarioResponseDto> listarTodos();

    UsuarioResponseDto buscarPorId(Long idUsuario);

    void eliminarLogico(Long idUsuario);
}