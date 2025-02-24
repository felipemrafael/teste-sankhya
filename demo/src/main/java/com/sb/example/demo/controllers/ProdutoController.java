package com.sb.example.demo.controllers;

import com.sb.example.demo.exceptions.DoesNotExistException;
import com.sb.example.demo.model.Pedido;
import com.sb.example.demo.model.Produto;
import com.sb.example.demo.service.PedidoService;
import com.sb.example.demo.service.ProdutoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos/{id}")
    public Produto getProduto(@PathVariable Long id) throws DoesNotExistException {
        return produtoService.getProduto(id);
    }

    @GetMapping("/produtos")
    public List<Produto> listProdutos() {
        return produtoService.getProdutos();
    }


    @PostMapping("/produtos")
    public Produto createProduto(@Valid @RequestBody Produto produto) throws DoesNotExistException {
        return produtoService.createProduto(produto);
    }

    @PutMapping("/produtos/{id}")
    public Produto updateProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) throws DoesNotExistException {
        return produtoService.updateProduto(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public void deleteProduto(@PathVariable Long id) throws DoesNotExistException {
        produtoService.deleteProduto(id);
    }
}
