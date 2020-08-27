
## How to run backend.

<b>How to Configure Tomcat?</b>

1. Click on Add configuration
2. Choose and Tomcat from server
3. Change HTTP Proxy to 8080
4. Go to Deployment and add movieDB:war exploded
5. Remove everything from Application context and just keep '/'.

## How to check API. 

1. http://localhost:8080/api/genre gives you genre API in JSON.
2. http://localhost:8080/api/movie gives you movie API in JSON.

Use spring front end to get/post. You may use Postman to call onto the API as well.



