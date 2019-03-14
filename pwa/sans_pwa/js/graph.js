var ctx = document.getElementById("myChart").getContext('2d');
var fx = document.getElementById("fx").value;
var xMin = document.getElementById("xMin").value;
var xMax = document.getElementById("xMax").value;
var btnDraw = document.getElementById("btnDraw");

btnDraw.addEventListener("click",function(event){
	//var x=2
	//var y=eval(fx);
	//alert("y=f(x)=" + y);
	var x,y;
	yValues=[];
	xMin=Number(xMin)*1.0;xMax=Number(xMax)*1.0;
	var n=100;
	var dx=(xMax-xMin)/n;
	for(x=xMin;x<=xMax;x+=dx){
		   y=eval(fx);
		   yValues.push({x:x,y:y});
	}
	console.log(yValues);
	var myChart = 
	new Chart(ctx, 
			{
			type: 'line',
			data: yValues,
			options: {
				scales: {
					yAxes: [{
						stacked: true
					}]
				}
			  }
			});
	
});
/*
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
*/