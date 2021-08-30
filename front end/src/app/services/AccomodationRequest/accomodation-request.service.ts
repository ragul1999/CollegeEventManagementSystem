import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Participants } from '../participant.service';

@Injectable({
  providedIn: 'root'
})
export class AccomodationRequestService {
  constructor(private http : HttpClient) { }

  public addRequests(id:any) {
    console.log("in service add");
    const headers =new HttpHeaders().set('Content_Type', 'application/json');
    const pass={status:"Pending"};
    return this.http.post("http://localhost:8083/participants/"+id+"/accomodation-request/create",pass,  { headers, responseType: 'text'});
  }
   getAllRequests() : Observable<any>{
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.http.get<AccomodationRequest>("http://localhost:8083/accomodation-request");
  }
  public updateRequest(id:any,requestStatus:any)
  {
      const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
      return this.http.put("http://localhost:8083/accomodation-request/update/"+id,requestStatus,{ headers, responseType: 'text'});
  }
  public deleteRequest(id:any)
  {
    const headers =new HttpHeaders().set('Content_Type', 'application/json');
    return this.http.delete("http://localhost:8083/accomodation-request/delete/"+id,{ headers, responseType: 'text'});

  }
}
export class AccomodationRequest{
  id?:number;
  status?:string;
  participants?:any;
 
}