# What is it?
This RESTful API uses Google's libphonenumber library to extract phone numbers from submitted resources. 
This API uses Jersey Web Services framework with Maven.


# How to use
## HTTP Client
### GET
```
http://localhost:8080/restservice/api/phonenumbers/parse/text/{anyphonenumber}
#### Example
http://localhost:8080/restservice/api/phonenumbers/parse/text/647-860-3041
```

### POST
```
http://localhost:8080/restservice/api/phonenumbers/parse/text/file
If you read "Success" in the client, you will see the phone numbers printed on the console
```
# To Do's
