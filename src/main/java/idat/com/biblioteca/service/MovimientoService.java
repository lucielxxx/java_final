package idat.com.biblioteca.service;

import idat.com.biblioteca.dto.request.MovimientoRequestDto;
import idat.com.biblioteca.dto.response.MovimientoResponseDto;
import java.util.List;

public interface MovimientoService {
    MovimientoResponseDto registrar(MovimientoRequestDto dto);
    List<MovimientoResponseDto> listarPorUsuario(Long idUsuario);
}