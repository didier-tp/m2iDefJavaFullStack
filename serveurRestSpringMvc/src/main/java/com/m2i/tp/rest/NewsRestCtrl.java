package com.m2i.tp.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.dto.News;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/news" , headers="Accept=application/json")
//@CrossOrigin(origins = "*")
public class NewsRestCtrl {
	
	private Map<Long,News> mapNews = new HashMap<>();
	
		
	public NewsRestCtrl() {
		mapNews.put(1L,new News(1L,"news 1" , "texte de news 1 "));
		mapNews.put(2L,new News(2L,"news 2" , "fake news 2 "));
		mapNews.put(3L,new News(3L,"news 3" , "nouvelle news 3 "));
		mapNews.put(4L,new News(4L,"news 4" , "news 4 qui va bien "));
	}
	
	
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/news/1
	@RequestMapping(value="/{numNews}" , method=RequestMethod.GET)
	public ResponseEntity<News> getProduitByNum(@PathVariable("numNews")  Long numNews){
		News n = mapNews.get(numNews);
		if(n!=null) {
			n.setText(n.getText() + " " + (new Date()).toString());
			n.setTitle(n.getTitle()+ " java/springMvc");
			return new ResponseEntity<News>(n,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
	}
	
	

}
