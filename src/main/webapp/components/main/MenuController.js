var MenuController =  ['$scope', function($scope) {
	
	$scope.showChilds = function(index){
		$scope.items[index].active = !$scope.items[index].active;
		$scope.items[index].image = $scope.getMenuImage(index);	
	};
	
	$scope.getMenuImage = function(index){
		if ($scope.items[index].active){
			return "images/minus.png";	
		} else {
			return "images/plus.png";
		}
	};

	$scope.items = [
	    {
	    	name: "Creational",
	    	url: "#/creational",
	        subItems: [
	            {name: "SubItem1"},
	            {name: "SubItem2"}
	        ]
	    },
	    {
	    	name: "Structural",
	    	url: "#/structural",
	        subItems: [
	            {name: "SubItem3"},
	            {name: "SubItem4"},
	            {name: "SubItem5"}
	        ]
	    },
	    {
	    	name: "Behavioral",
	    	url: "#/behavioral",
	        subItems: [
	            {name: "SubItem6"}
	        ]
        }
	];
}];