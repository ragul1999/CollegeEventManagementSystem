import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EventDetails, EventServiceService } from 'src/app/services/event-service.service';


@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit {
message?:any;
festId?:number=0;
events=[
  {name:"Eating",value:"eating"},
  {name:"Debate",value:"debate"},
  {name:"Good manager",value:"goodmanager"},
  {name:"Group dance",value:"groupdance"},
  {name:"Paper presentation",value:"paperpresentation"},
  {name:"Quiz",value:"quiz"},
  {name:"Reverse coding",value:"reversecoding"},
  {name:"Singing",value:"singing"},
  {name:"Solo dance",value:"solodance"},
  {name:"Treasure Hunt",value:"treasurehunt"},
  {name:"Web Design",value:"webdesign"},
];

  constructor(private router: Router,private eventService: EventServiceService) { }

  ngOnInit(): void {
    this.festId=3;
    console.log("session id:"+this.festId);
  }

  onBackToHome(){
    this.router.navigate(['/admin']);
  }
  onBackToAddFest(){
    this.router.navigate(['/addFest']);
  }

  onSubmit(addEvent:EventDetails):any{
    addEvent.availSeats=addEvent.maxSeats;
    let festId=this.festId as any as number;
   console.log("session id:"+this.festId);
    console.log(addEvent);
    this.eventService.addEvent(festId,addEvent).subscribe(data => {
     this.message=data;
     window.alert(this.message);
    
  });

  }
}
