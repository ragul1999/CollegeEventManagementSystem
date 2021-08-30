import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccomodationRequestService } from '../services/AccomodationRequest/accomodation-request.service';
import { EventServiceService } from '../services/event-service.service';
import { ParticipantService } from '../services/participant.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  template:`<app-add-fest></app-add-fest>`,
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  participantCount?:number;
  eventCount?:number;
  accomCount?:number;
  constructor(private router:Router,private eventService:EventServiceService,private partipantService:ParticipantService,private accomService:AccomodationRequestService) { }

  ngOnInit(): void {
    this.count();
  }

  count(){
    let festId=3;
    this.eventService.getAllEvent(festId).subscribe((response)=>{
      this.eventCount=response.length;
    });
    this.partipantService.getAllParticipants().subscribe((response)=>{
      this.participantCount=response.length;
    });

    this.accomService.getAllRequests().subscribe((response)=>{
      this.accomCount=response.length;
    });
  }

  onLogOut(){
    this.router.navigate(['/login']);
    sessionStorage.clear();
  }

}
