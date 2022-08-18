import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-bike-data',
  templateUrl: './bike-data.component.html',
  styleUrls: ['./bike-data.component.css']
})
export class BikeDataComponent implements OnInit {

  id!: number;
  bike!: Config['BikeObj'];

  constructor(private route: ActivatedRoute,private router: Router,private renterService: ServicesService) { }

  ngOnInit() {
    this.bike= new Config().BikeObj;

    this.id = this.route.snapshot.params['id'];
    
    this.renterService.getBikeById(this.id).subscribe(data => {
        console.log(data)
        this.bike= data;
      }, error => console.log(error));
  }

  gotoBuyNow(value: any){
    this.router.navigate(['customer/buyNow']);
  }
  Back(){
    this.router.navigate(['customer/dashboard']);
  }

}
