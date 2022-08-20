import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-renter-booking-history',
  templateUrl: './renter-booking-history.component.html',
  styleUrls: ['./renter-booking-history.component.css']
})
export class RenterBookingHistoryComponent implements OnInit {
  // renter:Config['RenterObj']=new Config().RenterObj;
  id=JSON.parse(localStorage.getItem('userId')!);
  earnings!:any;
  SearchValue:string;
  constructor(private renterService:ServicesService,private router:Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    //  this.renterService.getBike(this.id).subscribe(bikes=>this.bike=bikes);
     this.renterService.getRenterEarning(this.id).subscribe(earning=>this.earnings=earning);
  }

}
