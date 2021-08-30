import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { College } from './college-service.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HostelserviceService {
   constructor(private http : HttpClient) { }

  createHostel(hostel : Hostel) {
    const headers =new HttpHeaders().set('Content_Type', 'application/json');
    const newHostel = {name:hostel.name, capacity:hostel.capacity, availableSlots:hostel.capacity};
    return this.http.post("http://localhost:8083/college/"+hostel.college+"/hostel/create", newHostel, {headers, responseType : 'text'});
  }

  getAllHostel() : Observable<any> {
    return this.http.get<Hostel>("http://localhost:8083/hostel");
  }

  getHostelById(id : number) : Observable<any> {
    return this.http.get<Hostel>("http://localhost:8083/hostel"+id);
  }

}

export class Hostel {
  id?:number;
  name?: string;
  capacity?: number;
  availableSlots?: number;
  college?: any;
}