package idat.com.biblioteca.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Respuesta detallada del movimiento registrado (Préstamo/Devolución)")
public class MovimientoResponseDto {

    @Schema(description = "Identificador único del registro de movimiento", example = "101")
    private Long idMovimiento;

    @Schema(description = "ID del libro involucrado", example = "1")
    private Long idLibro;

    @Schema(description = "ID del usuario que realizó la operación", example = "5")
    private Long idUsuario;

    @Schema(description = "Tipo de operación registrada (1: Préstamo, 2: Devolución)", example = "1")
    private Integer tipoSolicitud;

    @Schema(description = "Comentarios adicionales sobre el movimiento", example = "Préstamo regular")
    private String observaciones;

    @Schema(description = "Fecha y hora exacta en que se procesó el movimiento", example = "2026-04-16T19:45:00")
    private LocalDateTime fechaDeCreacion;
}