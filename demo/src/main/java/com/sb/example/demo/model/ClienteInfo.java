package com.sb.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class ClienteInfo {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    private String nome;

    private String sobrenome;

    private String usuario;

    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidoList;

}
