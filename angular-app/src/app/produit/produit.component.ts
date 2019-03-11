import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/produit';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {

  private prixMaxi : number ;//= 50;

  //private  tabProduit : Array<object>;
  private  tabProduit : Array<Produit>;

  public onRechercheProd(event : any):void {
    console.log("onRechercheProd , prixMaxi="+this.prixMaxi);
    //...
  }

  constructor() { }

  ngOnInit() {
  }

}
