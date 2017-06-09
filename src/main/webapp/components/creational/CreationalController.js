var CreationalController =  ['$scope', '$http', 'PlayerService', function($scope, $http, PlayerService) {
	$scope.sendPost = function() {
		var req = {
			url: "/music-boox/service/creational",
			method: "POST",			
			data: JSON.stringify({
                score: $scope.scorePost
            })
		}
		$http(req).then(function(response) {
			if (response.data.status === 0) {
				PlayerService.play(response.data.scoreGuid);
			}
        }, function (response) {
        	alert("Sorry, there was a problem...");
        });
	}
}];