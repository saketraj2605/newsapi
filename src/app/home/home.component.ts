import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import {FormControl} from '@angular/forms';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isAdmin: boolean;
  mArticles:Array<any>;
  mSources:Array<any>;
  language: string = null;
  keyword: string = null; 
  constructor(private newsapi:NewsApiService){
    console.log('app component constructor called'); 
       
  }

  ngOnInit() {
       
     
    //load news sources
    this.newsapi.initSources().subscribe(data=> this.mSources = data['sources']);  
     //load articles
    this.newsapi.initArticles().subscribe(data => this.mArticles = data['articles']);
    }

  searchArticles(source){
    console.log("selected source is: "+source);
    this.newsapi.getArticlesByID(source).subscribe(data => this.mArticles = data['articles']);
  }
searchArticleByKeyword(){
  console.log("selected keyword is: "+this.keyword);
    this.newsapi.getArticlesByKeyword(this.keyword).subscribe(data => this.mArticles = data['articles']);
}
searchArticleByLanguage(){
  console.log("selected keyword is: "+this.language);
  
    this.newsapi.getArticleByLanguage(this.language);  
    this.ngOnInit();
}

}


