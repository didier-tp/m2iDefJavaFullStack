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
	
	
});