import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BasicComponent } from './basic/basic.component';
import { TvaComponent } from './basic/tva/tva.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ClientComponent } from './client/client.component';
import { HttpClientModule } from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { MyAuthInterceptor } from './common/interceptor/MyAuthInterceptor';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BasicComponent,
    TvaComponent,
    LoginComponent,
    ClientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    TabsModule.forRoot(),
    HttpClientModule
  ],
  providers: [{
      provide: HTTP_INTERCEPTORS,
      useClass: MyAuthInterceptor,
      multi: true
      }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
