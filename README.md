# What is it?
This RESTful API uses Google's libphonenumber library to extract phone numbers from submitted resources. 
This API uses Jersey Web Services framework with Maven.

# What you will need
[Eclipse IDE](http://www.eclipse.org/downloads/packages/release/Neon/3)
[Apache Tomcat 8.x](https://tomcat.apache.org/download-80.cgi)

# How to run
Import the WAR file named "restservice"



# How to use
## Web Browser & HTTP Client

### GET
```
http://localhost:8080/restservice/api/phonenumbers/parse/text/{anyphonenumber}
#### Example
http://localhost:8080/restservice/api/phonenumbers/parse/text/647-860-3041
```

### POST
### HTTP Client
```
Content-type:text/plain
http://localhost:8080/restservice/api/phonenumbers/parse/text/file
```
### Web Browser
```
Web browser won't allow POST methods. Will return 405 error, but the output will still be displayed in console(if you are running from IDE)
```

