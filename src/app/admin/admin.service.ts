import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';


const httpOptions={
  headers:new HttpHeaders({
    'Content-type':'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})

export class AdminService {
  adminUrl='/newsbuddy'+'/user/list';
  blockUserUrl='/newsbuddy'+'/user/blacklist';
  constructor(private http: HttpClient) {
    this.http = http;
  }
  list():Observable<any>
  {
    return this.http.get<any[]>(this.adminUrl,httpOptions);
  }
  blockUser(user):Observable<any>
  {
    return this.http.post<any[]>(this.blockUserUrl, user,httpOptions);
  }
}
