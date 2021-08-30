import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { College, CollegeServiceService } from 'src/app/services/college-service.service';
import { FestDetails, FestServiceService } from 'src/app/services/fest-service.service';

@Component({
  selector: 'app-add-fest',
  templateUrl: './add-fest.component.html',
  template:`{{ meassage }}`,
  styleUrls: ['./add-fest.component.css']
})
export class AddFestComponent implements OnInit {
private message?:string;
public colleges?: College[];
 
  constructor(private router: Router,private festService: FestServiceService,private collegeService : CollegeServiceService) { }

  ngOnInit(): void {
    this.collegeService.getAllCollege().subscribe( response => {
      this.colleges = response;
    });
  }
  onBackToHome(){
    this.router.navigate(['/admin']);
  }
  onLogOut(){
    sessionStorage.setItem('festId',null as any as string);
    this.router.navigate(['/login']);
  }



  onSubmit(festAdd:FestDetails):any{
    console.log(festAdd);
    let collegeId=festAdd.collegeId as any as number;
     this.festService.addFest(festAdd,collegeId).subscribe(data => {
      this.message=data;
      window.alert(this.message);
      
      sessionStorage.setItem('festId',this.message); //message is return as fest id
     
      
        this.router.navigate(['/addEvent']);
    });
      
  }


}
