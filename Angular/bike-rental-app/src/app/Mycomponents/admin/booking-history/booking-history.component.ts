import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';
declare var $: any;
@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.css']
})
export class BookingHistoryComponent implements OnInit {
  bookingObj!:Config['BookingObj'][];
  constructor(private route: ActivatedRoute,private router: Router,
    private service:ServicesService) { }

  ngOnInit(): void {
    this.service.getBooking().subscribe(data =>{
      this.bookingObj=data;
      console.log(this.bookingObj);
      $(document).ready(function(){
        $('#bookingTable').DataTable({
          lengthMenu: [5, 10, 20, 50, 100]
        });
      });
    })
  }

}
