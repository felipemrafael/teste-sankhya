package com.sb.example.demo.service;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.ClienteInfo;

import java.util.List;

public interface ClienteService {

    ClienteInfo getCliente(Long id) throws DoesNotExistException;

    List<ClienteInfo> getClientes() ;

    ClienteInfo createCliente(ClienteInfo cliente) ;

    ClienteInfo updateCliente(Long id, ClienteInfo cliente) throws DoesNotExistException ;

    void deleteCliente(Long id) throws DoesNotExistException ;

}
