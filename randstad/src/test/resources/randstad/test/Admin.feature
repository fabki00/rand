Feature: Admin functionality in People Search
    As an Administrator 
    I can  configure various settings
    so that I can customize search according to users needs
    
    @test-us001-001
    Scenario: Configure People scope
        Given I am on administrator page
        And I login as administrator
        When I choose People scope
        Then users see People in available scopes
    
    @test-us001-002
    Scenario: Configure Document scope
        Given I am on administrator page
        And I login as administrator
        When I choose Document scope
        Then users see Document in available scopes
    
    @test-us001-003
    Scenario: Configure Site Content scope
        Given I am on administrator page
        And I login as administrator
        When I choose Site Content scope
        Then users see Site Content in available scopes
    
    @test-us002-001  
    Scenario: Enable predictive search recommendations
        Given I am on administrator page
        And I login as administrator
        When I choose enable Predictive Search recommendations
        Then users can use predictive search recommendations in search
     
    @test-us002-002    
    Scenario: Disable predictive search recommendations
        Given I am on administrator page
        And I login as administrator
        When I choose disable Predictive Search recommendations
        Then user cannot use predictive search recommendations in search
     
     @test-us-003-001   
     Scenario: Configure pagination to occur via server cursors
        Given I am on administrator page
        And I login as administrator
        When I enable pagination via server cursors
        Then user can get to other result pages   # by clicking page number or arrow 
     
     @test-us-003-002
     Scenario: Configure pagination to occur on client over full results set
        Given I am on administrator page
        And I login as administrator
        When I enable pagination on client
        Then user can get to other result pages   # by scrolling 
    
