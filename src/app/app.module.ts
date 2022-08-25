import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { filter } from 'rxjs';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UpdateComponent } from './update/update.component';
import { HttpClientModule } from '@angular/common/http';
import { BodyComponent } from './body/body.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { TopbarComponent } from './topbar/topbar.component';
import { DisplaybikedetailsComponent } from './displaybikedetails/displaybikedetails.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { BikedataComponent } from './bikedata/bikedata.component';
import { RentalComponent } from './rentnow/rentnow.component';
@NgModule({
  declarations: [
    AppComponent,
    UpdateComponent,
    BodyComponent,
    SidenavComponent,
    TopbarComponent,
    DisplaybikedetailsComponent,
    BikedataComponent,
    RentalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
