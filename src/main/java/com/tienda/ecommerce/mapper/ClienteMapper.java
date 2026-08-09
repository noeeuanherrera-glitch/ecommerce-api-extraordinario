package com.tienda.ecommerce.mapper;
import com.tienda.ecommerce.entity.Cliente;
import com.tienda.ecommerce.dto.ClienteDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente entity);
    Cliente toEntity(ClienteDTO dto);
}