import { Injectable } from '@angular/core';
import { Produit } from 'src/app/produit';
import { Observable , of} from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http : HttpClient) { }

  public rechercherProduit$(prixMaxi : number) : Observable<Produit[]> {
  /*  //version preliminaire (simulation)
     let tabProduit = [
       { numero : 1 , label : "produit 1" , prix : prixMaxi -1 } ,
       { numero : 2 , label : "produit 2" , prix : prixMaxi }
     ]
     return of(tabProduit);
     */
     let wsUrl = "http://localhost:8080/serveurRestSpringMvc/"
             + "rest/produit?prixMaxi=" + prixMaxi;
    return this.http.get<Produit[]>(wsUrl );
  }

}
