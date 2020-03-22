$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/compare/compare.feature");
formatter.feature({
  "name": "Compare two different page titles",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "DZone Header comparison",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@compare"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on \"https://dzone.com/articles/gradle-vs-maven\"",
  "keyword": "When "
});
formatter.match({
  "location": "comparestep_defsLogExamples.userIsOn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User on \"https://dzone.com/articles/api-security-weekly-issue-71\"",
  "keyword": "And "
});
formatter.match({
  "location": "comparestep_defsLogExamples.userOn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Compare",
  "keyword": "Then "
});
formatter.match({
  "location": "comparestep_defsLogExamples.compare()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});