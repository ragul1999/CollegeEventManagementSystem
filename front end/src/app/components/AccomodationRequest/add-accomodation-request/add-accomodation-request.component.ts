import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccomodationRequest, AccomodationRequestService } from 'src/app/services/AccomodationRequest/accomodation-request.service';

@Component({
  selector: 'app-add-accomodation-request',
  templateUrl: './add-accomodation-request.component.html',
  styleUrls: ['./add-accomodation-request.component.css']
})
export class AddAccomodationRequestComponent implements OnInit {
  message?: string;
  id?:any;

  constructor(private accomodationRequestService:AccomodationRequestService, private router : Router) {

    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras.state as {
      id : any
    };
    if(state==undefined){
      window.alert("Loggedin session is invalid, please log in again");
      this.router.navigate(["login"]);
    }

    this.id = state.id;
    console.log(this.id);
   }

  ngOnInit(): void {
  }
  onSubmit(temp:AccomodationRequest):any{
     this.accomodationRequestService.addRequests(this.id).subscribe(data => {
      this.message=data;
      window.alert(this.message+" And further approval will be initimated to your mail ");
      this.router.navigate(["studentHome"],{state:{id:this.id}}); 
    
     });
     
  }

}
