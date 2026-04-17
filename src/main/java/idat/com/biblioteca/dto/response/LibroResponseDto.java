package idat.com.biblioteca.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Respuesta detallada con la información del libro")
public class LibroResponseDto {

    @Schema(description = "Identificador único del libro", example = "1")
    private Long idLibro;

    @Schema(description = "Título del libro", example = "Cien años de soledad")
    private String nombreLibro;

    @Schema(description = "Autor de la obra", example = "Gabriel García Márquez")
    private String autor;

    @Schema(description = "Estado de disponibilidad (true: Activo, false: Eliminado lógicamente)", example = "true")
    private Boolean estado;

    @Schema(description = "Fecha y hora en que se registró el libro", example = "2026-04-16T10:00:00")
    private LocalDateTime fechaDeCreacion;

    @Schema(description = "Fecha y hora de la última modificación", example = "2026-04-16T15:30:00")
    private LocalDateTime fechaDeUltimaActualizacion;
}