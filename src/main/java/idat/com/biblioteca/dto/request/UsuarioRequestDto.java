package idat.com.biblioteca.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
public class UsuarioRequestDto {

    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    @Pattern(regexp = "\\d+", message = "El DNI solo debe contener números")
    private String dni;

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @Email(message = "Email no válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @Pattern(regexp = "^(admin|user)$", message = "El rol debe ser 'admin' o 'user'")
    private String rol;

    private String nombreUsuario;     // Añadir para permitir actualización manual
    private String contrasenaUsuario;
}