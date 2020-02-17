# EMBL : Create REST API which stores, update, retrieves and deletes Person 
[![status](https://gitlab.cern.ch/mbouzas/embl/activity)](https://gitlab.cern.ch/mbouzas/embl/activity)


## Technology stack

* Backend:
    * Spring Boot (Maven, REST)
    * Spring Security OAuth 
    * h2 (in memory database)

* Moreover:
    * Postman Collection, testing OAuth 2.0 Authorization  and GET, POST, PUT, DELETE methods



## Downloading latest stable server tarball 

The C2MON server tarball can be downloaded from [CERN Nexus Repository](https://nexus.web.cern.ch/nexus/#nexus-search;gav~cern.c2mon.server~c2mon-server)

Please check also the [CHANGELOG.md] to find out the latest stable release version.

## Building from Source
C2MON uses a [Maven][]-based build system. In the instructions
below, `./mvnw` is invoked from the root of the source tree and serves as
a cross-platform, self-contained bootstrap mechanism for the build.

### Prerequisites

[Git][] and [JDK 8 update 152 or later][JDK8 build]

Be sure that your `JAVA_HOME` environment variable points to the `jdk1.8.0` folder
extracted from the JDK download.

#### IDEs

To reduce the boiler plate code we make use of [Lombok](https://projectlombok.org/), which requires to be [setup in your IDE](https://projectlombok.org/setup/overview) in order to compile the project.

### Check out sources
`git clone git@github.com:c2mon/c2mon.git`

### Compile and test; build all jars, distribution tarball, and docs
`./mvnw package -pl \!docs -DskipDocker=true`

## Contributing
[Pull requests][] are welcome; see the [contributor guidelines][] for details.
