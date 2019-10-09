import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tva',
  templateUrl: './tva.component.html',
  styleUrls: ['./tva.component.scss']
})
export class TvaComponent implements OnInit {

  ht : number;
  taux : number = 20;
  tva : number;
  ttc : number;

  tabTaux : number[] = [ 5 , 10 , 20 , 33];

  onCalculer(){
    this.tva = this.ht * this.taux / 100;
    this.ttc = Number(this.tva) + Number(this.ht);
  }

  constructor() { }

  ngOnInit() {
  }

}
