import { Component, OnInit } from '@angular/core';
import { Login, AuthResponse } from '../common/data/login';
import { ClientService } from '../common/service/client.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login : Login = new Login();
  message : string =null;
  onLogin(){
    this.message=null;
    console.log(JSON.stringify(this.login));
    this.clientService.postLogin(this.login)
         .subscribe(
           (authResp : AuthResponse)=>{ this.gererAuthResponse(authResp); },
           (err)=>{ this.message ="echec technique http (pas ok/200)"}
         );
  }

  private gererAuthResponse(authResp : AuthResponse){
       this.message = authResp.message;
       console.log(JSON.stringify(authResp));
  }

  constructor(private clientService : ClientService) { }

  ngOnInit() {
  }

}
