import { Component, OnInit } from '@angular/core';
import { CollegeServiceService, College } from '../../services/college-service.service';


@Component({
  selector: 'app-college',
  templateUrl: './college.component.html',
  styleUrls: ['./college.component.css']
})
export class CollegeComponent implements OnInit {

  public colleges?: College[];
  constructor(private collegeService : CollegeServiceService) { }

  ngOnInit(): any {
    this.collegeService.getAllCollege().subscribe( response => {
      this.colleges = response;
    });
  }
}
