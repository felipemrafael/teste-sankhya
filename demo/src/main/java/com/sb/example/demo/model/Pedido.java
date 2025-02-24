package com.sb.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteInfo cliente;

    private Double totalCompra;

    private LocalDate dataCompra;

    @ManyToMany
    @JoinTable(name = "produto_pedido",
            joinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id",
                    referencedColumnName = "id"))
    private List<Produto> produtos;

}
