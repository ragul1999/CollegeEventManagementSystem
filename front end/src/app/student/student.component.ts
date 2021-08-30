import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventServiceService } from '../services/event-service.service';
import { EventParticipantsService } from '../services/EventParticipant/event-participants.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  festSessionId?: number;
  eventDetails?: any[];
  eventLength: any;
  id?:any;

  constructor(private eventService:EventServiceService,private router:Router,private eventParticipantsService:EventParticipantsService) {
    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras.state as {
      id : any
    };
    if(state==undefined){
      window.alert("Loggedin session is invalid, please log in again");
      this.router.navigate(["login"]);
    }
    this.id = state.id;
    console.log("student id"+this.id);
    
   }
   

  ngOnInit(): void {
    this.onShowEvent();
  }

  onLogOut(){
    this.router.navigate(['/login']);
    sessionStorage.clear();
  }

test:{[key:string]:string} = {groupdance:"/assets/images/groupdance.jpg",solodance:"/assets/images/solodance.jpg",debate:"/assets/images/debate.jpg",
eating:"/assets/images/eating.jpg",
 goodmanager:"/assets/images/goodmanager.jpeg",
 paperpresentation:"/assets/images/paperpresentation.jpg",
 quiz:"/assets/images/quiz.jpg",
reversecoding:"/assets/images/reversecoding.jpg",
 singing:"/assets/images/singing.jpg",
treasurehunt:"/assets/images/treasurehunt.jpg",
 webdesign:"/assets/images/webpagedesign.png"};


onShowEvent(): any {
  
  this.festSessionId=3;
  this.eventService.getAllEvent(this.festSessionId).subscribe( response => {
   this.eventDetails=response;
   this.eventLength=response.length;
   console.log(this.eventDetails);
  }); 

  

}
register(url:any){
console.log(url);
console.log(this.id);
this.eventParticipantsService.addEventParticipant(this.id,url.id).subscribe(data=>
  {
    window.alert(data);
  });
}
onHistory(){
  console.log("student par id:"+this.id);
  this.router.navigate(["viewHistory"],{state:{id:this.id}});
}

onRequest(){
  console.log("student par id:"+this.id);
  this.router.navigate(["addAccomodationRequest"],{state:{id:this.id}});
}
}
