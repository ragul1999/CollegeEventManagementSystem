import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {  Accomodation, AccomodationService } from 'src/app/services/Accomodation/accomodation.service';

@Component({
  selector: 'app-add-accomodation',
  templateUrl: './add-accomodation.component.html',
  styleUrls: ['./add-accomodation.component.css']
})
export class AddAccomodationComponent implements OnInit {
  message?: string;

  id?:any;

  constructor(private accomodationService:AccomodationService, private router :Router) {
    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras.state as {
      id : any
    };
    this.id = state.id;
    console.log(this.id);
   }
  ngOnInit(): void {

  }
  onSubmit(addAccomodation:Accomodation):any{
    console.log(addAccomodation);
     addAccomodation.participants=this.id; 
     this.accomodationService.addAccomodations(addAccomodation).subscribe(data => {
     this.message=data;
    window.alert(this.message);
    this.router.navigate(["admin"]);
   }
     );
  }

}
