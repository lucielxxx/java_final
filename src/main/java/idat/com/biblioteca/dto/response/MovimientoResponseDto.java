package idat.com.biblioteca.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class MovimientoResponseDto {
    private Long idMovimiento;
    private Long idLibro;
    private Long idUsuario;
    private Integer tipoSolicitud;
    private String observaciones;
    private LocalDateTime fechaDeCreacion;
}