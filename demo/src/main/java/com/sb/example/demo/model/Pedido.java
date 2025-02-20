package com.sb.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteInfo cliente;

    private String produtoDesc;

    private LocalDate dataPedido;

    private Integer quantidade;

    private BigDecimal preco;

}
