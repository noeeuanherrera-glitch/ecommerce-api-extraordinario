package com.tienda.ecommerce.controller;

import com.tienda.ecommerce.entity.Pedido;
import com.tienda.ecommerce.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
@Tag(name = "Pedidos", description = "Endpoints para la gestión de pedidos")
public class PedidoController {

    private final PedidoService service;

    @GetMapping
    @Operation(summary = "Obtener todos los pedidos")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener pedido por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
            @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    })
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo pedido con artículos en cascada")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Pedido creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Petición inválida")
    })
    public ResponseEntity<Pedido> create(
            @RequestBody(
                    description = "Estructura JSON para crear un pedido con su cliente y artículos asociados (persistidos en cascada)",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = Pedido.class),
                            examples = @ExampleObject(
                                    value = "{\"fecha\": \"2026-08-12T10:00:00\", \"cliente\": {\"id\": 1}, \"articulos\": [{\"cantidad\": 2, \"precioUnitario\": 499.99, \"prenda\": {\"id\": 1}}]}"
                            )
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody Pedido pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedido));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar pedido por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pedido eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}