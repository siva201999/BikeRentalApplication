import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';
declare var $:any;
@Component({
  selector: 'app-renter-booking-history',
  templateUrl: './renter-booking-history.component.html',
  styleUrls: ['./renter-booking-history.component.css']
})
export class RenterBookingHistoryComponent implements OnInit {

  bookingObj!:Config['BookingObj'][];
  id=JSON.parse(localStorage.getItem('userId')!);
  earnings!:any;
  SearchValue:string;
  constructor(private renterService:ServicesService,private router:Router) { }

  ngOnInit() {
    this.reloadData();
    this.renterService.getRenterBooking(this.id).subscribe(data =>{
      this.bookingObj=data;
      console.log(this.bookingObj);
      $(document).ready(function(){
        $('#bookingTable').DataTable({
          lengthMenu: [5, 10, 20, 50, 100],
          
        });
      });
    })
  }

  reloadData() {
    //  this.renterService.getBike(this.id).subscribe(bikes=>this.bike=bikes);
     this.renterService.getRenterEarning(this.id).subscribe(earning=>this.earnings=earning);
  }

}
