# EMBL : Create REST API which stores, update, retrieves and deletes Person 
[![status](https://gitlab.cern.ch/mbouzas/embl/activity)](https://gitlab.cern.ch/mbouzas/embl/activity)


## Technology stack

* Backend:
    * Spring Boot (Maven, REST)
    * Spring Security OAuth 
    * h2 (in memory database)

* Moreover:
    * Postman Collection, testing OAuth 2.0 Authorization  and GET, POST, PUT, DELETE methods


## API structure

* Oauth.. Create Token:
    * POST /oauth/token   ----> Needed User credendials (creadted 2 users -> username: user, password: secrect / username:admin, password:secret )

* Methods:
    * POST     /api/persons           ---->  Create a list of Persons (JSON Person defined in the body)
    * GET      /api/person            ---->  Return all Persons
    * GET      /api/person/{personId} ---->  Return a Person (by Id)
    * PUT      /api/person/{personId} ---->  Update an existing Person (JSON Person defined in the body)
    * DELETE   /api/person/{personId} ---->  Remove a Person (by Id)

## Building from Source

### Prerequisites

To run the application you need at least Java8 and Maven installed.

#### IDEs

To reduce the boiler plate code we make use of [Lombok](https://projectlombok.org/), which requires to be [setup in your IDE](https://projectlombok.org/setup/overview) in order to compile the project.

### Check out sources
`git clone https://gitlab.cern.ch/mbouzas/embl.git`

### Compile and test; build all jars, distribution tarball, docs....
`mvn package`

### Run the App
You can run the app on the command line using `mvn spring-boot:run` or by building the jar file and running it with `mvn package` and `java -jar target/*.jar`.
Start the app opening the h2 console
`http://localhost:9090/h2` Console where you can manage all related with the DB. Check jdbc url, username and password in the `application.properties`.

### FINALLY READY!!!
Open a `Postman` Client and play with the REST API (attached Postman collection with headers and credentials to get token.. `please remember refresh the token` for GET, POST , PUT , DELETE methods.. Example Headers  Key:Autorization Value:bearer ced60f06-6480-440f-abc1=e6a82c25f09a

## Command line client interacts with the API
Create token

`curl -X POST \
  http://localhost:9090/oauth/token \
  -H 'authorization: Basic Y2xpZW50OnBhc3N3b3Jk' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: de20dd33-c6d4-8ed8-31d2-dc19882cf015' \
  -d 'password=secret&username=user&grant_type=password'`

{"access_token":"92c3b5f5-0784-4168-a6e2-1b4dc130c88c","token_type":"bearer","refresh_token":"6762217e-8315-4458-a63f-cf2f9e5fd823","expires_in":42842,"scope":"read write"}
*******************
Insert 2 persons

`curl -X POST \
  http://localhost:9090/api/persons \
  -H 'authorization: bearer 92c3b5f5-0784-4168-a6e2-1b4dc130c88c' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 166683d4-9874-7810-f5ad-b6cda4b0b5f3' \
  -d '{
  "Person": [{
    "first_name": "isa",
    "last_name": "lema",
    "age": "29",
    "favourite_colour": "red",
    "hobby": ["shopping", "football"]
  },
{
    "first_name": "Manu",
    "last_name": "Bouzas",
    "age": "30",
    "favourite_colour": "yellow",
    "hobby": []
  }
]
}'`

200 ok
*************************
Get persons


`curl -X GET \
  http://localhost:9090/api/person \
  -H 'authorization: bearer 92c3b5f5-0784-4168-a6e2-1b4dc130c88c' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: f4c51040-5201-381b-bf30-86bf338a48f2'`
  
  {"Person":[{"firstName":"isa","lastName":"lema","age":"29","favouriteColour":"red","hobby":["shopping","football"]},{"firstName":"Manu","lastName":"Bouzas","age":"30","favouriteColour":"yellow","hobby":[]},{"firstName":"isa","lastName":"lema","age":"29","favouriteColour":"red","hobby":["shopping","football"]},{"firstName":"Manu","lastName":"Bouzas","age":"30","favouriteColour":"yellow","hobby":[]}]}
*********************
Delete Person by Id=1
  
  `curl -X DELETE \
  http://localhost:9090/api/person/1 \
  -H 'authorization: bearer 92c3b5f5-0784-4168-a6e2-1b4dc130c88c' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: fbb8934d-c070-5fa7-ca2c-cda38476c2cf' \
  -d '{
  "Person": {
    "first_name": "isa",
    "last_name": "lema2",
    "age": "29",
    "favourite_colour": "red",
    "hobby": ["shopping", "basket"]
  }
}'`

200 OK


## Next Steps
* Improve HTTP Status Codes and messages. Example return 201 when a person is created.. 404 not found.
* Currently developing a Vue js app, consuming  EMBL rest API
   

