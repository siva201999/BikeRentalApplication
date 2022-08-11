import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';
declare var $: any;

@Component({
  selector: 'app-renter-details',
  templateUrl: './renter-details.component.html',
  styleUrls: ['./renter-details.component.css']
})
export class RenterDetailsComponent implements OnInit {

  public renterObj!:Config['RenterObj'][];
  public bikeObj!:Config['BikeObj'][];
  renterActive!:Config['RenterObj'][];
  activeMessage="";
  active=true;
  activeStatus:any;
  constructor(private router: Router,
    private route: ActivatedRoute,
    private service:ServicesService) {
      
     }

  ngOnInit(): void {
    this.service.getAllRenters().subscribe(response=>{
      this.renterObj=response;
      $(document).ready(function(){
        $('#renterTable').DataTable({
          lengthMenu: [5, 10, 20, 50, 100]
        });
      });
    })
    
  }

  isActiveRenter(id:any) {
    this.service.isActiveRenter(id).subscribe(response=>{
      console.log(response);
      if(response!==null){
        this.active=this.active+id;
        this.active=false;
        this.activeMessage="Renter mark an inactive!!!"
        setTimeout(function(){
          $('#alertActive').fadeOut('slow');
        },2000);
      // $("#inactive"+id).attr("disabled", true)
      }else{
        alert("renter is already mark as inactive!");
      }
    });
  }
      
  getRenterBikes(id:any){
    this.service.getRenterBikes(id).subscribe(response=>{
    console.log(response);
    this.bikeObj=response;
    console.log(this.bikeObj);
    localStorage.setItem('RenterBikes', JSON.stringify(this.bikeObj));
    this.router.navigate(['admin/dashboard/bikeDetails',id]);
    });
  }
  
}


