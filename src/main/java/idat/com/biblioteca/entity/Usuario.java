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
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false)
    private String rol; // "admin" o "user"

    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasena_usuario", nullable = false)
    private String contrasenaUsuario;

    @Column(name = "fecha_de_creacion", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @Column(name = "fecha_de_ultima_actualizacion", nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaDeUltimaActualizacion;
}