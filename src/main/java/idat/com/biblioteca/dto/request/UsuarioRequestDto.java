package idat.com.biblioteca.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@Schema(description = "Datos requeridos para el registro o actualización de un usuario")
public class UsuarioRequestDto {

    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    @Pattern(regexp = "\\d+", message = "El DNI solo debe contener números")
    @Schema(description = "Documento Nacional de Identidad (8 dígitos)", example = "72458930", requiredMode = Schema.RequiredMode.REQUIRED)
    private String dni;

    @NotBlank(message = "Los nombres son obligatorios")
    @Schema(description = "Nombres y apellidos completos", example = "Juan Pérez García", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombres;

    @Email(message = "Email no válido")
    @NotBlank(message = "El email es obligatorio")
    @Schema(description = "Correo electrónico institucional o personal", example = "juan.perez@idat.edu.pe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Pattern(regexp = "^(admin|user)$", message = "El rol debe ser 'admin' o 'user'")
    @Schema(description = "Rol asignado en el sistema", example = "user", allowableValues = {"admin", "user"}, requiredMode = Schema.RequiredMode.REQUIRED)
    private String rol;

    @Schema(description = "Nombre de cuenta para el sistema", example = "jperez")
    private String nombreUsuario;

    @Schema(description = "Contraseña de acceso (será encriptada por el sistema)", example = "Pass1234")
    private String contrasenaUsuario;
}