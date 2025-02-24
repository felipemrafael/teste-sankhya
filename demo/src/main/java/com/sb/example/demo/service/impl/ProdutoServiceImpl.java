package com.sb.example.demo.service.impl;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.Produto;
import com.sb.example.demo.repository.ProdutoRepository;
import com.sb.example.demo.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto getProduto(Long id) throws DoesNotExistException {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (!produto.isPresent()) {
            throw new DoesNotExistException("Produto");
        }
        return produto.get();
    }

    public List<Produto> getProdutos() {
        List<Produto> list = new ArrayList<>();
        produtoRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Produto createProduto(Produto produto) throws DoesNotExistException {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Produto produto) throws DoesNotExistException {
        produtoRepository.findById(produto.getId()).orElseThrow(() -> new DoesNotExistException("Produto"));
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id) throws DoesNotExistException {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new DoesNotExistException("Produto"));
        produtoRepository.delete(produto);
    }


}
