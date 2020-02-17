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
`http://localhost:9090/h2` Console where you can manage all related with the DB. 

### FINALLY READY!!!
Open a Postman Client and play with the REST API (attached Postman collection with headers and credentials to get token.. please remember refresh the token )


