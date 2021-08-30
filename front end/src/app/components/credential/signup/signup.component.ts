import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { College, CollegeServiceService } from 'src/app/services/college-service.service';
import { Participants, ParticipantService } from 'src/app/services/participant.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public colleges?: College[];
  
  constructor(private collegeService : CollegeServiceService, private service : ParticipantService,private router:Router) { }

  ngOnInit(): void {

    this.collegeService.getAllCollege().subscribe( response => {
      this.colleges = response;
    });
  }

  addParticipant(participant : Participants) {
    console.log(participant);
    this.service.addParticipant(participant).subscribe((response) => {
      window.alert(response);
      this.router.navigate(["login"]);
    })
  }
}
