Feature: People search
	As a regular employee 
	I can search for other employees 
	so that I can find their contact information, title, or photo		

#	Scenario Outline: Search by valid last name
#		Given user is on search page 
#		And user enters <familyName> as employee last name
#		When the search is performed
#		Then the output should be <output>
		
#		Examples:
#			|givenName  | familyName | email	| 
#			| Charles	| Allen	| Charles.Allen@whitestratus.com |
#			|	| 		|	
    
    @us-68000184-001	
	Scenario: Search people by valid name
		Given user is on search page 
		And the following employees exist
		|givenName  | familyName  | email                         | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        | Allen     | Riordan   | Allen.Riordan@whitestratus.com  |
    	And user enters "Allen" in search box
		When user submits search request
		Then the output should be 
		|givenName | familyName | email                           |
		| Charles   | Allen     | Charles.Allen@whitestratus.com  |
		| Allen     | Martinez  | Allen.Martinez@whitestratus.com |
		| Allen     | Riordan   | Allen.Riordan@whitestratus.com  |
		
	@us-67697804-001  @us-67697804-002 @us-67697804-003 @us-67697804-004 @us-67697804-005 @us-67697804-006 
    Scenario Outline: Choose a default search scope which will be saved accross browser sessions
        Given user is on search page
        And user is regular user    
        And current default scope is "<currentScope>"
        When user chooses "<newScope>" as default scope
        Then new default scope "<newScope>" is saved accross browser sessions
    Examples:
        | currentScope      |  newScope       |
        | Documents         |  People         |
        | People            |  Documents      |
        | Site content      |  Documents      |
        | Documents         |  Site content   |
        | People            |  Site content   |
        | Site content      |  People         |
	
	@us-68000184-002
	Scenario: Search people by valid last name
        Given user is on search page 
        And the following employees exist
        |givenName  | familyName  | email                         | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "familyName=Allen" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email |
        |Charles  |Allen      | Charles.Allen@whitestratus.com |
    
    @us-68000184-003    
    Scenario: Search people by valid last name with international characters
        Given user is on search page 
        And the following employees exist
        |givenName  | familyName  | email                 | 
        | Urs   | Hšlzle   | Urs.Hšlzle@whitestratus.com  |
        And user enters "familyName=Hšlzle" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email |
        | Urs   | Hšlzle   | Urs.Hšlzle@whitestratus.com  |
    
    @us-68000184-004    
    Scenario: Search people by valid last name with international characters
        Given user is on search page 
        And the following employees exist
        |givenName  | familyName  | email                               | 
        | Wojciech  | Chach—lski | Wojciech.Chacholski@whitestratus.com |
        And user enters "familyName=Chach—lski" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email                                 |
        | Wojciech  | Chach—lski | Wojciech.Chacholski@whitestratus.com |

	
	@us-68000184-005
	Scenario: Search people by valid first name
        Given user is on search page 
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |
        |Allen     | Riordan | Allen.Riordan@whitestratus.com  | 
        
    @us-68000184-006
    Scenario: Search people by valid first name
        Given user is on search page 
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Barbie    | Davis     | Barbie.Davis@whitestratus.com     |
        And user enters "givenName=Barbie" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email |
        | Barbie    | Davis     | Barbie.Davis@whitestratus.com     |
                	
    
    Scenario: Search people by partial last name  # TODO change name so there is more than one result
        Given user is on search page 
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        | Dannielle |  Davis    | Dannielle.Davis½@whitestratus.com |
        | Barbie    | Davis     | Barbie.Davis@whitestratus.com |
        | Charles   | Davis      |Charles.Davis@whitestratus.com |
        | Mark       |Davis      |Mark.Davis@whitestratus.com |
        | Robert     |Davis      |Robert.Davis@whitestratus.com |
        And user enters "familyName=Dav" in search box
        When user submits search request
        Then the output should be 
        |givenName  | familyName  | email                           | 
        | Dannielle |  Davis      | Dannielle.Davis½@whitestratus.com |
        | Barbie    | Davis       | Barbie.Davis@whitestratus.com |
        | Charles   |Davis        |Charles.Davis@whitestratus.com |
        | Mark       |Davis      |Mark.Davis@whitestratus.com |
        | Robert     |Davis      |Robert.Davis@whitestratus.com |


    
    Scenario: Search people by partial first name
        Given user is on search page 
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | David   | Anderson     | David.Anderson@whitestratus.com  |
        And user enters "givenName=Dav" in search box
        When user submits search request
        Then the output should be                # TODOverify results
        |givenName | familyName | email |
        |David   | Anderson  | David.Anderson@whitestratus.com |  
	

	
#	Scenario: Search by valid last name  
#		Given user is on search page
#		When user enters "Doe" as employee last name
#		And he submits search request
#		Then ensure list of employees with last name "Doe" is presented
		
#	Scenario: Partial search by valid last name
#		Given user is on search page
#		When he enters "D" as employee last name
#		And he submits request
#		Then ensure the list of employees with last name starting with D is presented
		
#	Scenario: Partial search with non-alphanumeric characters
#		Given the user is on the search people page
#		When he enters * as employee last name
#		And he submits search request
#		Then the list of all employees is  presented  
	
	@us-68000184-007	
	Scenario: Search by invalid last name
        Given user is on search page 
 #       And the following search item does not exist #TODO  maybe change to: the following search string does not exist so we can reuse it for other searches (department etc)
 #       |givenName  | familyName  | email                         | 
 #       | xyz       | qwert       |  xyz@whitestratus.com  |        
        And user enters "familyName=xyz" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email |
   
   @us-67698066-001    #TODO verify the number of results is correct according to data file 
    Scenario Outline: Get a visual indication of the total number of results available per  results scope.
        Given user is on search page 
        And current default scope is "People"
        And number of employees with <familyName> is <number>
        When user submits search request
        Then number of results should be <number>
        
     Examples:
     | familyName       |  number   |
     | Allen            |  3        |
     | Davis            |  5        |   
     | Abc              |  1        |
     | Xyz              |  0        |     
        
	Scenario: Search by department name
		Given user is on search page 
		When user enters "Finance" in search box
		And  user submits search request
		Then the output should be
		|Marilou   |Lee |Marilou.Lee@whitestratus.com    |063-551-8615    | Finance |
        | Carolynn  |  Smith   |Carolynn.Smith@whitestratus.com  |248-895-3777   | Finance |
        |Dorotha    |Moore   |Dorotha.Moore@whitestratus.com  |778-344-4050    |Finance |
        |Kasandra   |Jackson |Kasandra.Jackson@whitestratus.com   |749-459-2145     |Finance|
        |Buffy     |Hall    |Buffy.Hall@whitestratus.com    |478-890-4501   | Finance |
        |Dannielle   | Davis   |Dannielle.Davis@whitestratus.com    |367-450-1026     |Finance|
        |Madison    |Jones    |Madison.Jones@whitestratus.com  | 646-207-7308     |Finance |
        |Laurene  |Thompson    | Laurene.Thompson@whitestratus.com   |424-090-0152     |Finance |
		
#	Scenario: Search by title
#		Given the user is on search people page
#		When he enters "Manager" as title
#		And he submits search request
#		Then ensure the list of employees with title "Manager" is presented