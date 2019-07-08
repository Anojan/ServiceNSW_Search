Feature: Search Products 

Background: 
	Given ServiceNSW Page is Loaded 
	
Scenario Outline: Search Product1 in Ebay 
	When Search Product "apply for a number plate" 
	Then navigate to apply page
	When click Find Location tab
	Then navigate to find serviceNSW location page 
	When search for "<SuburbName>" 
	Then "<ServiceCentreName>" is available in the results
	
	Examples: Suburb Names and Centres 
		|	SuburbName	|	ServiceCentreName	|
		|	Sydney 2000	|	Marrickville Service Centre		|