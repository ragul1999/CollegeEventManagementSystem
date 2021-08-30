import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { College } from './college-service.service';

@Injectable({
  providedIn: 'root'
})
export class ParticipantService {

  constructor(private http : HttpClient) { }

  getAllParticipants() : Observable<any>{
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.http.get<Participants>("http://localhost:8083/participants");
  }

  addParticipant(participant : Participants) {
    const headers =new HttpHeaders().set('Content_Type', 'application/json');
    const newParticipant = {
      name : participant.name,
      emailId : participant.emailId,
      contactNumber : participant.contactNumber
    };
    return this.http.post("http://localhost:8083/college/"+participant.college+"/participants/create", newParticipant, { headers, responseType: 'text'})
  }
}

export class Participants{
  id?:number;
  name?: string;
  emailId?: string;
  contactNumber?: number;
  password?:string;
  college?:any;
}