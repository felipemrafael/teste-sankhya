package com.sb.example.demo.service;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido getPedido(Long id) throws DoesNotExistException ;

    List<Pedido> getPedidosByCliente(Long clienteId) throws DoesNotExistException ;

    List<Pedido> getPedidos();

    Pedido createPedido(Long clienteId, Pedido pedido) throws DoesNotExistException ;

    Pedido updatePedido(Long id, Pedido pedido) throws DoesNotExistException ;

    void deletePedido(Long id) throws DoesNotExistException;
}
