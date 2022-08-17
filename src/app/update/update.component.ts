import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, Subscriber } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  renterId!: number;
 // customer:Customer;
  submitted = false;
  customer:Customer=new Customer();
  constructor(private route: ActivatedRoute,private router: Router,private customerservice: CustomerService) { }  
  base64code!:any;

  ngOnInit(): void {
    // this.customer=new Customer();
    // this.submitted = false;
    // this.renterId=this.route.snapshot.params['id'];

    // this.customerservice.getCustomerByRenterId(this.renterId).subscribe((data: Customer)=>{
    //   console.log(data)
    //   this.customer=data;
    // },(error: any)=>console.log(error));
  }
  updatecust(){
    console.log(this.customer);
    this.customerservice.update(this.customer.renterId,this.customer).subscribe(data=>
      {
        alert("Updated Successfully !")
      },error=>alert("Sorry details are not updated"));
  }
  onChange($event:Event ){
    const target = $event.target as HTMLInputElement;
    const file: File = (target.files as FileList)[0]; 
    this.convertToBase64(file);
  }
  
  convertToBase64(file:File){
    const observable = new Observable((subscriber: Subscriber<any>)=>{
        this.readFile(file,subscriber);
    });
  
    observable.subscribe((data) => {
      console.log(data)
      this.customer.image = data
      this.base64code = data
    });
  }
  
  readFile(file:File,subscriber:Subscriber<any>){
    const fileReader = new FileReader();
    fileReader.readAsDataURL(file);
  
    fileReader.onload=()=>{
      subscriber.next(fileReader.result);
      subscriber.complete();
    };
    fileReader.onerror=()=>{
      subscriber.error(fileReader.error);
      subscriber.complete();
    }
  }
}
