function rafraichirTableau() {
	//document.querySelector('#tableProd tbody > tr').remove();
	/*
	$.ajax({
		type: "GET",
		url: "./rest/produit" ,
		success: function (data,status,xhr) {
			var tabProd = data;
			console.log("tabProd=" + JSON.stringify(tabProd));
			for(i in tabProd){
				var prod = tabProd[i];
				var htmlNewLine = "<tr><td>"+prod.numero+"</td><td>"+
				    prod.label +"</td><td>"+ prod.prix + "</td></tr>";
				$('#tableProd tbody:last-child').append(htmlNewLine);
			}
		},
		error: function( jqXHR, textStatus, errorThrown ){
			console.log(textStatus);
		}
	});
	*/
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
	
	/*
	document.querySelector('#btnAddProd').addEventListener('click',function(){
		var nouveauProduit = { numero: null, label: null , prix : null};
		nouveauProduit.label = 	$('#label').val();
		nouveauProduit.prix = Number($('#prix').val());	
		$.ajax({
			type: "POST",
			url: "./rest/produit" ,
			data : JSON.stringify(nouveauProduit),
			dataType : "json",
			contentType : "application/json",
			success: function (data,status,xhr) {
				console.log("nouveau produit ajoute="+JSON.stringify(data));
				rafraichirTableau();
			},
			error: function( jqXHR, textStatus, errorThrown ){
				console.log(textStatus);
			}
		});
		// var objJs = JSON.parse(jsonString);
	});
	
	*/
	
});