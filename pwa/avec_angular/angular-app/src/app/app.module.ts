import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';
import { NewsComponent } from './news/news.component';
import { ConvComponent } from './conv/conv.component';

import { FormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NewsService } from 'src/app/news.service';
import { HttpClientModule } from '@angular/common/http';
import { Conv2Component } from './conv2/conv2.component';
import { DeviseService } from './devise.service';

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    ConvComponent,
    Conv2Component
  ],
  imports: [
    BrowserModule,FormsModule,NgbModule,HttpClientModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
  ],
  providers: [ NewsService , DeviseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
