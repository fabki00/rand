$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/randstad/test/TmpSearch.feature");
formatter.feature({
  "id": "people-search",
  "description": "As a regular employee \nI can search for other employees \nso that I can find their contact information, title, or photo",
  "name": "People search",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 13148729000,
  "status": "passed"
});
formatter.scenario({
  "id": "people-search;search-by-invalid-last-name",
  "tags": [
    {
      "name": "@us-68000184-007",
      "line": 168
    }
  ],
  "description": "",
  "name": "Search by invalid last name",
  "keyword": "Scenario",
  "line": 169,
  "type": "scenario",
  "comments": [
    {
      "value": "#\tScenario: Search by valid last name",
      "line": 150
    },
    {
      "value": "#\t\tGiven user is on search page",
      "line": 151
    },
    {
      "value": "#\t\tWhen user enters \"Doe\" as employee last name",
      "line": 152
    },
    {
      "value": "#\t\tAnd he submits search request",
      "line": 153
    },
    {
      "value": "#\t\tThen ensure list of employees with last name \"Doe\" is presented",
      "line": 154
    },
    {
      "value": "#\tScenario: Partial search by valid last name",
      "line": 156
    },
    {
      "value": "#\t\tGiven user is on search page",
      "line": 157
    },
    {
      "value": "#\t\tWhen he enters \"D\" as employee last name",
      "line": 158
    },
    {
      "value": "#\t\tAnd he submits request",
      "line": 159
    },
    {
      "value": "#\t\tThen ensure the list of employees with last name starting with D is presented",
      "line": 160
    },
    {
      "value": "#\tScenario: Partial search with non-alphanumeric characters",
      "line": 162
    },
    {
      "value": "#\t\tGiven the user is on the search people page",
      "line": 163
    },
    {
      "value": "#\t\tWhen he enters * as employee last name",
      "line": 164
    },
    {
      "value": "#\t\tAnd he submits search request",
      "line": 165
    },
    {
      "value": "#\t\tThen the list of all employees is  presented",
      "line": 166
    }
  ]
});
formatter.step({
  "name": "user is on search page",
  "keyword": "Given ",
  "line": 170
});
formatter.step({
  "name": "user enters \"familyName\u003dxyz\" in search box",
  "keyword": "And ",
  "line": 174,
  "comments": [
    {
      "value": "#       And the following search item does not exist #TODO  maybe change to: the following search string does not exist so we can reuse it for other searches (department etc)",
      "line": 171
    },
    {
      "value": "#       |givenName  | familyName  | email                         |",
      "line": 172
    },
    {
      "value": "#       | xyz       | qwert       |  xyz@whitestratus.com  |",
      "line": 173
    }
  ]
});
formatter.step({
  "name": "user submits search request",
  "keyword": "When ",
  "line": 175
});
formatter.step({
  "name": "the output should be",
  "keyword": "Then ",
  "line": 176,
  "rows": [
    {
      "cells": [
        "givenName",
        "familyName",
        "email"
      ],
      "line": 177
    }
  ]
});
formatter.match({
  "location": "PeopleSearchStepDefs.user_is_on_search_page()"
});
formatter.result({
  "duration": 1947832000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "familyName\u003dxyz",
      "offset": 13
    }
  ],
  "location": "PeopleSearchStepDefs.user_enters_in_search_box(String)"
});
formatter.result({
  "duration": 191620000,
  "status": "passed"
});
formatter.match({
  "location": "PeopleSearchStepDefs.user_submits_search_request()"
});
formatter.result({
  "duration": 2602117000,
  "status": "passed"
});
formatter.match({
  "location": "PeopleSearchStepDefs.the_output_should_be(User\u003e)"
});
formatter.result({
  "duration": 106094000,
  "status": "passed"
});
formatter.after({
  "duration": 179327000,
  "status": "passed"
});
});