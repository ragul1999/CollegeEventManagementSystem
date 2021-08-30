import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Participants, ParticipantService } from '../participant.service';

@Injectable({
  providedIn: 'root'
})
export class EventParticipantsService {

  array ?: any = [ ];
  arr?:EventParticipants[] | undefined;
  constructor(private http : HttpClient,private participant:ParticipantService) { }

  addEventParticipant(pid:any,eid:any) {
    const headers =new HttpHeaders().set('Content_Type', 'application/json');
    return this.http.post("http://localhost:8083/participant/"+pid+"/event/"+eid+"/event-participant/create",{}, { headers, responseType: 'text'})
  }

  getAllEventsByParticipantId(pid:any):Observable<any>
  {
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.http.get<EventParticipants>("http://localhost:8083/event-participant/participants/"+pid); 
   }

}
export class EventParticipants{

  id?:number;
  participant:any;
  event:any;

}