import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule, routinngComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BodyComponent } from './Renter/body/body.component';
import { SidenavComponent } from './Renter/sidenav/sidenav.component';
import { AddbikesComponent } from './Renter/addbikes/addbikes.component';
import { RenterprofileComponent } from './Renter/renterprofile/renterprofile.component';
import { EarningsComponent } from './Renter/earnings/earnings.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { HttpClientModule } from '@angular/common/http';
import { RenterserviceService } from './Renter/services/renterservice.service';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { EditbikesComponent } from './Renter/editbikes/editbikes.component';
import { DisplaybikedetailsComponent } from './displaybikedetails/displaybikedetails.component';



@NgModule({
  declarations: [
    AppComponent,
    AddbikesComponent,
    routinngComponents,
    BodyComponent ,
    SidenavComponent,
    RenterprofileComponent,
    EarningsComponent,
    EditbikesComponent,
    DisplaybikedetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [RenterserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
