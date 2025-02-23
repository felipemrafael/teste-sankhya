import { Cliente } from "./cliente.model";
import { Produto } from "./produto.model";

export class Pedido{
  id?: number;
  cliente?: Cliente;
  totalCompra?: number;
  dataCompra?: Date;
  produtos?: Produto[] = [];

  constructor(id?: number, cliente?: Cliente, totalCompra?: number, dataCompra?: Date, produtos?: Produto[]){
    this.id = id;
    this.cliente = cliente;
    this.totalCompra = totalCompra;
    this.dataCompra = new Date(dataCompra);
    this.produtos = produtos;
  }
}
