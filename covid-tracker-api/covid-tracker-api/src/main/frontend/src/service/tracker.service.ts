import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StatusModel} from "../model/status.model";

@Injectable({
  providedIn: 'root'
})
export class TrackerService {

  constructor(private http: HttpClient ) { }

  public getCountryStatus(): Observable<StatusModel>{
    return this.http.get<StatusModel>("http://localhost:8080/api/v1/us");
  }

  public getStateStatus(stateCode: string): Observable<StatusModel>{
    return this.http.get<StatusModel>("http://localhost:8080/api/v1/state/" + stateCode);
  }
}
