let x : number;
x=14;
//x="abc";
console.log(x);

let s1 = "x="+x;
console.log(s1);

let s2 = `x=${x}`; //template string (es2015,ts)
console.log(s2);

/*let refFonction = function(){
    console.log("ok");
}*/
let refFonction = () => {
    console.log("ok");
}
setTimeout(refFonction , 2000);

setTimeout( () => { console.log("coucou"); } , 3000);

let tab : string[] = [ "ile" , "de" , "france"];

for(let i=0;i<tab.length;i++){
    console.log(tab[i]);
}

//for au sens forEach (depuis es2015 et typescript):
for(let s of tab){
    console.log(s);
}


class Personne {
    numero : number = 1;
    nom : string = "toto";
}

let p1 = new Personne();
console.log(p1);