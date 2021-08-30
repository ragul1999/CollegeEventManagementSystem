import { Component, OnInit } from '@angular/core';
import { College, CollegeServiceService } from 'src/app/services/college-service.service';

@Component({
  selector: 'app-addcollege',
  templateUrl: './addcollege.component.html',
  styleUrls: ['./addcollege.component.css']
})
export class AddcollegeComponent implements OnInit {

  constructor(private service : CollegeServiceService) { }

  ngOnInit(): void {
  }

  addCollege(college : College) {
    console.log(college);
    this.service.createCollege(college).subscribe((response) => {
      window.alert(response);
    })
  }
}
