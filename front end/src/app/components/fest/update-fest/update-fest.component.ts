import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FestDetails, FestServiceService } from 'src/app/services/fest-service.service';

@Component({
  selector: 'app-update-fest',
  templateUrl: './update-fest.component.html',
  styleUrls: ['./update-fest.component.css']
})
export class UpdateFestComponent implements OnInit {
  festDetails?:FestDetails[];
  constructor(private router:Router,private festService:FestServiceService) { }

  ngOnInit(): void {
      this.festService.getAllFest().subscribe( response => {
       this.festDetails=response;
      });
    }
  


  onBackToHome(){
    this.router.navigate(['/admin']);
  }
  onBackToAddFest(){
    this.router.navigate(['/addFest']);
  }



  onAddEvent(){
    this.router.navigate(['/addEvent']);
  }
  onUpdateFest(updatedFest:FestDetails){
    updatedFest.id=3;
    this.festService.updateFest(updatedFest.id as any as number,updatedFest.startDate as any as string).subscribe(data=>{
      window.alert(data);
      console.log(data);
    });
  }

}
