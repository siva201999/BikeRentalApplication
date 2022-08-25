import { Component, OnInit } from '@angular/core';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-customer-booking-history',
  templateUrl: './customer-booking-history.component.html',
  styleUrls: ['./customer-booking-history.component.css']
})
export class CustomerBookingHistoryComponent implements OnInit {

   // posts : any;
   parentMessage : any;
   customers !:any;
   error:any;
 
   constructor(private _customerService: ServicesService) { }
 
   ngOnInit(): void {
     // this.heroService.getPosts().subscribe(p => this.posts =p);
     this._customerService.getAllCustomers().subscribe(allcustomers => this.customers = allcustomers )
    //  $(document).ready(function(){
    //    $('#bookingtable').DataTable({
    //      lengthMenu: [5, 10, 20, 50, 100]
    //    });
    //  });
   }

   cancelBike(id: any){
    if(confirm('Are you sure to cancel the Booking?'))
    this._customerService.deleteBookingId(id)
    .subscribe(
      data => {
        console.log(data);
        alert('Booking cancelled Successfully')
      },error=>alert("Cancellation unsuccessfull"));
   }




}
