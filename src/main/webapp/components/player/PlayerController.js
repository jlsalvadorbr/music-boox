function convertToBinaryString(data) {
	var t = data || "" ;
	var ff = [];
	var mx = t.length;
	var scc= String.fromCharCode;
	for (var z = 0; z < mx; z++) {
		ff[z] = scc(t.charCodeAt(z) & 255);
	}
	return ff.join("");
}

function play(data) {
	data = convertToBinaryString(data);
	midiFile = MidiFile(data);
	synth = Synth(44100);
	replayer = Replayer(midiFile, synth);
	audio = AudioPlayer(replayer);
}

function playAudioClip(score) 
{
	document.MidiPlayerApplet.play(score);
}

function stopAudioClip() 
{
  	document.MidiPlayerApplet.stop();
}

/* 
 * Backend stream must be typed as "text/plain; charset=x-user-defined" to force response parsing as binary string
 * AngularJs does not provide overrideMimeType() function
 */
var PlayerController =  ['$scope', '$http', function($scope, $http) {
	$scope.sendPost = function() {
		var req = {
			url: "/music-boox/service/player/score",
			method: "POST",			
			data: JSON.stringify({
                score: $scope.scorePost
            })
		}
		$http(req).then(function(response) {
			play(response.data)
        }, function (response) {
        	alert("Sorry, there was a problem while playing...");
        });
	}
    
	$scope.sendGet = function() {
		var req = {
			url: "/music-boox/service/player/score/" + $scope.scoreGet,
			method: "GET"
		}
		$http(req).then(function(response) {
			play(response.data)
        }, function (response) {
        	alert("Sorry, there was a problem while playing...");
        });
	}
	
	$scope.sendApplet = function() {
		playAudioClip($scope.scoreApplet)
	}
}];