import { Component, OnInit } from '@angular/core';
import { Hostel, HostelserviceService } from 'src/app/services/hostelservice.service';
import { College, CollegeServiceService } from 'src/app/services/college-service.service';

@Component({
  selector: 'app-addhostel',
  templateUrl: './addhostel.component.html',
  styleUrls: ['./addhostel.component.css']
})
export class AddhostelComponent implements OnInit {

  public colleges?: College[];

  constructor(private service : HostelserviceService, private collegeService : CollegeServiceService) { }
  ngOnInit(): void {
    this.collegeService.getAllCollege().subscribe( response => {
      this.colleges = response;
    });
  }

  addHostel(hostel : Hostel) {
    console.log(hostel);
    this.service.createHostel(hostel).subscribe((response) =>{
      window.alert(response);
    })
  }
}
