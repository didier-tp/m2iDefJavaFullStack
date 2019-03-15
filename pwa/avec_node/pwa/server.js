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
//req.params.numero
res.send({ id : 1  , title : "news1" , text : "text of news1" });

});

app.use(require('express-static')('./')); //AFTER OTHER routes to serve static files !!!

app.listen(8282 , function () {
  console.log("simple express node server listening at 8282");
});