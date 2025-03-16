import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'leads', loadChildren: () => import('./modules/leads/leads.module').then(m => m.LeadsModule) },
  { path: '', redirectTo: '/leads', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
