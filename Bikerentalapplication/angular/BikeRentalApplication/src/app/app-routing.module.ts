import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplaybikedetailsComponent } from './displaybikedetails/displaybikedetails.component';
import { AddbikesComponent } from './Renter/addbikes/addbikes.component';
import { EarningsComponent } from './Renter/earnings/earnings.component';
import { EditbikesComponent } from './Renter/editbikes/editbikes.component';
import { RenterdashboardComponent } from './Renter/renterdashboard/renterdashboard.component';
import { RenterprofileComponent } from './Renter/renterprofile/renterprofile.component';

const routes: Routes = [
  {path:'dashboard',component:RenterdashboardComponent},
   {path:'', redirectTo:'dashboard', pathMatch:'full'},
//  // {path:'dashboard', component:DashboardComponent},
   {path:'profile', component:RenterprofileComponent},
   {path:'update/:id', component:EditbikesComponent},
   {path:'addBikes', component:AddbikesComponent},
   {path:'displayBike/:id', component:DisplaybikedetailsComponent},
   {path:'earnings', component:EarningsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routinngComponents=[RenterdashboardComponent,RenterprofileComponent,AddbikesComponent,EarningsComponent]
