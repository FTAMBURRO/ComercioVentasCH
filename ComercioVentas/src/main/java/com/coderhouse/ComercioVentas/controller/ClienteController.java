package com.coderhouse.ComercioVentas.controller;

import com.coderhouse.ComercioVentas.service.ClienteService;
import com.coderhouse.ComercioVentas.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteService.obtenerClientePorId(id);
        if (clienteExistente.isPresent()) {
            cliente.setId(id);
            Cliente clienteActualizado = clienteService.guardarCliente(cliente);
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

   

    // Otros métodos para GET, PUT, DELETE según sea necesario
}
