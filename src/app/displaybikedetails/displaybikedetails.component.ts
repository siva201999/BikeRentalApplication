import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bikes } from '../bikes';
import { RentalService } from '../renterservice.service';
import { CustomerService } from '../customer.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';


@Component({
  selector: 'app-displaybikedetails',
  templateUrl: './displaybikedetails.component.html',
  styleUrls: ['./displaybikedetails.component.css']
})
export class DisplaybikedetailsComponent implements OnInit {

  bikeId!: '';
  bike!: Bikes;
  bikess!: Bikes[];
  id: any;
  constructor(private route: ActivatedRoute,private router: Router,private renterService: RentalService) { }

  ngOnInit() {
    this.bike= new Bikes();

    //this.id = this.route.snapshot.params['id'];
    
    this.renterService.getBike().subscribe(data => {
        console.log(data)
        this.bikess= data;
      }, (error: any) => console.log(error));

      id:Number;
      this.id = this.route.snapshot.params['id'];
    
      this.renterService.getBikeById(this.id).subscribe(data => {
          console.log(data)
          this.bike= data;
        }, error => console.log(error));
  }

  searchedValue!:any;


  goto(value: any){
    this.bikeId=value;
    this.router.navigate(['bikedata',value]);
  }
}


