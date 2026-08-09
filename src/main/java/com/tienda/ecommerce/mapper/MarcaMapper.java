package com.tienda.ecommerce.mapper;
import com.tienda.ecommerce.entity.Marca;
import com.tienda.ecommerce.dto.MarcaDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface MarcaMapper {
    MarcaDTO toDTO(Marca entity);
    Marca toEntity(MarcaDTO dto);
}