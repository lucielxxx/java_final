package idat.com.biblioteca.mapper;
import idat.com.biblioteca.dto.request.LibroRequestDto;
import idat.com.biblioteca.dto.response.LibroResponseDto;
import idat.com.biblioteca.entity.Libro;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibroMapper {

    @Mapping(target = "idLibro", ignore = true)
    @Mapping(target = "estado", constant = "true")
    @Mapping(target = "fechaDeCreacion", ignore = true)
    @Mapping(target = "fechaDeUltimaActualizacion", ignore = true)
    Libro toEntity (LibroRequestDto libroResponseDto);
    LibroResponseDto toResponseDto(Libro libro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "idLibro", ignore = true)
    //@Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaDeCreacion", ignore = true)
    @Mapping(target = "fechaDeUltimaActualizacion", ignore = true)
    void actualizarFromRequest(LibroRequestDto libroRequestDto, @MappingTarget Libro libro);

    List<LibroResponseDto> toResponseList(List<Libro> libros);

}
