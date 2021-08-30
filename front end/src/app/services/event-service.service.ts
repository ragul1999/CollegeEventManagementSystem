import { Time } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FestDetails } from './fest-service.service';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EventServiceService {
  updateEvent?:EventDetails;
 
  constructor(private httpService: HttpClient) { }
  public getAllEvent( festId:number):Observable<any> {
    console.log("inside service get Event");
    //const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.get<EventDetails>("http://localhost:8083/fest/"+festId+"/event");
  }

  public addEvent( festId:number,addEvent: EventDetails){
    console.log("inside service add Event");
    console.log(addEvent);
   const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post("http://localhost:8083/fest/"+festId+"/event", addEvent,  {  responseType: 'text'});
  }
  
  public update(updateEvent: EventDetails) {
    this.updateEvent = updateEvent;
  }
  public updateMethod() {
    return this.updateEvent;
  }
  public onUpdate(updateEvent: EventDetails) {
    console.log("ins service update Fest");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.put("http://localhost:8586/employees/UpdateEmployee", updateEvent,  { headers, responseType: 'text'});
  }
  delete(id: number) {
    console.log("ins service delete Fest");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.delete("http://localhost:8586/employees/DeleteEmployee/" + id,  { headers, responseType: 'text'});
  }

}

export class EventDetails{
  
	id?:number;
 name?:string;
 description?:string;
 type?:string;
 maxSeats?:number;
	availSeats?:number;
	contactMail?:string;
	eventDate?:Date;
 eventTime?:Time;
  fest?:FestDetails;
}