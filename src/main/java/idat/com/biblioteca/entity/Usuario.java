package idat.com.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_usuario")
    @SequenceGenerator(name = "seq_id_usuario", sequenceName = "seq_id_usuario", allocationSize = 1)
    private Long idUsuario;

    @Column(nullable = false)
    private String rol; // "admin" o "user"

    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @Column(nullable = false)
    private String contrasenaUsuario;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaDeUltimaActualizacion;
}