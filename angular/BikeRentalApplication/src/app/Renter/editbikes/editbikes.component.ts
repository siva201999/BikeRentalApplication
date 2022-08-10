import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bikes } from '../model/Bikes';
import { RenterserviceService } from '../services/renterservice.service';
import { Observable, Subscriber } from 'rxjs';


@Component({
  selector: 'app-editbikes',
  templateUrl: './editbikes.component.html',
  styleUrls: ['./editbikes.component.css']
})
export class EditbikesComponent implements OnInit {

  id: number;
  bikes:Bikes;
  submitted = false;
  constructor(private route: ActivatedRoute,private router: Router,private renterService: RenterserviceService) { }
  base64code!:any;
  ngOnInit(): void {
    this.bikes=new Bikes();
    this.submitted = false;
    this.id=this.route.snapshot.params['id'];

    this.renterService.getBikeById(this.id).subscribe(data=>{
      console.log(data)
      this.bikes=data;
    },error=>console.log(error));
  }
  editBike(){
    this.renterService.updateBike(this.id,this.bikes).subscribe(data=>{
      console.log(data);
      this.bikes=new Bikes();
      this.goto();
    },error=>console.log(error));
  }
  onSubmit() {
    this.submitted = false;
    this.editBike();    
  }
goto(){
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
    this.bikes.bikeImage = data
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