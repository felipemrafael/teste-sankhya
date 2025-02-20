package com.sb.example.demo.service.impl;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.ClienteInfo;
import com.sb.example.demo.model.Pedido;
import com.sb.example.demo.repository.ClienteRepository;
import com.sb.example.demo.repository.PedidoRepository;
import com.sb.example.demo.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ClienteRepository clienteRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Pedido getPedido(Long id) throws DoesNotExistException {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (!pedido.isPresent()) {
            throw new DoesNotExistException("Pedido");
        }
        return pedido.get();
    }

    public List<Pedido> getPedidosByCliente(Long clienteId) throws DoesNotExistException {
        List<Pedido> list = new ArrayList<>();
        ClienteInfo cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new DoesNotExistException("Cliente"));
        pedidoRepository.findByCliente(cliente).forEach(e -> list.add(e));
        return list;
    }

    public List<Pedido> getPedidos() {
        List<Pedido> list = new ArrayList<>();
        pedidoRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Pedido createPedido(Long clienteId, Pedido pedido) throws DoesNotExistException {
        ClienteInfo cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new DoesNotExistException("Cliente"));
        pedido.setCliente(cliente);
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Long id, Pedido pedido) throws DoesNotExistException {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id) throws DoesNotExistException {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new DoesNotExistException("Pedido"));
        pedidoRepository.delete(pedido);
    }


}
