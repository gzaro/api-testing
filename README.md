# api-testing
A simple serenity - rest assured API test

This is a demo of a REST API test suite using serenity and rest assured libraries.

To run the suite:

```
./gradlew clean test
```

To generate the report:


```
./gradlew aggregate
```

The test case report looks like this:

![Sample report](sample/report.png?raw=true "Sample report")

And the API call log:

![Sample API call log](sample/rest_call.png?raw=true "Sample API call log")
