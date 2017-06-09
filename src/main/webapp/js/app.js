var app = angular.module('music-boox', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider
		.when('/home',{
			templateUrl: 'home.html'
		})
		.when('/settings',{
			templateUrl: 'settings.html'
		})
		.when('/about',{
			templateUrl: 'about.html'
		})
		.when('/contact',{
			templateUrl: 'contact.html'
		})
		.when('/creational',{
			templateUrl: 'components/creational/creational.html'
		})
		.when('/behavioral',{
			templateUrl: 'components/behavioral/behavioral.html'
		})
		.when('/structural',{
			templateUrl: 'components/structural/structural.html'
		})
		.when('/applet',{
			templateUrl: 'applet.html'
		});
});

/** Controllers **/
app.controller('MenuController', MenuController);
app.controller('PlayerController', PlayerController);
app.controller('CreationalController', CreationalController);
app.controller('SettingsController', SettingsController);

/** Services **/
app.service('PlayerService', PlayerService);

/** Directives **/

