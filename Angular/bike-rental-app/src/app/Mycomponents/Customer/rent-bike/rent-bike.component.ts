import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rent-bike',
  templateUrl: './rent-bike.component.html',
  styleUrls: ['./rent-bike.component.css']
})
export class RentBikeComponent implements OnInit {

  startdate:any;
  dated:any;
  datef:any;
  enddate:any;
  dayssubracted:any;
  error:any;
  price: string = "500";
  
    constructor() {
  
     }
    ngOnInit(): void {
  }
  
  fetchDate(){
    console.log("date selected by user is ---- "+ this.startdate);
    console.log("date selected by user is ---- "+ this.enddate);
  }
  
  diff(){
  let date1 = new Date(this.startdate);
  let date2 = new Date(this.enddate);
  this.dayssubracted = (Math.floor((Date.UTC(date2.getFullYear(), date2.getMonth(), date2.getDate()) - Date.UTC(date1.getFullYear(), date1.getMonth(), date1.getDate()) ) /(1000 * 60 * 60 * 24)))*(+this.price);
  console.log("subracted days are  " + this.dayssubracted);
  }

}
