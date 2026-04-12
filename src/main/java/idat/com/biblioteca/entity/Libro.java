package idat.com.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Table(name = "Libro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_id_libro")
    @SequenceGenerator(name = "seq_id_libro", sequenceName = "seq_id_libro", allocationSize = 1)
    @Column(name = "idLibro")
    private Long idLibro;

    @Column(name = "nombreLibro", nullable = false,length = 50, unique = true)
    private String nombreLibro;

    @Column(name = "autor", nullable = false , length = 50, unique = true)
    private String autor;

    @Column(name = "estado" , nullable = false)
    private Boolean estado;

    @Column(name = "fechaDeCreacion" , nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @Column(name = "fechaDeUltimaActualizacion" , nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaDeUltimaActualizacion;


    //private LocalDateTime IdUltimoUsuarioActualizador;
}
