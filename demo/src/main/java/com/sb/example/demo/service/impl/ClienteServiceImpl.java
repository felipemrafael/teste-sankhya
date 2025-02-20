package com.sb.example.demo.service.impl;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.ClienteInfo;
import com.sb.example.demo.model.Pedido;
import com.sb.example.demo.repository.ClienteRepository;
import com.sb.example.demo.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteInfo getCliente(Long id) throws DoesNotExistException {
        Optional<ClienteInfo> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()) {
            throw new DoesNotExistException("Cliente");
        }
        return cliente.get();
    }

    public List<ClienteInfo> getClientes() {
        List<ClienteInfo> list = new ArrayList<>();
        clienteRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public ClienteInfo createCliente(ClienteInfo cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteInfo updateCliente(Long id, ClienteInfo cliente) throws DoesNotExistException {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) throws DoesNotExistException {
        ClienteInfo cliente = clienteRepository.findById(id).orElseThrow(() -> new DoesNotExistException("Cliente"));
        clienteRepository.delete(cliente);
    }
}
