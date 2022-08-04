import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import {HttpClientModule} from '@angular/common/http';
import { AdminDashBoardComponent } from './Mycomponents/admin-dash-board/admin-dash-board.component';
import { RenterDashBoardComponent } from './Mycomponents/renter-dash-board/renter-dash-board.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminDashBoardComponent,
    RenterDashBoardComponent,
    SignupComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule, 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
