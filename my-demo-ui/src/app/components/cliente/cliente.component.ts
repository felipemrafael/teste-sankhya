import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { flatMap, tap } from 'rxjs/operators';

import { ClienteService } from '../../services/cliente.service';
import { Cliente } from './../../models/cliente';

import { PedidoService } from './../../services/pedido.service';
import { Pedido } from './../../models/pedido';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styles: []
})
export class ClienteComponent implements OnInit {

  clientes: Cliente[] = [];

  constructor(
    private customerService: ClienteService, 
    private orderService: PedidoService) { }

  ngOnInit() {
    this.customerService.listClientes().pipe(
      tap(data => this.clientes = data),
      flatMap(customers => from(customers)),
      flatMap(customer => {
        return this.orderService.listPedidosByCliente(customer.id).pipe(
          tap((orders: Pedido[]) => {
            customer.pedidos = orders;
          })
        )
      })
     ).subscribe();
  }

}
