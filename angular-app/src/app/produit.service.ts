import { Injectable } from '@angular/core';
import { Produit } from 'src/app/produit';
import { Observable , of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor() { }

  public rechercherProduit$(prixMaxi : number) : Observable<Produit[]> {
    //version preliminaire (simulation)
     let tabProduit = [
       { numero : 1 , label : "produit 1" , prix : 50.0 } ,
       { numero : 2 , label : "produit 2" , prix : 60.0 }
     ]
     return of(tabProduit);
  }

}
