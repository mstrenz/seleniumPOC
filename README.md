# Selenium Gradle Project
 This is intended to be a starting point for using selenium to automate browser interactions using gradle and chrome
 
 
## RUNNING TESTS FROM COMMAND LINE

All tests will be run with the main test target.  Other targets can be run to do api only/first (api/ui)

```./gradlew test```

To run specific tests/class use the --tests parameter

```./gradlew test --tests=TestClass```

```./gradlew test --tests=*TestMethod```

## RUNTIME PARAMETERS
Runtime parameters(baseUrl) can be passed in using the -P flag and retrieved via System Properties.

```./gradlew -PbaseUrl=http://localhost:8080 test```