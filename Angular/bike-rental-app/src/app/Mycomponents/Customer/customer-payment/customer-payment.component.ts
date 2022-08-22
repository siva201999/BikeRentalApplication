import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';
import { CustomerBookingHistoryComponent } from '../customer-booking-history/customer-booking-history.component';

@Component({
  selector: 'app-customer-payment',
  templateUrl: './customer-payment.component.html',
  styleUrls: ['./customer-payment.component.css']
})
export class CustomerPaymentComponent implements OnInit {

  renterId!: number;
  // customer:Customer;
   submitted = false;
   cardDetails:Config['CardDetails']=new Config().CardDetails;
 
   constructor(private cardService:ServicesService , 
     private router: Router,private route: ActivatedRoute) { }
 
     id!: number;
     booking!: Config['BookingObj'];
     bike!: Config['BikeObj'];

   
     ngOnInit() {
       this.booking= new Config().BookingObj;
   
       this.id = this.route.snapshot.params['id'];

       this.cardService.addBookingHistory(this.id,this.booking).subscribe(data => {
        console.log(data)
        this.booking != data;
      }, error => console.log(error));
     }
    // this.customer=new Customer();
    // this.submitted = false;
    // this.renterId=this.route.snapshot.params['id'];
  
    validateCredentials(): void{
      if(confirm('Are you sure to proceed to payment?'))
      console.log(this.cardDetails)
      this.cardService.validatePayment(this.cardDetails).subscribe(
      data => {this.cardDetails != data;
      alert("Payment successfull");
      this.bike = new Config().BikeObj;
      this.bike.availability = "false";
      this.goto();
       } ,error=>alert("Payment unsuccessfull"));
        
      }
  
      goto(){
        this.router.navigate(['renter/dashboard']);
      }

      // this.renterService.getBikeById(this.id).subscribe(data => {
      //   console.log(data)
      //   this.bike= data;
      // }, error => console.log(error));


  
     
 

}
