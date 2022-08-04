import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, Subscriber } from 'rxjs';

@Component({
  selector: 'app-renter-dash-board',
  templateUrl: './renter-dash-board.component.html',
  styleUrls: ['./renter-dash-board.component.css']
})
export class RenterDashBoardComponent implements OnInit {

  localItem=localStorage.getItem("Email");
  constructor(private route: ActivatedRoute,private router: Router) { }
  //======================image upload variable==============
  myImage!:Observable<any>;
  base64code!:any;

  ngOnInit(): void {
    if(!this.localItem){
      this.router.navigate(['']);
    }
  }
//=========================image upload function==========================
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
      //console.log(data)
      this.myImage = data
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
//=============================End of the imgae implemetation=============================

  logout(){
    if(this.localItem){
      localStorage.removeItem("Email");
      localStorage.removeItem("userId");
      localStorage.removeItem("userName");
      this.router.navigate(['']);
    }
    
  }
}
