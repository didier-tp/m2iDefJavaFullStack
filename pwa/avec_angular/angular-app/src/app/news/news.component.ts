import { Component, OnInit } from '@angular/core';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

public numNews : number;
public news : object;
public onGetNews(event : any){
  this.newsService.getNewsViaRest$(this.numNews)
                  .subscribe((news)=>{this.news = news;},
                             (err)=>{ console.log(err);});
  /*this.news = {
    id: this.numNews ,
    title : "news ..." ,
    text : "texte news"
  };*/
}
  constructor(private newsService : NewsService) { }

  ngOnInit() {
  }

}
