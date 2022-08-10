import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import {HttpClientModule} from '@angular/common/http';
import { AdminDashBoardComponent } from './Mycomponents/admin/admin-dash-board/admin-dash-board.component';
import { RenterDashBoardComponent } from './Mycomponents/renter-dash-board/renter-dash-board.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';
import { SideNavComponent } from './Mycomponents/admin/side-nav/side-nav.component';
import { BodyComponent } from './Mycomponents/admin/body/body.component';
import { AdminDashboardContentComponent } from './Mycomponents/admin/admin-dashboard-content/admin-dashboard-content.component';
import { TopbarComponent } from './Mycomponents/admin/topbar/topbar.component';
import { AllCustomersComponent } from './Mycomponents/admin/all-customers/all-customers.component';
import { RenterDetailsComponent } from './Mycomponents/admin/renter-details/renter-details.component';
import { BikeDetailsComponent } from './Mycomponents/admin/bike-details/bike-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminDashBoardComponent,
    RenterDashBoardComponent,
    SignupComponent,
    SideNavComponent,
    BodyComponent,
    AdminDashboardContentComponent,
    TopbarComponent,
    AllCustomersComponent,
    RenterDetailsComponent,
    BikeDetailsComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule, 
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
