import { Component, OnInit } from '@angular/core';
import { PreferencesService } from '../common/service/preferences.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  listeCouleurs = [ 'yellow' , 'green' , 'red' , 'blue'];

  constructor(public preferencesService : PreferencesService) { }

  ngOnInit() {
  }

}
