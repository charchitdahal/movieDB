
## How is Spring Backend Configured

I am using Controller, Model and Repository Layers. <br>
<br>
<b>Controller</b>

Controller provides API to make calls and requests to show result to the user.  Controller injects into a view for rendering. In this case, JSON for a restful API request. 

1. Genre Controller.

2. Movie Controller.

<b>Model</b>

I am using a Model layer to merely provide methods to access state of app. 

1. Actor
2. Genre
3. Movie

<b>Repository</b>

Repo is used between the service layer and the model layer to read/write from database. It used Spring Data JPA to access data from relational database. 

1. Genre Repository
2. Movie Repository




