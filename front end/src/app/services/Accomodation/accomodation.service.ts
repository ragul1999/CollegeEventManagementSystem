import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccomodationService {

  constructor(private http : HttpClient) { }

  public addAccomodations(addaccomodation: Accomodation) {
    console.log("in service add");
    console.log(addaccomodation);
    const headers =new HttpHeaders().set('Content_Type', 'application/json');
    return this.http.post("http://localhost:8083/participant/"+addaccomodation.participants+"/hostel/"+addaccomodation.hostel+"/accomodation/create",{} , { headers, responseType: 'text'});
  }
  getAllAccomodation() : Observable<any>{
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.http.get<Accomodation>("http://localhost:8083/accomodation");
  }

}
export class Accomodation{
  id?:number;
  participants?:any;
  hostel?:any;
}