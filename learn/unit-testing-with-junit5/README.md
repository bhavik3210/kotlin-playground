# General
- Junit5 Creates a new instance of object for each test. 
    - for example `user` object is created as a new instance for all tests in `UserTest` `QuestionTest` etc.
- Junit5 also creates a new instance of a class for each test.(See `QuestionTest` for clarification)
    - to change that use annotation `@TestInstance(Lifecycle.PER_CLASS)`, when we create the class with this annotation 
      it will create one instance of that class and run each of those tests within that instance of class
    - if we are on per method lifecycle then it will use new instance for each class BUT if we are on per class lifecycle 
      it will use singe class instance
    - Junit 4 was using per class lifecycle vs Junit 5 is using per method lifecycle by default
    - 
      

## Regular Test | `UserTest`
- use backticks for more descriptive name for each test

## Nested Test | `QuestionTest`
- use inner class to group together similar tests
- use backticks surrounding class name if appropriate to make all tests print out cohesive messaging for test reports

## Parameterized Test | `QuestionTest`
- use parameterized test to provide different variations of parameters on the same test

