import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CollegeServiceService {

  constructor(private http : HttpClient) {}

  createCollege(college : College){
    return this.http.post("http://localhost:8083/createCollege", college, {responseType: 'text'});
  }

  getAllCollege() : Observable<any>{
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.http.get<College>("http://localhost:8083/getAllCollege");
  }

  getCollegeById(id : number) : Observable<any> {
    return this.http.get<College>("http://localhost:8083/getCollege/"+id);
  }

  
}

export class College {
  id?:number;
  name?: string;
  code?: number;
  city?: string;
  state?: string;
  emailId?: string;
  phoneNumber?: number;
}
