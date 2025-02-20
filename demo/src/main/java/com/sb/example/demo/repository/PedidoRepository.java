package com.sb.example.demo.repository;

import com.sb.example.demo.model.ClienteInfo;
import com.sb.example.demo.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository  extends CrudRepository<Pedido, Long> {

    List<Pedido> findByCliente(ClienteInfo cliente);

}
