import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LeadsComponent } from './leads.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: LeadsComponent }
];

@NgModule({
  declarations: [
    LeadsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class LeadsModule { }
