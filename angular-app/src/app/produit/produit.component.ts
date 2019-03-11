import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/produit';
import { ProduitService } from 'src/app/produit.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {

  private prixMaxi : number ;//= 50;

  //private  tabProduit : Array<object>;
  private  tabProduit : Array<Produit>;


  constructor(private produitService : ProduitService) {
    //NB1: au sens langage typescript (.ts) , si on passe
    //un paramètre public ou privée au constructeur , la chose
    //devient automatiquement un attribut de cette classe

    //NB2: au sens interprétation angular , un élément passé dans un
    //constructeur déclenche une injection de dépendance
    //ressemblant à @Autowired de Spring/java
   }

  public onRechercheProd(event : any):void {
    console.log("onRechercheProd , prixMaxi="+this.prixMaxi);
    this.produitService.rechercherProduit$(this.prixMaxi)
         .subscribe((tabProd)=>{ this.tabProduit = tabProd; })
    //...
  }



  ngOnInit() {
  }

}
