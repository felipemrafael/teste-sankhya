import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

import { Cliente } from '../models/cliente';

const headers = new HttpHeaders().set('Content-Type', 'application/json');
const apiUrl = "/api/clientes";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  getCliente(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${apiUrl}/${id}`, {headers});
  }

  listClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(apiUrl, {headers});
  }

  createCliente (cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(apiUrl, cliente, {headers});
  }
  
  updateCliente (id: string, cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${apiUrl}/${id}`, cliente, {headers});
  }

  deleteCliente (id: number): Observable<Cliente> {
    return this.http.delete<Cliente>(`${apiUrl}/${id}`, {headers});
  }

}