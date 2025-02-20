import { Pedido } from "./pedido";

export interface Cliente {
    id: number;
    nome: string;
    sobrenome: string;
    email: Date;
    pedidos?: Pedido[];
}