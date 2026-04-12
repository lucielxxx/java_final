package idat.com.biblioteca.repository;

import idat.com.biblioteca.entity.Libro;
import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByEstado(boolean estado);
}
