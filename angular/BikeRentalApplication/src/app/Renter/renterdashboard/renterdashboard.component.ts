import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { Bikes } from '../model/Bikes';
import { RenterserviceService } from '../services/renterservice.service';
@Component({
  selector: 'app-renterdashboard',
  templateUrl: './renterdashboard.component.html',
  styleUrls: ['./renterdashboard.component.css']
})
export class RenterdashboardComponent implements OnInit {

  parentMessage:any;
  error:any;
  bike: Bikes[]=[];

  constructor(private renterService:RenterserviceService,private router:Router){}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
     this.renterService.getBike().subscribe(bikes=>this.bike=bikes);
  }

  deleteBike(id: number) {
    this.renterService.deleteBike(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  getBikeById(id: number){
    this.router.navigate(['displayBike', id]);
  }

  updateBike(id: number){
    this.router.navigate(['update', id]);
  }
}
