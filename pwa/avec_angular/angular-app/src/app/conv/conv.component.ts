import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-conv',
  templateUrl: './conv.component.html',
  styleUrls: ['./conv.component.css']
})
export class ConvComponent implements OnInit {

  private montantEuro : number ;
  private montantFranc : number;

  public onConversion(event:any){
    this.montantFranc = 6.5597 * Number(this.montantEuro);
  }

  constructor() { }

  ngOnInit() {
  }

}
