package com.sb.example.demo.repository;

import com.sb.example.demo.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
