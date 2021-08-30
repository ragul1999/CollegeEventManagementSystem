import { Component, OnInit } from '@angular/core';
import { AccomodationRequestService } from 'src/app/services/AccomodationRequest/accomodation-request.service';

@Component({
  selector: 'app-view-accomodation-request',
  templateUrl: './view-accomodation-request.component.html',
  styleUrls: ['./view-accomodation-request.component.css']
})
export class ViewAccomodationRequestComponent implements OnInit {

  public viewAccomodation?: any=[];

  constructor(private viewAccomodationRequestService:AccomodationRequestService) { }

  ngOnInit(): any {
    this.viewAccomodationRequestService.getAllRequests().subscribe( response => {
      this.viewAccomodation = response;
      console.log(this.viewAccomodation);
  });
  }

}
