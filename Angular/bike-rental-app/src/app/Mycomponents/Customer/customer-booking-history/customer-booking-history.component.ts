import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';
declare var $: any;
@Component({
  selector: 'app-customer-booking-history',
  templateUrl: './customer-booking-history.component.html',
  styleUrls: ['./customer-booking-history.component.css']
})
export class CustomerBookingHistoryComponent implements OnInit {

  bookingObj!:Config['BookingObj'][];
  id=JSON.parse(localStorage.getItem('userId')!);
  constructor(private route: ActivatedRoute,private router: Router,
    private service:ServicesService) { }

  ngOnInit(): void {
    this.service.getCustomerBooking(this.id).subscribe(data =>{
      this.bookingObj=data;
      console.log(this.bookingObj);
      $(document).ready(function(){
        $('#bookingTable').DataTable({
          lengthMenu: [5, 10, 20, 50, 100]
        });
      });
    })
  }

  cancelBike(id: any){
    if(confirm('Are you sure to cancel the Booking?'))
    this.service.deleteBookingId(id).subscribe(data => {
        console.log(data);
        alert('Booking cancelled Successfully');
        this.Back();
      },error=>alert("Cancellation unsuccessfull"));
   }

   Back(){
    this.router.navigate(['customer/booking']).then(() => {
      window.location.reload();
  });
}
}
