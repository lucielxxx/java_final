package idat.com.biblioteca.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroResponseDto {

    private Long idLibro;
    private String nombreLibro;
    private String autor;
    private Boolean estado;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeUltimaActualizacion;
}
