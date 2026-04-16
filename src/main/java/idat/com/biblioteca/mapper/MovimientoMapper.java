package idat.com.biblioteca.mapper;

import idat.com.biblioteca.dto.request.MovimientoRequestDto;
import idat.com.biblioteca.dto.response.MovimientoResponseDto;
import idat.com.biblioteca.entity.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(target = "idMovimiento", ignore = true)
    @Mapping(target = "fechaDeCreacion", ignore = true)
    @Mapping(target = "fechaDeUltimaActualizacion", ignore = true)
    Movimiento toEntity(MovimientoRequestDto dto);

    @Mapping(target = "idLibro", source = "libro.idLibro")
    @Mapping(target = "idUsuario", source = "usuario.idUsuario")
    MovimientoResponseDto toResponseDto(Movimiento movimiento);
}