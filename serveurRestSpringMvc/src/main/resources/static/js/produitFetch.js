function myGenericJsGetFetchData(url){
	return new Promise((resolveWithJsData,reject)=>{
		fetch(url)
	    .then( (response) => {
	 	   if (response.status !== 200) {
	 		   var errString = 'Problem. Status Code: ' + response.status;
	 		   console.log(errString);  reject(errString);
	 		   return;
	 		   }
	 		   // Examine the text in the response :
	 		   response.json().then(function(data) {
	 			  resolveWithJsData(data);
	 		   }
	    })
	 	.catch((err) =>{ console.log('Fetch Error :-S', err); 
	 	                 reject(err); });
	});
}

function myGenericJsPostFetchData(url,jsObj){
	return new Promise((resolveWithJsData,reject)=>{
		fetch(url)
	    .then( (response) => {
	 	   if (response.status !== 200) {
	 		   var errString = 'Problem. Status Code: ' + response.status;
	 		   console.log(errString);  reject(errString);
	 		   return;
	 		   }
	 		   // Examine the text in the response :
	 		   response.json().then(function(data) {
	 			  resolveWithJsData(data);
	 		   }
	    })
	 	.catch((err) =>{ console.log('Fetch Error :-S', err); 
	 	                 reject(err); });
	});
}

function rafraichirTableau() {
	document.querySelector('#tbodyOftableProd').innerHTML="";
	
	myGenericJsGetFetchData("./rest/produit")
    .then( (data) => {
 			  var tabProd = data;
 				console.log("tabProd=" + JSON.stringify(tabProd));
 				var tableRef = document.getElementById('tbodyOftableProd');
 				for(i in tabProd){
 					var prod = tabProd[i];					
 					var newRow   = tableRef.insertRow(tableRef.rows.length);
 					var cell0  = newRow.insertCell(0);
 					cell0.appendChild(document.createTextNode(prod.numero));
 					var cell1  = newRow.insertCell(1);
 					cell1.appendChild(document.createTextNode(prod.label));
 					var cell2  = newRow.insertCell(2);
 					cell2.appendChild(document.createTextNode(prod.prix));
 				}
 		   }) 	
 		   .catch((err) => { console.log(err); });

}

window.addEventListener("load", function() { 
	
	document.querySelector('#btnRechercherParNum').addEventListener('click',function(){
		var numProd = document.querySelector('#numProd').value;
		console.log("./rest/produit/" + numProd)
		myGenericJsGetFetchData("./rest/produit/" + numProd)
           .then( (data) => {
        		        console.log(data);
        		        var jsonString = JSON.stringify(data);
        		        document.querySelector('#resProd').innerHTML = jsonString;
        		   })
        	.catch((err) => { console.log(err); });
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
				                rafraichirTableau();
				               }		 
					 );
				 }
			       } )
			 .catch((e)=>{console.log("error:"+e)})
		
	});
	

	
});