addEventListener('message',function(event){
	var N = event.data
	for(var i = 1; i < N; i++)
	{
	  postMessage(i * i)
	}
})
