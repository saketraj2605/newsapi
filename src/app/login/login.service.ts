import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
//import { environment } from '../environment';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})

export class LoginService {
  loginUrl = '/newsbuddy'+'/user/login';
  constructor(private http: HttpClient) {
    this.http = http;
  }
  login(loginData: any): Observable<any> {
    return this.http.post<any[]>(this.loginUrl, loginData,httpOptions);
  }
}