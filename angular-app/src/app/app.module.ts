import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ProduitComponent } from './produit/produit.component';
import { ProduitService } from 'src/app/produit.service';

@NgModule({
  declarations: [
    AppComponent,
    ProduitComponent
  ],
  imports: [
    BrowserModule , FormsModule , HttpClientModule
  ],
  providers: [ProduitService],
  bootstrap: [AppComponent]
})
export class AppModule { }
