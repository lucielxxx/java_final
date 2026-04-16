package idat.com.biblioteca.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
public class MovimientoRequestDto {

    @NotNull(message = "El ID del libro es obligatorio")
    private Long idLibro;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long idUsuario;

    @NotNull(message = "El tipo de solicitud es obligatorio")
    @Min(1) @Max(2)
    private Integer tipoSolicitud;

    @Size(max = 20, message = "La observación no puede superar los 20 caracteres")
    private String observaciones;
}