package idat.com.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Movimiento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_movimiento")
    @SequenceGenerator(name = "seq_id_movimiento", sequenceName = "seq_id_movimiento", allocationSize = 1)
    private Long idMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro", nullable = false)
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Integer tipoSolicitud; // 1: Prestamo, 2: Retorno

    @Column(length = 20)
    private String observaciones;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaDeUltimaActualizacion;
}