import { Injectable } from '@angular/core';
import { Observable, of } from '../../node_modules/rxjs';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DeviseService {

  constructor(private http : HttpClient) { }

  public convertirViaRest$(montant : number,
                          codeMonnaieSource:string,
                          codeMonnaieCible : string) : Observable<object> {
       //rest/devise/conversion?montant=100&source=EUR&cible=USD
      let url_ws="./rest/devise/conversion?montant=" + montant
              + "&source=" +codeMonnaieSource 
              + "&cible=" +codeMonnaieCible ;
      return this.http.get(url_ws);
  }
}
