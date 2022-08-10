import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-bike-details',
  templateUrl: './bike-details.component.html',
  styleUrls: ['./bike-details.component.css']
})
export class BikeDetailsComponent implements OnInit {
  bikeDetails:any=[];


  constructor(private router: Router,
    private route: ActivatedRoute,
    private service:ServicesService) {}

  ngOnInit(): void {
    this.bikeDetails = JSON.parse(localStorage.getItem('RenterBikes') as any);
    // console.log(this.bikeDetails);
  }
}



