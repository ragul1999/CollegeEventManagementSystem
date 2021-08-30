import { Component, OnInit } from '@angular/core';
import { Participants, ParticipantService } from 'src/app/services/participant.service';

@Component({
  selector: 'app-participant',
  templateUrl: './participant.component.html',
  styleUrls: ['./participant.component.css']
})
export class ParticipantComponent implements OnInit {

  public participants?: any=[];

  constructor(private participantService:ParticipantService) { }

  ngOnInit(): any {
    this.participantService.getAllParticipants().subscribe( response => {
      this.participants = response;
      console.log(this.participants);
  });
  }
}
