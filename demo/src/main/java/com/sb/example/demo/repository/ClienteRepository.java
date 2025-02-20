package com.sb.example.demo.repository;

import com.sb.example.demo.model.ClienteInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteInfo, Long> {
}
