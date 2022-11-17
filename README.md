# springboot-testing
Project to test springboot funcionalities.

# Postman collection
You can import a Postman collection from {work_space}/DOC/postmanCollections for check the new funcionalities

# Testing Exception handler

### 1. Exception handler

[CustomExceptionsHandler](src/main/java/com/freyvik/springboot_testing/rest/app/handlers/CustomExceptionsHandler.java) is the exception handler that you can use for set custom responses when a Exception is thown. This class only need the annotation  _@ControllerAdvice_  to works. Then you need to add as many methods as exceptions you want to customize recognizer by  _@ExceptionHandler_ .

### 2. Custom exceptions

[ValidationRequestException](src/main/java/com/freyvik/springboot_testing/rest/app/exceptions/ValidationRequestException.java) and [NoOddException](src/main/java/com/freyvik/springboot_testing/rest/app/exceptions/NoOddException.java) are two exceptions as example that are created to contemplate some error that we want to catch and generate controlated error responses.