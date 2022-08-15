import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-bike-detail',
  templateUrl: './bike-detail.component.html',
  styleUrls: ['./bike-detail.component.css']
})
export class BikeDetailComponent implements OnInit {

  id!: number;
  bike!: any;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private renterService: ServicesService) { }

  ngOnInit() {
    this.bike= new Config().BikeByIdObj;

    this.id = this.route.snapshot.params['id'];
    
    this.renterService.getBikeById(this.id).subscribe(data => {
        console.log(data)
        this.bike= data;
      }, error => console.log(error));
  }

  

  goto(){
    this.router.navigate(['renter/dashboard']);
  }

}
