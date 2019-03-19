//modules to load:
const express = require('express');


const app = express();
//express framework manage basic route in server side 
//with app.get() , app.post() , app.delete() , ...

app.use(require('body-parser').json());

/*
app.post('/subscribe', (req, res) => {
  const subscription = req.body;
  gSubscription = subscription;
  res.status(200).json({});
  
  console.log("received subscription:"+ JSON.stringify(subscription));
});*/


// GET (array) /new?nbDay=1
app.get('/news', function(req, res,next) {
//	Number(req.query.nbDay)
res.send( [{ id : 1  , title : "news1" ,
            text : "text of news1" } ]);
});
// GET /news/1
app.get('/news/:numero', function(req, res,next) {
var num = req.params.numero;
res.send(   { id : num  , 
             title : "news-"+num , 
			 text : "text of news at" + (new Date) });

});

//AFTER OTHER routes to serve static files !!!
//app.use(require('express-static')('./')); 
app.use(require('express-static')
('../angular-app/dist/angular-app')); 

app.listen(8282 , function () {
  console.log("http://localhost:8282/index.html");
});