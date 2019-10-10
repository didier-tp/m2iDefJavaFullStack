import { Component, OnInit } from '@angular/core';
import { Login } from '../common/data/login';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login : Login = new Login();

  onLogin(){
    console.log(JSON.stringify(this.login));
  }



  constructor() { }

  ngOnInit() {
  }

}
