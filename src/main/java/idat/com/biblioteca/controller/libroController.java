package idat.com.biblioteca.controller;

import idat.com.biblioteca.dto.request.LibroRequestDto;
import idat.com.biblioteca.dto.response.LibroResponseDto;
import idat.com.biblioteca.service.LibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class libroController {

    private  final LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroResponseDto>> listarLIbros(){
        return ResponseEntity.ok(libroService.ListarLibros());
    }

    @GetMapping("/{idLibro}")
    public ResponseEntity<LibroResponseDto> listarLibroPorId(@PathVariable Long idLibro){
        return ResponseEntity.ok(libroService.listarLibroPorId(idLibro));
    }
    @PostMapping
    public ResponseEntity<LibroResponseDto> crear(@Valid @RequestBody LibroRequestDto libroRequestDto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(libroService.crear(libroRequestDto));
    }

    @PutMapping("/{idLibro}")
    public ResponseEntity<LibroResponseDto> actualizar(
            @PathVariable Long idLibro,
            @Valid @RequestBody LibroRequestDto libroRequestDto) {
        return ResponseEntity.ok(libroService.actualzar(idLibro, libroRequestDto));
    }

    // En libroController.java

    @DeleteMapping("/{idLibro}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idLibro) {
        libroService.eliminarLogico(idLibro);
        return ResponseEntity.noContent().build();
    }
}
