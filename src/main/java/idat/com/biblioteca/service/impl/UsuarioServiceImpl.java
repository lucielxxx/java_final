package idat.com.biblioteca.service.impl;

import idat.com.biblioteca.dto.request.UsuarioRequestDto;
import idat.com.biblioteca.dto.response.UsuarioResponseDto;
import idat.com.biblioteca.entity.Usuario;
import idat.com.biblioteca.mapper.UsuarioMapper;
import idat.com.biblioteca.repository.UsuarioRepository;
import idat.com.biblioteca.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional
    public UsuarioResponseDto crear(UsuarioRequestDto dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);

        // 1. Estado activo por defecto
        usuario.setEstado(true);

        // 2. Generar nombreUsuario (ej: primeras 3 letras nombre + últimos 3 del DNI)
        String baseNombre = dto.getNombres().toLowerCase().replaceAll("\\s+", "");
        String generadoUser = baseNombre.substring(0, Math.min(baseNombre.length(), 4)) +
                dto.getDni().substring(5);
        usuario.setNombreUsuario(generadoUser);

        // 3. Generar contraseña abstracta (5 caracteres: letras y números)
        usuario.setContrasenaUsuario(generarPasswordAbstracto(dto.getNombres()));

        return usuarioMapper.toResponseDto(usuarioRepository.save(usuario));
    }

    @Override
    @Transactional
    public UsuarioResponseDto actualizar(Long idUsuario, UsuarioRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioMapper.actualizarFromRequest(dto, usuario);

        return usuarioMapper.toResponseDto(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioResponseDto> listarTodos() {
        return usuarioMapper.toResponseList(usuarioRepository.findAll());
    }

    @Override
    public UsuarioResponseDto buscarPorId(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toResponseDto(usuario);
    }

    @Override
    @Transactional
    public void eliminarLogico(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEstado(false);
        usuarioRepository.save(usuario);
    }

    private String generarPasswordAbstracto(String nombre) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder pass = new StringBuilder();
        // Tomamos la primera letra del nombre y completamos con 4 caracteres aleatorios
        pass.append(nombre.charAt(0));
        for (int i = 0; i < 4; i++) {
            int index = (int) (Math.random() * chars.length());
            pass.append(chars.charAt(index));
        }
        return pass.toString();
    }

}