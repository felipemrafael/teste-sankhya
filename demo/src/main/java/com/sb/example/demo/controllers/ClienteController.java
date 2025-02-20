package com.sb.example.demo.controllers;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.ClienteInfo;
import com.sb.example.demo.service.ClienteService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes/{id}")
    public ClienteInfo getCliente(@PathVariable Long id) throws DoesNotExistException {
        return clienteService.getCliente(id);
    }

    @GetMapping("/clientes")
    public List<ClienteInfo> listClientes() {
            return clienteService.getClientes();
    }

    @PostMapping("/clientes")
    public ClienteInfo createCliente(@Valid @RequestBody ClienteInfo cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ClienteInfo updateCliente(@PathVariable Long id, @Valid @RequestBody ClienteInfo cliente) throws DoesNotExistException {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable Long id) throws DoesNotExistException {
        clienteService.deleteCliente(id);
    }

}
