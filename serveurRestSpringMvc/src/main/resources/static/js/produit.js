function rafraichirTableau() {
	
	$.ajax({
		type: "GET",
		url: "./rest/produit" ,
		success: function (data,status,xhr) {
			$('#tableProd tbody > tr').remove();
			var tabProd = data;
			for(i in tabProd){
				var prod = tabProd[i];
				var htmlNewLine = "<tr><td>"+prod.numero+"</td><td>"+
				    prod.label +"</td><td>"+ prod.prix + "</td></tr>";
				$('#tableProd tbody').append(htmlNewLine);
			}
		},
		error: function( jqXHR, textStatus, errorThrown ){
			console.log(textStatus);
		}
	});
	
}

$(function() {
	
	$('#btnRechercherParNum').on('click',function(){
		var numProd = $('#numProd').val();
		console.log("./rest/produit/" + numProd)
		$.ajax({
			type: "GET",
			url: "./rest/produit/" + numProd ,
			success: function (data,status,xhr) {
					var jsonString = JSON.stringify(data);
		            $('#resProd').html(jsonString);
			},
			error: function( jqXHR, textStatus, errorThrown ){
				console.log(textStatus);
			}
		});
		
	});
	
	
	$('#btnAddProd').on('click',function(){
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
		
	});
	
});