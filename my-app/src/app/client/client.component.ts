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

  onSupprimer(c:Client){
    this.clientService.deleteClient(c.numero)
         .subscribe(
           (msgObj) => { console.log(JSON.stringify(msgObj)); 
                        this.message="suppression ok " + JSON.stringify(msgObj);
                        this.onLoadClient(); },
           (err) => { console.log("err:"+JSON.stringify(err)); 
                      this.message="echec suppression"; }
         );
  }

  onLoadClient(){
    this.message=null;
   
    this.clientService.rechercherClients()
        .subscribe(
             (listeCli : Client[]) => { this.clients = listeCli; } ,
             (err) => {  this.clients = []; console.log(err);
                        this.message="echec " }
        );
  }

  ngOnInit() {
  }

}
