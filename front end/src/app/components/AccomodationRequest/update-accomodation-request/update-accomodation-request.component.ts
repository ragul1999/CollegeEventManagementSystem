import { EventEmitter } from '@angular/core';
import { Component, OnInit, Output } from '@angular/core';
import { Router, NavigationExtras} from '@angular/router';
import { AccomodationService } from 'src/app/services/Accomodation/accomodation.service';
import { AccomodationRequestService } from 'src/app/services/AccomodationRequest/accomodation-request.service';

@Component({
  selector: 'app-update-accomodation-request',
  templateUrl: './update-accomodation-request.component.html',
  styleUrls: ['./update-accomodation-request.component.css']
})
export class UpdateAccomodationRequestComponent implements OnInit {

  public viewAccomodation?: any=[];
  message?: string;

  constructor(private router:Router,private accomodationRequestService:AccomodationRequestService,private accomodationService:AccomodationService) { }

  ngOnInit(): any {
    this.accomodationRequestService.getAllRequests().subscribe( response => {
      this.viewAccomodation = response;
      console.log(this.viewAccomodation);
  });
  }

  approve(accomodationRequest:any){
    console.log(accomodationRequest.id);
    this.accomodationRequestService.updateRequest(accomodationRequest.id,"approved").subscribe(response => {
      this.message = response;
      if(this.message=="Accomodation Request Updated Successfully!"){
        console.log(this.message);
        this.router.navigate(["addAccomodation"],{state:{id:accomodationRequest.participants.id}});
        
      }
    });
  }
  deny(accomodationRequest:any){
    console.log(accomodationRequest.id);
    this.accomodationRequestService.updateRequest(accomodationRequest.id,"denied").subscribe(response => {
      this.message = response;
      window.alert(this.message);
    });
  }

}
