var express = require('express'),
        app = express(),
        server = require('http').createServer(app);
var io = require("socket.io")(server);		
var searchapi = require('./controllers/searchapi');		
var fs = require('fs');
var exec = require('child_process').exec;
var child;

app.use(express.static(__dirname + '/public'));

app.get('/', function(req, res){
	res.sendFile(__dirname + '/public');
});

io.sockets.on('connection', function (socket) {
	console.log("Connected using sockets");
		
	socket.on('clickedsearch', function(data){	
		var time = data.timeframe;
		socket.emit('getting data', "fetching data");
		searchapi.clickedSearchButton(time,function(finaldata){
		// 		if(finaldata == "success"){
		// 			child = exec('/home/ubuntu/YouTube-Data-Analysis/scripts/getdata.sh',function(error,stdout,stderr){
		// 	if (error) {
		// 		console.error(error);
		// 		socket.emit('getting data', "failed");
		// 		return;
		// 	}
		// 	console.log('stdout: ' + stdout);
		// 	console.log('stderr: ' + stderr);
		// 	socket.emit('getting data', "success");
		// 	});	
		// 	}else{
		// 		socket.emit('getting data', "failed");
		// 	}
			});
	});
	
	socket.on("disconnect", function () {
        console.log("Disconnected");
    });
	
});

	
	
server.listen(8080);

console.log('Server is running at port 8080');
