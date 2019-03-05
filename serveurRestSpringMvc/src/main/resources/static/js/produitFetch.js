function rafraichirTableau() {
	//document.querySelector('#tableProd tbody > tr').remove();
	
	fetch("./rest/produit")
    .then( (response) => {
 	   if (response.status !== 200) {
 		   console.log('Problem. Status Code: ' + response.status);
 		   return;
 		   }
 		   // Examine the text in the response :
 		   response.json().then(function(data) {
 			  var tabProd = data;
 				console.log("tabProd=" + JSON.stringify(tabProd));
 				for(i in tabProd){
 					var prod = tabProd[i];
 					var htmlNewLine = "<tr><td>"+prod.numero+"</td><td>"+
 					    prod.label +"</td><td>"+ prod.prix + "</td></tr>";
 					$('#tableProd tbody:last-child').append(htmlNewLine);
 				}
 		   });
           }
 		)
 	.catch(function(err) {
         console.log('Fetch Error :-S', err);
      });
	
	
	
}

window.addEventListener("load", function() { 
	
	document.querySelector('#btnRechercherParNum').addEventListener('click',function(){
		var numProd = document.querySelector('#numProd').value;
		console.log("./rest/produit/" + numProd)
		fetch("./rest/produit/" + numProd)
           .then( (response) => {
        	   if (response.status !== 200) {
        		   console.log('Problem. Status Code: ' + response.status);
        		   return;
        		   }
        		   // Examine the text in the response :
        		   response.json().then(function(data) {
        		        console.log(data);
        		        var jsonString = JSON.stringify(data);
        		        document.querySelector('#resProd').innerHTML = jsonString;
        		   });
                  }
        		)
        	.catch(function(err) {
                console.log('Fetch Error :-S', err);
             });
	});
	
	
	document.querySelector('#btnAddProd').addEventListener('click',function(){
		var nouveauProduit = { numero: null, label: null , prix : null};
		nouveauProduit.label = 	document.querySelector('#label').value;
		nouveauProduit.prix = Number(document.querySelector('#prix').value);
		fetch("./rest/produit", 
			  { method: 'POST' ,
			    headers: {
			      'Accept': 'application/json',
			      'Content-Type': 'application/json'
			     },
			    body : JSON.stringify(nouveauProduit)
			  } )
			 .then( (response) => {
				 if (response.status == 200) {
					 response.json().then(
					   (data)=>{ 
						  console.log("nouveau produit ajoute="+JSON.stringify(data));
				                //rafraichirTableau();
				               }		 
					 );
				 }
			       } )
			 .catch((e)=>{console.log("error:"+e)})
		
	});
	

	
});