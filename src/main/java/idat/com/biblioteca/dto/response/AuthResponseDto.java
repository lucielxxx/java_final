package idat.com.biblioteca.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta que contiene el token de acceso tras una autenticación exitosa")
public class AuthResponseDto {

    @Schema(
            description = "Token JWT (JSON Web Token) para autorizar las peticiones posteriores",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    )
    private String token;
}