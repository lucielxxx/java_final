package idat.com.biblioteca.controller;

import idat.com.biblioteca.dto.request.MovimientoRequestDto;
import idat.com.biblioteca.dto.response.MovimientoResponseDto;
import idat.com.biblioteca.service.MovimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<MovimientoResponseDto> registrar(@Valid @RequestBody MovimientoRequestDto dto) {
        return ResponseEntity.ok(movimientoService.registrar(dto));
    }

}