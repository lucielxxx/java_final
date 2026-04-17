package idat.com.biblioteca.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Datos necesarios para registrar o actualizar un libro")
public class LibroRequestDto {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "no puede superar mas de 50 caracteres")
    @Schema(description = "Título del libro", example = "El Alquimista", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombreLibro;

    @NotBlank(message = "El campo es obligatorio")
    @Size(max = 50, message = " no puede tener mas de 50 caracteres")
    @Schema(description = "Nombre del autor", example = "Paulo Coelho", requiredMode = Schema.RequiredMode.REQUIRED)
    private String autor;

    @Schema(description = "Estado de activación del libro", example = "true")
    private Boolean estado;
}