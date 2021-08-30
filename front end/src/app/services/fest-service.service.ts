import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { College } from './college-service.service';
@Injectable({
  providedIn: 'root'
})
export class FestServiceService {

  
  constructor(private httpService: HttpClient) { }
  public getAllFest():Observable<any> {
    return this.httpService.get<FestDetails>("http://localhost:8083/fest/");
  }

  public addFest(addFest: FestDetails,collegeId:number) {
    console.log(addFest);
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post("http://localhost:8083/fest?collegeId="+collegeId, addFest , { headers, responseType: 'text'});
  }
  
 
  
  public updateFest(festId:number,updatedDate:string) {
    console.log("ins service update Fest");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.put("http://localhost:8083/fest/"+festId+"/update-date", updatedDate,  { headers, responseType: 'text'});
  }
  public deleteFest(id: number) {
    console.log("ins service delete Fest");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.delete("http://localhost:8083/fest/" + id,  { headers, responseType: 'text'});
  }
}

export class FestDetails {
  id?: number;
  name?: string;
  startDate?: Date;
  endDate?: Date;
  collegeId?:number;

}