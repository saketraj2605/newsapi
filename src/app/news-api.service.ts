import { Injectable } from '@angular/core';
import { HttpClient  } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NewsApiService {

  api_key = 'c923741c8fca4c9fb1a581ba3f96f692';
  language:String ='en';
  constructor(private http:HttpClient) { }
  initSources(){
     return this.http.get('https://newsapi.org/v2/sources?language='+this.language+'&apiKey=' + this.api_key);
  }
  initArticles(){
   return this.http.get('https://newsapi.org/v2/top-headlines?language='+this.language+'&apiKey='+this.api_key);
  }
  getArticleByLanguage(language: String){
    console.log(language);
    this.language = language;

  }
  getArticlesByID(source: String){
   return this.http.get('https://newsapi.org/v2/top-headlines?sources='+source+'&apiKey='+this.api_key);
  }
  getArticlesByKeyword(keyword:String)
  {
    return this.http.get('https://newsapi.org/v2/everything?q='+keyword+'&apiKey='+this.api_key);
  }
  
} 