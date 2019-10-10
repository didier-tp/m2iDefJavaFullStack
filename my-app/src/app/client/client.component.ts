import { Component, OnInit } from '@angular/core';
import { Client } from '../common/data/login';
import { ClientService } from '../common/service/client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  constructor(private clientService : ClientService) { }

  clients : Client[] = [];
  message : string;

  onLoadClient(){
    this.clientService.rechercherClients()
        .subscribe(
             (listeCli : Client[]) => { this.clients = listeCli; } ,
             (err) => { console.log(err); }
        );
  }

  ngOnInit() {
  }

}
