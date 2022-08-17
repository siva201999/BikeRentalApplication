import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BikedataComponent } from './bikedata/bikedata.component';
import { DisplaybikedetailsComponent } from './displaybikedetails/displaybikedetails.component';
import { UpdateComponent } from './update/update.component';


const routes: Routes = [
 {path:'update', component: UpdateComponent },
 {path:'search', component: DisplaybikedetailsComponent},
 {path:'bikedata/:id',component:BikedataComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
