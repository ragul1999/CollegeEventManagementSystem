import { Component, OnInit } from '@angular/core';
import { AccomodationService } from 'src/app/services/Accomodation/accomodation.service';

@Component({
  selector: 'app-view-accomodation',
  templateUrl: './view-accomodation.component.html',
  styleUrls: ['./view-accomodation.component.css']
})
export class ViewAccomodationComponent implements OnInit {

  public viewAccomodation?:any[];
  constructor(private accomodationService:AccomodationService) { }

  ngOnInit(): void {
    this.accomodationService.getAllAccomodation().subscribe( response => {
      this.viewAccomodation = response;
      console.log(this.viewAccomodation);
  });
  }

}
