import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

import { Pedido } from '../models/pedido';

const headers = new HttpHeaders().set('Content-Type', 'application/json');
const apiUrl = "/api/pedidos";

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient) { }

  getPedido(idPedido: number): Observable<Pedido> {
    return this.http.get<Pedido>(`${apiUrl}/${idPedido}`, {headers});
  }

  listPedidosByCliente(idCliente: number): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(`${apiUrl}/cliente/${idCliente}`, {headers});
  }

  listPedidos(): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(apiUrl, {headers});
  }

  createPedido (idCliente: string, pedido: Pedido): Observable<Pedido> {
    return this.http.post<Pedido>(`${apiUrl}/cliente/${idCliente}`, pedido, {headers});
  }
  
  updatePedido (id: number, pedido: Pedido): Observable<Pedido> {
    return this.http.put<Pedido>(`${apiUrl}/${id}`, pedido, {headers});
  }

  deletePedido (id: string, order: Pedido): Observable<Pedido> {
    return this.http.delete<Pedido>(`${apiUrl}/${id}`, {headers});
  }

}