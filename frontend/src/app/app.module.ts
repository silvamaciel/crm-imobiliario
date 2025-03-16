import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent], // Declara os componentes usados
  imports: [BrowserModule], // Importa módulos essenciais
  bootstrap: [AppComponent], // Define o componente raiz
})
export class AppModule {}
