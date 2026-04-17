package idat.com.biblioteca.controller;

import idat.com.biblioteca.dto.request.MovimientoRequestDto;
import idat.com.biblioteca.dto.response.MovimientoResponseDto;
import idat.com.biblioteca.service.MovimientoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
@Tag(name = "Movimientos", description = "Gestión de préstamos y devoluciones de libros")
@SecurityRequirement(name = "bearerAuth")
public class MovimientoController {

    private final MovimientoService movimientoService;

    @Operation(
            summary = "Registrar movimiento",
            description = "Crea un registro de préstamo o devolución. Vincula un usuario con un libro y genera la fecha automática."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimiento registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error en los datos (ej. libro sin stock)"),
            @ApiResponse(responseCode = "403", description = "Token inválido o expirado")
    })
    @PostMapping
    public ResponseEntity<MovimientoResponseDto> registrar(@Valid @RequestBody MovimientoRequestDto dto) {
        return ResponseEntity.ok(movimientoService.registrar(dto));
    }
}