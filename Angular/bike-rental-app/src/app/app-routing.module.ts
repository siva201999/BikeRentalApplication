import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashBoardComponent } from './Mycomponents/admin-dash-board/admin-dash-board.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import { RenterDashBoardComponent } from './Mycomponents/renter-dash-board/renter-dash-board.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path:'admin/dashboard', component: AdminDashBoardComponent},
  {path:'renter/dashboard', component: RenterDashBoardComponent},
  {path:'signup', component: SignupComponent},
  {path:'signup', component: SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
