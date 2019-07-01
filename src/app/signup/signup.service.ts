import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from '../environment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})

export class SignupService {
  signupUrl  = '/newsbuddy'+'/user/signup';
 // languageUrl = '/newsbuddy' + '/language/list';
  constructor(private http: HttpClient) {
    this.http = http;
  }
  signup(signupData: any): Observable<any> {
    return this.http.post<any[]>(this.signupUrl, signupData, httpOptions);
  }
  // getLanguages(): Observable<any> {
  //   return this.http.get(this.languageUrl);
  // }

}
