package idat.com.biblioteca.repository;

import idat.com.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Útil para el futuro login
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByDni(String dni);
}