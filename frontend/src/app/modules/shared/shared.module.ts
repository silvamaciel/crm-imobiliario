import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [CommonModule],
  exports: [CommonModule] // Exportamos para outros módulos usarem
})
export class SharedModule { }
