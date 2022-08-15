import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-renter-dashboard-content',
  templateUrl: './renter-dashboard-content.component.html',
  styleUrls: ['./renter-dashboard-content.component.css']
})
export class RenterDashboardContentComponent implements OnInit {

  parentMessage:any;
  error:any;
  bike: any=[];
id=JSON.parse(localStorage.getItem('userId')!);
  constructor(private renterService:ServicesService,private router:Router){}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
     this.renterService.getBike(this.id).subscribe(bikes=>this.bike=bikes);
  }

  deleteBike(id: any) {
    this.renterService.deleteBike(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  getBikeById(id: any){
    this.router.navigate(['renter/bike/', id]);
  }

  updateBike(id: any){
    this.router.navigate(['renter/editBike/', id]);
  }

  
}
