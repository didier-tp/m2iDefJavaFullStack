import { Injectable } from '@angular/core';
import { Produit } from 'src/app/produit';
import { Observable , of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http : HttpClient) { }

  public rechercherProduit$(prixMaxi : number) : Observable<Produit[]> {
     //return this.rechercherProduitSimu$(prixMaxi);
     return this.rechercherProduitHttp$(prixMaxi);
  }

  public rechercherProduitSimu$(prixMaxi : number) : Observable<Produit[]> {
     let tabProduit = [
       { numero : 1 , label : "produit 1" , prix : prixMaxi -1 } ,
       { numero : 2 , label : "produit 2" , prix : prixMaxi }
     ]
     return of(tabProduit)
          /* .pipe(
             filter()
           );*/
   }

   public rechercherProduitHttp$(prixMaxi : number) : Observable<Produit[]> {
    /* let wsUrl = "http://localhost:8080/serveurRestSpringMvc/"
             + "rest/produit"; */
    let wsUrl = "./rest/produit"; //url relative (ok si option
                                // --proxy.config proxy.conf.json de ng serve)
    if(prixMaxi!=null){
      wsUrl+="?prixMaxi=" + prixMaxi;
      }
    return this.http.get<Produit[]>(wsUrl );
                  /*  .pipe(
                      map((tabP:Produit[])=>{
                           return tabP.map(
                               (p)=>{p.label = p.label.toUpperCase(); return p;}
                             );
                          })
                    );//end-of-pipe */
  }

  private _headers = new HttpHeaders({'Content-Type': 'application/json'});

  public postProduit$(produit: Produit) : Observable<Produit> {
      let wsUrl = "./rest/produit";
      return this.http.post<Produit>(wsUrl,
                                     produit,
                                     {headers:this._headers});
  }












}
