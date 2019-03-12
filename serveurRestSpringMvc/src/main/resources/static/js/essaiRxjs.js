console.log('essai rxjs');

const { of, range , interval } = rxjs;
const { map, filter , sort } = rxjs.operators;

const obsNums = of(1, 2, 3 ,4 ,5);
const squareValuesFunctionOnObs = map((val) => val * val);
const obsSquaredNums = squareValuesFunctionOnObs(obsNums);
obsSquaredNums.subscribe(x => console.log(x));

const obsStrs = of("un" , "deux" , "trois");
obsStrs.pipe(
			map((s)=>s.toUpperCase())
			)
       .subscribe(s => console.log(s));

const obsVals = of(12 , -15 , 30 , -8 , 40);
obsVals.pipe(
			filter( (v) => v >= 0)
			)
       .subscribe(v => console.log(v));

range(1,10).pipe(
			filter( (v) => v % 2 === 0 )
			)
       .subscribe(v => console.log(v  +" est une valeur paire"));

const obsTab = of([{numero:1,label:'produit1',prix:40.0},
		            {numero:2,label:'produit2',prix:30.0},
		            {numero:3,label:'produit3',prix:35.0},
		            {numero:4,label:'produit4',prix:15.0}, 
		            {numero:5,label:'produit5',prix:35.0}
		            ]);
obsTab.pipe(
		map( (tab) => tab.sort( (p1,p2) => (p1.prix > p2.prix) ) )
		)
   .subscribe(t => console.log( JSON.stringify(t)) );

/*
range(1, 10).pipe(
  filter(x => x >= 5),
  map(x => x * x)
).subscribe(x => console.log(x));
*/

/*
const obsvI1 = interval(1000);
//subscriptionObjsvI1 is the result of .subscribe() call
const subscriptionObjsvI1 = obsvI1.subscribe(n =>
   { console.log(`the number of interval  occurrence (starting at 0) is ${n} `); 
     if(n>=5) {
    	 subscriptionObjsvI1.unsubscribe(); //stop if n>=5
     }
   });
*/
     