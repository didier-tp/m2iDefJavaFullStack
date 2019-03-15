
function startNews(){ 

var btnGetNews = document.getElementById("idBtnGetNews");

btnGetNews.addEventListener("click" , (event) => {
	var numNews = document.getElementById("idNumNews").value;
	var wsUrl= "./news/"+numNews;
	fetch(wsUrl)
	    .then( (response) => {
	 	   if (response.status !== 200) {
	 		   var errString = 'Problem. Status Code: ' + response.status;
	 		   console.log(errString);  
	 		   return;
	 		   }
	 		   // Examine the text in the response :
	 		   response.json().then(function(data) {
	 			  var newsJsObject = data;
				  var jsonString = JSON.stringify(newsJsObject);
				  document.getElementById("idSpanNews").innerHTML=jsonString;
	 		   })
	    })
	 	.catch((err) =>{ console.log('Fetch Error :-S', err); });
});

}