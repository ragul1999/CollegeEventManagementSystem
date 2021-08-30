import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ParticipantService } from 'src/app/services/participant.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id?:string;
  password?:string;
  flag?:boolean;
  public participants?:any;

  constructor(private router : Router,private participantService:ParticipantService) { this.flag=false;}

  ngOnInit(): void {
  }

  login(login:any) {
    console.log(login);
    this.id=login.emailId;
    this.password=login.password;
    if(this.id=="premchander.revature@gmail.com")
    {
      if(this.password=="admin")
      {

        this.router.navigate(["admin"]);
      }
      else
      {
        window.alert("incorrect password for admin"); 
      }
    }
    else{
        this.participantService.getAllParticipants().subscribe( response => {
        this.participants = response;

        console.log(this.participants);
        this.participants.forEach( (x: { password: any; emailId:any; id:any; }) =>{
              if(this.id==x.emailId && this.password==x.password)
              {

                    this.flag=true;
                    this.router.navigate(["studentHome"],{state:{id:x.id}});
              }
        });
      if(!this.flag){
     window.alert("check ur credentials!!!");} 
        
        
    });
  }
  }

  signup() {
    this.router.navigate(["signup"]);
  }
}
