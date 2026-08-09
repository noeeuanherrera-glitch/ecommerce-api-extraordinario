package com.tienda.ecommerce.mapper;
import com.tienda.ecommerce.entity.Prenda;
import com.tienda.ecommerce.dto.PrendaDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PrendaMapper {
    PrendaDTO toDTO(Prenda entity);
    Prenda toEntity(PrendaDTO dto);
}