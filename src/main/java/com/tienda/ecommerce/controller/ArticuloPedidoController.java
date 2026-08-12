package com.tienda.ecommerce.controller;

import com.tienda.ecommerce.entity.ArticuloPedido;
import com.tienda.ecommerce.service.ArticuloPedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos-pedido")
@RequiredArgsConstructor
@Tag(name = "ArticulosPedido", description = "Endpoints para los artículos de pedidos")
public class ArticuloPedidoController {

    private final ArticuloPedidoService service;

    @GetMapping
    @Operation(summary = "Obtener todos los artículos de pedido")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public ResponseEntity<List<ArticuloPedido>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener artículo de pedido por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Artículo encontrado"),
            @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    })
    public ResponseEntity<ArticuloPedido> findById(@PathVariable Integer id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo artículo de pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Artículo creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Petición inválida")
    })
    public ResponseEntity<ArticuloPedido> create(@RequestBody ArticuloPedido articulo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(articulo));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar artículo de pedido por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Artículo eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}