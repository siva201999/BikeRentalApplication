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
  profileLogo=this.config.image;
  localItem=localStorage.getItem("Email");
  name=JSON.parse(localStorage.getItem('userName')!);
  constructor(private router:Router) { }

  ngOnInit(): void {
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
