package idat.com.biblioteca.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroRequestDto {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50,message = "no puede superar mas de  50 caracteres")
    private String nombreLibro;

    @NotBlank(message = "El cambpo es obligatorio")
    @Size(max = 50 , message = " no puede tener mas de  50 caracteres")
    private String autor;

    private Boolean estado; // Añadimos esto para permitir el cambio manual

}
