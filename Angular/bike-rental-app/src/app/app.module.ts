import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import {HttpClientModule} from '@angular/common/http';
import { AdminDashBoardComponent } from './Mycomponents/admin/admin-dash-board/admin-dash-board.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';
import { SideNavComponent } from './Mycomponents/admin/side-nav/side-nav.component';
import { BodyComponent } from './Mycomponents/admin/body/body.component';
import { AdminDashboardContentComponent } from './Mycomponents/admin/admin-dashboard-content/admin-dashboard-content.component';
import { TopbarComponent } from './Mycomponents/admin/topbar/topbar.component';
import { AllCustomersComponent } from './Mycomponents/admin/all-customers/all-customers.component';
import { RenterDetailsComponent } from './Mycomponents/admin/renter-details/renter-details.component';
import { BikeDetailsComponent } from './Mycomponents/admin/bike-details/bike-details.component';
import { AddBikesComponent } from './Mycomponents/Renter/add-bikes/add-bikes.component';
import { EarningsComponent } from './Mycomponents/Renter/earnings/earnings.component';
import { EditBikesComponent } from './Mycomponents/Renter/edit-bikes/edit-bikes.component';
import { RenterDashboardComponent } from './Mycomponents/Renter/renter-dashboard/renter-dashboard.component';
import { RenterProfileComponent } from './Mycomponents/Renter/renter-profile/renter-profile.component';
import { RenterSidenavComponent } from './Mycomponents/Renter/renter-sidenav/renter-sidenav.component';
import { RenterDashboardContentComponent } from './Mycomponents/Renter/renter-dashboard-content/renter-dashboard-content.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminDashBoardComponent,
    SignupComponent,
    SideNavComponent,
    BodyComponent,
    AdminDashboardContentComponent,
    TopbarComponent,
    AllCustomersComponent,
    RenterDetailsComponent,
    BikeDetailsComponent,
    AddBikesComponent,
    EarningsComponent,
    EditBikesComponent,
    RenterDashboardComponent,
    RenterProfileComponent,
    RenterSidenavComponent,
    RenterDashboardContentComponent,
  
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
