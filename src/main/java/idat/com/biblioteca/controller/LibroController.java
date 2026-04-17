package idat.com.biblioteca.controller;

import idat.com.biblioteca.dto.request.LibroRequestDto;
import idat.com.biblioteca.dto.response.LibroResponseDto;
import idat.com.biblioteca.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
@Tag(name = "Libros", description = "Operaciones para la gestión del catálogo de libros")
@SecurityRequirement(name = "bearerAuth")
public class LibroController {

    private final LibroService libroService;

    @Operation(summary = "Listar todos los libros", description = "Retorna el catálogo completo. Accesible para ADMIN y USER.")
    @GetMapping
    public ResponseEntity<List<LibroResponseDto>> listarLIbros(){
        return ResponseEntity.ok(libroService.ListarLibros());
    }

    @Operation(summary = "Obtener libro por ID", description = "Busca un libro específico en la base de datos. Accesible para ADMIN y USER.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libro encontrado"),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @GetMapping("/{idLibro}")
    public ResponseEntity<LibroResponseDto> listarLibroPorId(@PathVariable Long idLibro){
        return ResponseEntity.ok(libroService.listarLibroPorId(idLibro));
    }

    @Operation(summary = "Registrar nuevo libro", description = "Permite agregar un ejemplar al catálogo. **SÓLO ADMIN**.")
    @PostMapping
    public ResponseEntity<LibroResponseDto> crear(@Valid @RequestBody LibroRequestDto libroRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.crear(libroRequestDto));
    }

    @Operation(summary = "Actualizar libro", description = "Modifica la información de un libro existente. **SÓLO ADMIN**.")
    @PutMapping("/{idLibro}")
    public ResponseEntity<LibroResponseDto> actualizar(
            @PathVariable Long idLibro,
            @Valid @RequestBody LibroRequestDto libroRequestDto) {
        return ResponseEntity.ok(libroService.actualzar(idLibro, libroRequestDto));
    }

    @Operation(summary = "Eliminación lógica", description = "Desactiva un libro del catálogo sin borrarlo físicamente. **SÓLO ADMIN**.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Libro eliminado con éxito"),
            @ApiResponse(responseCode = "403", description = "Prohibido - No tienes permisos de administrador")
    })
    @DeleteMapping("/{idLibro}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idLibro) {
        libroService.eliminarLogico(idLibro);
        return ResponseEntity.noContent().build();
    }
}