import { Injectable } from '@angular/core';
import { Client, Login, AuthResponse } from '../data/login';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  private _headers = new HttpHeaders({'Content-Type': 'application/json'});
  
  public postLogin(login:Login) : Observable<AuthResponse> {
     let wsUrl = "backend-spring/rest/client/verifAuth";
     return this.http.post<AuthResponse>(wsUrl,
                                        login,
                                        {headers: this._headers});
  }

  public rechercherClients() : Observable< Client[] > {
    //return of(this.tempClients);
    let wsUrl = "backend-spring/rest/client";
    //NB: cette url sera préfixée par http://localhost:8080 ou autre
    //selon proxy.conf.json (ng serve --proxy-config )
    return this.http.get<Client[]>(wsUrl);
  }

  /*
  private tempClients = [
    new Client("user1","pwd1","user"),
    new Client("user2","pwd2","admin") , 
    new Client("user3","pwd3","admin")
  ]*/
  
}
