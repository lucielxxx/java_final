package idat.com.biblioteca.mapper;

import idat.com.biblioteca.dto.request.UsuarioRequestDto;
import idat.com.biblioteca.dto.response.UsuarioResponseDto;
import idat.com.biblioteca.entity.Usuario;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "nombreUsuario", ignore = true)
    @Mapping(target = "contrasenaUsuario", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaDeCreacion", ignore = true)
    @Mapping(target = "fechaDeUltimaActualizacion", ignore = true)
    Usuario toEntity(UsuarioRequestDto dto);

    UsuarioResponseDto toResponseDto(Usuario usuario);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "nombreUsuario", ignore = true)
    @Mapping(target = "contrasenaUsuario", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaDeCreacion", ignore = true)
    @Mapping(target = "fechaDeUltimaActualizacion", ignore = true)
    void actualizarFromRequest(UsuarioRequestDto dto, @MappingTarget Usuario usuario);

    List<UsuarioResponseDto> toResponseList(List<Usuario> usuarios);
}