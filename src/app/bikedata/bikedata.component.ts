import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bikes } from '../bikes';
import { RentalService } from '../renterservice.service';

@Component({
  selector: 'app-bikedata',
  templateUrl: './bikedata.component.html',
  styleUrls: ['./bikedata.component.css']
})
export class BikedataComponent implements OnInit {

  id!: number;
  bike!: Bikes;

  constructor(private route: ActivatedRoute,private router: Router,private renterService: RentalService) { }

  ngOnInit() {
    this.bike= new Bikes();

    this.id = this.route.snapshot.params['id'];
    
    this.renterService.getBikeById(this.id).subscribe(data => {
        console.log(data)
        this.bike= data;
      }, error => console.log(error));
  }

  gotoBuyNow(value: any){
    this.router.navigate(['buynow']);
  }
  Back(){
    this.router.navigate(['search']);
  }
}
