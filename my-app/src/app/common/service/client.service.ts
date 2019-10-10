import { Injectable } from '@angular/core';
import { Client } from '../data/login';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private tempClients = [
    new Client("user1","pwd1","user"),
    new Client("user2","pwd2","admin") , 
    new Client("user3","pwd3","admin")
  ]

  public rechercherClients() : Observable< Client[] > {
    return of(this.tempClients);
  }

  constructor() { }
}
