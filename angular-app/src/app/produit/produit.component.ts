import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/produit';
import { ProduitService } from 'src/app/produit.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {

  private prixMaxi : number = 1000;
  private nouveauProduit : Produit = new Produit();

  //private  tabProduit : Array<object>;
  private  tabProduit : Array<Produit> = [];

  public onAjoutProd(event : any):void {
    this.produitService.postProduit$(this.nouveauProduit)
            .subscribe((prodAjoute) =>{
                  console.log("produit ajoute cote serveur:"
                              + JSON.stringify(prodAjoute));
                  this.tabProduit.push(prodAjoute);
                } ,
                (err) => { this.affError(err);  }
              )
        //objetObservable.subscribe(callbackSuccess , callbackErreur)
  }

  private affError(err){
    console.log("erreur detaillée:" + JSON.stringify(err));
    console.log("message erreur technique:" + JSON.stringify(err));
    alert("erreur de communication avec le serveur");
  }

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
         .subscribe((tabProd)=>{ this.tabProduit = tabProd; } ,
                    (err) => { this.affError(err);  }
                  );
  }


  ngOnInit() {
  }

}
