package com.sb.example.demo.service;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto getProduto(Long id) throws DoesNotExistException ;

    List<Produto> getProdutos();

    Produto createProduto(Produto produto) throws DoesNotExistException ;

    Produto updateProduto(Produto produto) throws DoesNotExistException ;

    void deleteProduto(Long id) throws DoesNotExistException;
}
