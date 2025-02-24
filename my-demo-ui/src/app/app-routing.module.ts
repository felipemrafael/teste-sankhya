import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientesComponent } from './componentes/clientes/clientes.component';
import { PedidosComponent } from './componentes/pedidos/pedidos.component';
import { ProdutosComponent } from './componentes/produtos/produtos.component';

const routes: Routes = [
  {path: "", component: ClientesComponent},
  {path: "clientes", component: ClientesComponent},
  {path: "produtos", component: ProdutosComponent},
  {path: "pedidos", component: PedidosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
