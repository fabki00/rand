Feature: People search
    As a regular employee 
    I can search for other employees 
    so that I can find their contact information, title, or photo
    
      
    @us-68000184-001
    Scenario: Enter normal single string search criteria into the search textbox, 
    and be able to trigger the display of search results.
    Given user is on search page
    And user is regular user
    And current default scope is "People"
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
        Then new default scope is "<newScope>" 
        And new default scope "<newScope>" is saved accross browser sessions
    Examples:
        | currentScope      |  newScope       |
        | Documents         |  People         |
        | People            |  Documents      |
        | Site content      |  Documents      |
        | Documents         |  Site content   |
        | People            |  Site content   |
        | Site content      |  People         |
        
    @us-67698034-001     
    Scenario: For "People" scope, view search results that include relevant, helpful attributes for the items returned 
    for the selected scope. Search people by valid last name
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                         | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "familyName=Allen" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email |
        |Charles  |Allen      | Charles.Allen@whitestratus.com |

    @us-67698034-002
    Scenario: For "People" scope, view search results that include relevant, helpful attributes for the items returned 
    for the selected scope.Search people by valid first name
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |
    
    @us-67698182-001    
    Scenario: Sort results by any of the visible attributes.  # TODO add more employees and sorted output
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        And user sorts results by "givenName"
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |
     
     @us-67698182-002   
     Scenario: Sort results by any of the visible attributes.  # TODO add more employees and sorted output
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        And user sorts results by "familyName"
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |
    
    @us-67698182-003   
     Scenario: Sort results by any of the visible attributes.  # TODO add more employees and sorted output
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        And user sorts results by "email"
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |
  
  @us-67698318-001    
    Scenario: Toggle the direction of the sort.  # TODO add more employees and sorted output
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        And user sorts results by "givenName"
        And user toggles direction of the sort
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |
     
     @us-67698318-002   
     Scenario: Toggle the direction of the sort.  # TODO add more employees and sorted output
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        And user sorts results by "familyName"
        And user toggles direction of the sort
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |
    
    @us-67698318-003   
     Scenario: Toggle the direction of the sort.  # TODO add more employees and sorted output
        Given user is on search page 
        And current default scope is "People"
        And the following employees exist
        |givenName  | familyName  | email                           | 
        | Charles   | Allen     | Charles.Allen@whitestratus.com  |
        | Allen     | Martinez  | Allen.Martinez@whitestratus.com |
        And user enters "givenName=Allen" in search box
        When user submits search request
        And user sorts results by "email"
        And user toggles direction of the sort
        Then the output should be 
        |givenName | familyName | email |
        |Allen    | Martinez  | Allen.Martinez@whitestratus.com |  
    
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
        
    
       
 #   @us-014-001       # TODO maybe should rewrite as separate scenarios (with different output)       
 #   Scenario Outline: Get real-time search recommendation
 #       Given user is on search page
 #       And user is regular user
 #       And current default scope is <currentScope>
 #       When user types search query
 #       Then I get real-time recommendation
        
 #   Examples:
 #       |  <currentScope>   |   <icon>          |   <response>                  |
 #       |  Documents        | Documents         |   title, link to document     |
 #       |  People           | People thumbnail  | name , link to profile page   |
 #       | Site Content      | HTML icon         | title, link to page           |
        
        # if we type A, Ab, Abc, Abcd, etc. in the search box we should see all corresponding  names in recommendations
       
        
   
   
        
 