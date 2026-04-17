package idat.com.biblioteca.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@Schema(description = "Datos necesarios para registrar un préstamo o devolución de libro")
public class MovimientoRequestDto {

    @NotNull(message = "El ID del libro es obligatorio")
    @Schema(description = "ID del libro que entra o sale", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idLibro;

    @NotNull(message = "El ID del usuario es obligatorio")
    @Schema(description = "ID del usuario que realiza la acción", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUsuario;

    @NotNull(message = "El tipo de solicitud es obligatorio")
    @Min(1) @Max(2)
    @Schema(description = "Tipo de operación (1: Préstamo, 2: Devolución)", example = "1", allowableValues = {"1", "2"}, requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer tipoSolicitud;

    @Size(max = 20, message = "La observación no puede superar los 20 caracteres")
    @Schema(description = "Notas adicionales breves sobre el estado del libro", example = "Buen estado")
    private String observaciones;
}