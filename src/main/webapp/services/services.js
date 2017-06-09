var PlayerService = function($http) {
	
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
	
	this.play = function(scoreGuid) {
		var req = {
			url: "/music-boox/service/player/" + scoreGuid,
			method: "GET"
		}
		$http(req).then(function(response) {
			play(response.data)
		}, function (response) {
			alert("Sorry, there was a problem while playing...");
		})
	}	
}
