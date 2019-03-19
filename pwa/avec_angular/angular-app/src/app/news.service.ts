import { Injectable } from '@angular/core';
import { Observable, of } from '../../node_modules/rxjs';
import { HttpClient } from "@angular/common/http";

@Injectable({  providedIn: 'root'})
export class NewsService {
  constructor(private http : HttpClient) { }
  public getNewsViaRest$(numNews : number) : Observable<object> {
       /*return of( { id : numNews ,title : "title ...", text : "blabla..." });*/
      /*
      NB: url absolue (déconseillée) de type http://localhost:8282/news
          nécessitant autorisations CORS du coté serveur
          url relative nécessitant option --proxy-config proxy.conf.json
          de ng serve (en mode developpement)
          ou bien réajustement d'URL équivalent en mode production
      */
      //let url_ws="./news/" + numNews; //version nodejs
      let  url_ws="./rest/news/" + numNews; //version java / springMvc
      return this.http.get(url_ws);
  }
}
