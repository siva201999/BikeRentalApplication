import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from 'src/app/config';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit {
  config:Config["Signup"]=new Config().Signup;
  renter:Config['RenterObj']=new Config().RenterObj;
  customer:Config['CustomerObj']=new Config().CustomerObj;
  profileLogo=this.config.image;
  localItem=localStorage.getItem("Email");
  name=JSON.parse(localStorage.getItem('userName')!);
  role=JSON.parse(localStorage.getItem('Role')!);
  
  constructor(private router:Router) { }

  ngOnInit(): void {
    console.log(this.role);
    // if(this.role==='renter'){
    //   this.profileLogo=this.renter.image;
    //   console.log(this.profileLogo);
    // }
    // else if(this.role==='customer'){
    //   this.profileLogo=this.customer.image;
    // }
    // else{
    //   this.profileLogo=this.config.image;
    // }
  }

  logout(){
    if(this.localItem){
      localStorage.removeItem("Email");
      localStorage.removeItem("userId");
      localStorage.removeItem("userName");
      localStorage.removeItem("RenterBikes");
      this.router.navigate(['']);
    }
    
  }
}
