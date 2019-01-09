@AssignmentScenario
Feature: Validating session count in Highcharts
	Scenario: Compare session count between tool tip and highlighted window
	Given Open chrome browser and enter url
	When MouseOver to Jan 5 2018 and note only the session count
	And Click on it and that session will be highlighted
	Then Now Compare session count between tool tip and highlighted window
	
	