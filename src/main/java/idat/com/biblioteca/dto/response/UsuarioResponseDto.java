package idat.com.biblioteca.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDto {
    private Long idUsuario;
    private String rol;
    private String dni;
    private String nombres;
    private String email;
    private String nombreUsuario;
    private String contrasenaUsuario;
    private Boolean estado;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeUltimaActualizacion;
}