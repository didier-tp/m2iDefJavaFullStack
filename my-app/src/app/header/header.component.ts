import { Component, OnInit } from '@angular/core';
import { PreferencesService } from '../common/service/preferences.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(public preferencesService : PreferencesService) {
    //injection de dépendance via constructor angular
    //= équivalent à @Autowired de Spring
   }

  ngOnInit() {
    //équivalent angular d'une méthode java préfixée par @PostConstruct()
  }

}
