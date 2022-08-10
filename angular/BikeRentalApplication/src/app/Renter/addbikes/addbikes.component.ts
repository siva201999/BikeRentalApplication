import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscriber } from 'rxjs';
import { Bikes } from '../model/Bikes';
import { RenterserviceService } from '../services/renterservice.service';

@Component({
  selector: 'app-addbikes',
  templateUrl: './addbikes.component.html',
  styleUrls: ['./addbikes.component.css']
})
export class AddbikesComponent implements OnInit {

  bike:Bikes=new Bikes();
  submitted = false;
  constructor(private renterService: RenterserviceService, private router: Router) { }
  base64code!:any;

  ngOnInit() {
  }

save() {
  this.renterService.addBike(this.bike).subscribe(data => {
    console.log(data)
    this.bike= new Bikes();
    this.goto();
  }, 
  error => console.log(error));
}
onSubmit() {
  this.submitted = true;
  this.save();    
}
goto() {
  this.router.navigate(['/dashboard']);
}


onChange($event:Event ){
  const target = $event.target as HTMLInputElement;
  const file: File = (target.files as FileList)[0]; 
  //console.log(file);
  this.convertToBase64(file);
}

convertToBase64(file:File){
  const observable = new Observable((subscriber: Subscriber<any>)=>{
      this.readFile(file,subscriber);
  });

  observable.subscribe((data) => {
    console.log(data)
    this.bike.bikeImage = data
    this.base64code = data
  });
}

readFile(file:File,subscriber:Subscriber<any>){
  const fileReader = new FileReader();
  fileReader.readAsDataURL(file);

  fileReader.onload=()=>{
    subscriber.next(fileReader.result);
    subscriber.complete();
  };
  fileReader.onerror=()=>{
    subscriber.error(fileReader.error);
    subscriber.complete();
  }
}
}