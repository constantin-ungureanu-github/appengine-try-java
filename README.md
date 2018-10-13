# Hello Google AppEngine for Java 8™

## Before you begin

1.  Initialize the Cloud SDK.

        gcloud init

1.  Install the Cloud SDK `app-engine-java` component.

        gcloud components install app-engine-java

## Deploying to App Engine

To run the application locally, run

    mvn clean package appengine:run

To deploy the application to Google AppEngine, run

    mvn clean package appengine:deploy
