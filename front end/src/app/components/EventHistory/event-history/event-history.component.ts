import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventParticipantsService } from 'src/app/services/EventParticipant/event-participants.service';

@Component({
  selector: 'app-event-history',
  templateUrl: './event-history.component.html',
  styleUrls: ['./event-history.component.css']
})
export class EventHistoryComponent implements OnInit {

  eventList?:any =[];
  id?:any;

  constructor(private router:Router,private eventParticipantsService:EventParticipantsService) {
    
    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras.state as {
      id : any
    };

    if(state==undefined){
      window.alert("Loggedin session is invalid, please log in again");
      this.router.navigate(["login"]);
    }
    this.id = state.id;
    console.log("AT HISTORY EVE"+this.id);
   }

  ngOnInit(): void {
      this.getDetails();
  }
  getDetails()
  {
    this.eventParticipantsService.getAllEventsByParticipantId(this.id).subscribe((response)=>{
      console.log("AT history details"+response);
      this.eventList = response;
    })
  }
}


