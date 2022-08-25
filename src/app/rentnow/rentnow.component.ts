import { Component, OnInit } from '@angular/core';
import { Rental } from '../rental';
import { RentalService } from './rental.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-rental',
  templateUrl: './rentnow.component.html',
  styleUrls: ['./rentnow.component.css']
})
export class RentalComponent implements OnInit {
  rentals:Rental[]=[];
  //rentalDetails:RentalDetail[]=[];
  dataLoaded=false;
  constructor(private rentalService:RentalService,private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    // this.activatedRoute.params.subscribe(params=>{
    //   if(params["carId"]){
    //     this.getRentalsById(params["carId"])
    //   }else{
    //     this.getRentals()
    //   }
    // })
  }
  getRentals() {
    this.rentalService.getRentals().subscribe(response=>{
      this.rentals=response.data
      this.dataLoaded=true;
    })
  }
  getRentalsById(bikeId:number) {
    this.rentalService.getRentalsById(bikeId).subscribe(response=>{
      this.rentals=response.data
      this.dataLoaded=true;
    })
  }
 

}