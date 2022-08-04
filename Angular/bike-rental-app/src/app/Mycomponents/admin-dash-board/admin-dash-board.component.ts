import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-dash-board',
  templateUrl: './admin-dash-board.component.html',
  styleUrls: ['./admin-dash-board.component.css']
})
export class AdminDashBoardComponent implements OnInit {
  
  localItem=localStorage.getItem("Email");
  constructor(private route: ActivatedRoute,private router: Router,) { }

  ngOnInit(): void {
    if(!this.localItem){
      this.router.navigate(['']);
    }
  }

  logout(){
    if(this.localItem){
      localStorage.removeItem("Email");
      localStorage.removeItem("userId");
      localStorage.removeItem("userName");
      this.router.navigate(['']);
    }
    
  }

}
