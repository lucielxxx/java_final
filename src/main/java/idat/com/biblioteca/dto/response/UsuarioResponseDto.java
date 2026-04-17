package idat.com.biblioteca.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Respuesta con la información detallada del perfil de usuario")
public class UsuarioResponseDto {

    @Schema(description = "Identificador único del usuario", example = "5")
    private Long idUsuario;

    @Schema(description = "Rol asignado en el sistema", example = "user")
    private String rol;

    @Schema(description = "Documento Nacional de Identidad", example = "72458930")
    private String dni;

    @Schema(description = "Nombres y apellidos completos", example = "Juan Pérez García")
    private String nombres;

    @Schema(description = "Correo electrónico registrado", example = "juan.perez@idat.edu.pe")
    private String email;

    @Schema(description = "Nombre de cuenta utilizado para el login", example = "jperez")
    private String nombreUsuario;

    @Schema(description = "Hash de la contraseña (por seguridad suele viajar enmascarado o vacío)", example = "$2a$10$...")
    private String contrasenaUsuario;

    @Schema(description = "Estado de la cuenta (true: Activo, false: Inactivo)", example = "true")
    private Boolean estado;

    @Schema(description = "Fecha de registro del usuario", example = "2026-04-10T08:30:00")
    private LocalDateTime fechaDeCreacion;

    @Schema(description = "Fecha de la última modificación del perfil", example = "2026-04-15T12:00:00")
    private LocalDateTime fechaDeUltimaActualizacion;
}