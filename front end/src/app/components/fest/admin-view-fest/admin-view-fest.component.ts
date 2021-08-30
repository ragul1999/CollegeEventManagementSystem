import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FestDetails, FestServiceService } from 'src/app/services/fest-service.service';
import { EventServiceService } from 'src/app/services/event-service.service';
import { analyzeAndValidateNgModules } from '@angular/compiler';
@Component({
  selector: 'app-admin-view-fest',
  templateUrl: './admin-view-fest.component.html',
  
  styleUrls: ['./admin-view-fest.component.css']
})
export class AdminViewFestComponent implements OnInit {
  message?:string;
  festDetails?: FestDetails[];

  constructor(private festService: FestServiceService,private eventService:EventServiceService,private router: Router) { }
  ngOnInit(): any {
    this.festService.getAllFest().subscribe( response => {
     this.festDetails=response;
     console.log("check admin view fest "+this.festDetails);
    });
  }

  onBackToHome(){
    sessionStorage.removeItem('festId');
    this.router.navigate(['/admin']);
  }
  onLogOut(){
    this.router.navigate(['/login']);
    sessionStorage.clear();
  }

  onDisplayEvent(event:any,fest:FestDetails){
    console.log("event:"+event);
    if(fest.id ==undefined)
        fest.id=10;
    sessionStorage.setItem('festId',fest.id as any as string); 
   
    
    this.eventService.getAllEvent(fest.id).subscribe(data=>
      {
        this.router.navigate(['/viewEvent']);
        console.log(data);
      }
      );
  }

  onUpdate(event:any,fest:FestDetails){
    console.log("event:"+event);
    if(fest.id ==undefined)
        fest.id=10;
    sessionStorage.setItem('festId',fest.id as any as string); 
    this.router.navigate(['/updateFest']);
  }
  onDelete(event:any,fest:FestDetails){
    if(fest.id ==undefined)
        fest.id=10;
    

    if (confirm('Are you sure you want to delete the fest?')) {
      sessionStorage.setItem('festId',fest.id as any as string); 
    this.festService.deleteFest(fest.id).subscribe(data=>
      {
        alert(data);
        window.location.reload();
        console.log(data);
        sessionStorage.removeItem('festId');
      }
      );
      console.log('This fest is not deleted from the database.');
  }
     else {
      console.log('This fest is deleted from the database.');
    }

  }

   
 
  

}
