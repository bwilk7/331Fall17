addEventListener("message", function(event) {
   var start = event.data[0]
   var size = event.data[1]
   for(var i = start; i < size; i++)
   {
 	var factors = factor(i)
	if(factors.length == 2)
	{
		postMessage(i);
	}
   }
})

function factor(num){
    var factors = []
    for (var i=1;i<=num;i++){
        if (num % i == 0){
            factors.push(i)
        }
    }
    return factors
}
