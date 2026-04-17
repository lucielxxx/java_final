package idat.com.biblioteca.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Objeto de transferencia de datos para el inicio de sesión")
public class LoginRequestDto {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Schema(description = "Nombre de usuario registrado en el sistema", example = "drak567", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombreUsuario;

    @NotBlank(message = "La contraseña es obligatoria")
    @Schema(description = "Contraseña del usuario", example = "dcmRu", requiredMode = Schema.RequiredMode.REQUIRED)
    private String contrasenaUsuario;
}