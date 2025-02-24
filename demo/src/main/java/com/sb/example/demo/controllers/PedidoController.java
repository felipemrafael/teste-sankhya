package com.sb.example.demo.controllers;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.Pedido;
import com.sb.example.demo.service.PedidoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedidos/{id}")
    public Pedido getPedido(@PathVariable Long id) throws DoesNotExistException {
        return pedidoService.getPedido(id);
    }

    @GetMapping("/pedidos")
    public List<Pedido> listPedidos() {
        return pedidoService.getPedidos();
    }

    @GetMapping("/pedidos/cliente/{id}")
    public List<Pedido> listPedidosByCliente(@PathVariable Long id) throws DoesNotExistException {
        return pedidoService.getPedidosByCliente(id);
    }

    @PostMapping("/pedidos/cliente/{id}")
    public Pedido createPedido(@PathVariable Long id, @Valid @RequestBody Pedido pedido) throws DoesNotExistException {
        return pedidoService.createPedido(id, pedido);
    }

    @PutMapping("/pedidos/{id}")
    public Pedido updatePedido(@PathVariable Long id, @Valid @RequestBody Pedido pedido) throws DoesNotExistException {
        return pedidoService.updatePedido(id, pedido);
    }

    @DeleteMapping("/pedidos/{id}")
    public void deletePedido(@PathVariable Long id) throws DoesNotExistException {
        pedidoService.deletePedido(id);
    }
}
