import { Injectable } from '@angular/core';
import { Observable, of } from '../../node_modules/rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor() { }

  public getNewsViaRest$(numNews : number) : Observable<object> {
       return of( { id : numNews ,
                   title : "title ...",
                   text : "blabla..." });
      //http.get(url_ws)
  }
}
