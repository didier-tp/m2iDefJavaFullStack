import { Component, OnInit } from '@angular/core';
import { DeviseService } from '../devise.service';

@Component({
  selector: 'app-conv2',
  templateUrl: './conv2.component.html',
  styleUrls: ['./conv2.component.css']
})
export class Conv2Component implements OnInit {

  public montant : number ;
  public montantConverti : number;
  public monnaieSource : string = "EUR" ;
  public monnaieCible : string = "USD";

  public onConversion(event:any){
    this.deviseService.convertirViaRest$(this.montant,
                                        this.monnaieSource ,
                                         this.monnaieCible)
                      .subscribe( (resConv) => { this.montantConverti = resConv['montantCible']; });
  }

  constructor(private deviseService : DeviseService) { }

  ngOnInit() {
  }

}
