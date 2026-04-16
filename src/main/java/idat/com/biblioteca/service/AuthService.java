package idat.com.biblioteca.service;

import idat.com.biblioteca.dto.request.LoginRequestDto;
import idat.com.biblioteca.dto.response.AuthResponseDto;
import idat.com.biblioteca.entity.Usuario;
import idat.com.biblioteca.repository.UsuarioRepository;
import idat.com.biblioteca.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public AuthResponseDto login(LoginRequestDto request) {
        // 1. Buscar al usuario por su nombreUsuario
        Usuario usuario = usuarioRepository.findByNombreUsuario(request.getNombreUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2. Validar contraseña (como es prueba, comparamos texto plano)
        if (!usuario.getContrasenaUsuario().equals(request.getContrasenaUsuario())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // 3. Generar el Token usando el rol que ya tiene el usuario en la BD
        String token = jwtService.generateToken(usuario.getNombreUsuario(), usuario.getRol());

        return AuthResponseDto.builder()
                .token(token)
                .build();
    }
}