import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  renterId!: number;
  // customer:Customer;
   submitted = false;
   cardDetails:Config['CardDetails']=new Config().CardDetails;
   booking:Config['BookingObj']=new Config().BookingObj;
 
   constructor(private service:ServicesService ,
    private router: Router,
    private route: ActivatedRoute) { }
  ngOnInit(): void {
    console.log(this.booking);
    this.service.saveBookingHistory(this.booking).subscribe(data=>{
      console.log(data);
    })
  }

  validateCredentials(){
    if(confirm('Are you sure that you want to confirm  the payment?'))
    console.log(this.cardDetails)
    this.service.validatePayment(this.cardDetails).subscribe(data => {
      // this.cardDetails = data;
      console.log(this.cardDetails);
      alert("Payment successfull");
      // this.bookingHistory();
      this.goBack();
     } ,error=>alert("Payment unsuccessfull"));
      
    }

  //  bookingHistory(){
  //   this.booking.bookingDate
  //   this.service.saveBookingHistory(this.booking).
  //  } 
  goBack(){
    this.router.navigate(['customer/dashboard'])
  }
  cancelPayment(){
    this.router.navigate(['customer/dashboard'])
  }
}
