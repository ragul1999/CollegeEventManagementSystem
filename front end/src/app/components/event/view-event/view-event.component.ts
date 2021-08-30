import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventDetails, EventServiceService } from 'src/app/services/event-service.service';
import { FestDetails, FestServiceService } from 'src/app/services/fest-service.service';

@Component({
  selector: 'app-view-event',
  templateUrl: './view-event.component.html',
  styleUrls: ['./view-event.component.css']
})
export class ViewEventComponent implements OnInit {
  
  message?:string;
  festDetails?:FestDetails[];
  eventDetails?: EventDetails[];
  festSessionId?:number;
  eventLength?:any;
  constructor(private eventService: EventServiceService,private router: Router,private festService:FestServiceService) { }

  ngOnInit(){
   this.onShowEvent();
    
  }
  
  onBackToViewFest(){
    this.router.navigate(['/viewFest']);
  }
  onBackToHome(){
    sessionStorage.removeItem('festId');
    this.router.navigate(['/admin']);
  }
  


  onShowEvent(): any {
    this.festSessionId=3;
    this.eventService.getAllEvent(this.festSessionId).subscribe( response => {
     this.eventDetails=response;
     this.eventLength=response.length;
     console.log(this.eventDetails);
    }); 

} 
}
