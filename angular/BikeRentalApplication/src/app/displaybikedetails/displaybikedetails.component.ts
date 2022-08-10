import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bikes } from '../Renter/model/Bikes';
import { RenterserviceService } from '../Renter/services/renterservice.service';

@Component({
  selector: 'app-displaybikedetails',
  templateUrl: './displaybikedetails.component.html',
  styleUrls: ['./displaybikedetails.component.css']
})
export class DisplaybikedetailsComponent implements OnInit {

  id: number;
  bike: Bikes;

  constructor(private route: ActivatedRoute,private router: Router,private renterService: RenterserviceService) { }

  ngOnInit() {
    this.bike= new Bikes();

    this.id = this.route.snapshot.params['id'];
    
    this.renterService.getBikeById(this.id).subscribe(data => {
        console.log(data)
        this.bike= data;
      }, error => console.log(error));
  }

  goto(){
    this.router.navigate(['dashboard']);
  }
}