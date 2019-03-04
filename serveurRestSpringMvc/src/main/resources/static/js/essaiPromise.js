console.log('coucou es2015');

function addition(a,b){
	var res=a+b;
	console.log("res=a+b="+res);
	return res;
}
/*
function cb1(){
	addition(5,6);
}

setTimeout( cb1 , 5000); //déclencher en différé 
                         //une callback au bout d'un délai de 5000ms
*/

//syntaxe simplifiée avec lambda expression (arrow function) depuis es2015:
//setTimeout( () => addition(5,6)   , 5000); 

//autre équivalent possible (moins bien / mois compact):
//setTimeout( function () { addition(5,6); }   , 5000); 
/*
//Enchainement sans promesse:
//d'abord 5+6 = 11 au bout de 5000ms
//seulement ensuite 11+3 , 3000ms après
//Enfer des callbacks , callback hell .
setTimeout( () =>  { var s1 = addition(5,6); 
                     setTimeout( () => addition(s1,3)   , 3000);
                    } 
                    , 5000); 
*/
function effectuerAdditionEnDiffere(delai,a,b){
	return new Promise((resolve,reject) => {
	              setTimeout( () => {
		            			  if(b>=0)
		            			     resolve(addition(a,b));
		            			  else 
		            				  reject("echec addition");
		            		  } , delai);
	                  });
}

effectuerAdditionEnDiffere(5000,5,6)
.then ( (resAdd1) => {
	                console.log("5+6=" + resAdd1);
	                return effectuerAdditionEnDiffere(3000,resAdd1,3)
                    })
.then ( (resAdd2) => {
	                console.log("11+3=" + resAdd2);
                    })                   
.catch( (e) => console.log("error:" + e));
