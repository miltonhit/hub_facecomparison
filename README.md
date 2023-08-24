## hub-facecomparison

### app/
This api compares two images, returning the highest face similarity threshold.

## Stack
-> Java17 + Spring Boot 3.x<br />
-> AWS Lambda + API Gateway<br />
-> AWS Rekognition<br />
-> Serverless framework<br />

## To run locally
First you need has installed: java17 and maven in your computer. After that run those commands in the terminal:
1. cd app && mvn install
2. java -cp target/my-app-with-tomcat.jar com.br.hub.facecomparison.config.config.SpringApp
3. Access in your browser: http://localhost:8080/index.html

## To deploy (aws provider)
1. Install [serverless framework](https://www.serverless.com/)
2. run this command: serverless deploy

## Test without clone :)
Just access: [https://miltonhit.github.io/hub_facecomparison](https://miltonhit.github.io/hub_facecomparison)

## Next steps
1. Improve the frontend, separating it from the spring application.
2. Some Junit tests
3. Docker and docker-compose to: build and start in one simple command.

Can you help? Feel free to contribute :)
