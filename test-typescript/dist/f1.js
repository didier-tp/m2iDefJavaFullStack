"use strict";
var x;
x = 14;
//x="abc";
console.log(x);
var s1 = "x=" + x;
console.log(s1);
var s2 = "x=" + x; //template string (es2015,ts)
console.log(s2);
/*let refFonction = function(){
    console.log("ok");
}*/
var refFonction = function () {
    console.log("ok");
};
setTimeout(refFonction, 2000);
setTimeout(function () { console.log("coucou"); }, 3000);
var tab = ["ile", "de", "france"];
for (var i = 0; i < tab.length; i++) {
    console.log(tab[i]);
}
//for au sens forEach (depuis es2015 et typescript):
for (var _i = 0, tab_1 = tab; _i < tab_1.length; _i++) {
    var s = tab_1[_i];
    console.log(s);
}
var Personne = /** @class */ (function () {
    function Personne() {
        this.numero = 1;
        this.nom = "toto";
    }
    return Personne;
}());
var p1 = new Personne();
console.log(p1);
//# sourceMappingURL=f1.js.map