package idat.com.biblioteca.repository;

import idat.com.biblioteca.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    // Para ver el historial de un usuario específico
    List<Movimiento> findByUsuario_IdUsuario(Long idUsuario);
}