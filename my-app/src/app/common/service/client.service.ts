import { Injectable } from '@angular/core';
import { Client } from '../data/login';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }


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
