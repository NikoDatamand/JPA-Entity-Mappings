# JPA-Entity-Mappings Week-2

Summary:

My program won't build, as there's something with SpringBoot beans that gives a lot of error messages. I have tried asking the chat and looking at all the study material, but I simply can't figure it out.

Also, the README file for the first week seems to haven't been pushed, and I can't find it anywhere. So everything seems to go against me in this Cars-R-Us project.

- What are the benefits of using a RESTful API

There are many benefits using the REST principles for an API. One of the primariry features being the statelessness of the data exhange, where the server doesn't need to store any request from the client. It's the paradigm of which client-server web requests are primarily built these days, as its effecient and secure. 


- What is JSON, and why does JSON fit so well with REST?

JSON is a data format that parses objects into something universally readable by clients and servers alike. JSON also includes the possibility to nest objects and arrays inside other objects, which creates many possibilities. 


- How you have designed simple CRUD endpoints using spring boot and DTOs to separate api from data  -> Focus on your use of DTO's

By creating request and respones DTO's for the relevant classes, one can secure a relevant variant of a class in its relevant use (POST, GET, etc.). When posting a new object body, the fitting DTO class will ensure that this web request is transformed into a Java class for backend uses. 


-  What is the advantage of using using DTOs to separate api from data structure when designing rest endpoints

When we interact with an API, we aren't always interested in every information about the object that we are requesting (example: date of creation). Also, as developers we aren't always interested in sharing every information about an object, as it could be sensitive. So that's why a DTO can include the important information from a class, when it's used in data transfer.


- Explain shortly the concept mocking in relation to software testing

As we can't test the database itself, we must create a stub implementation of it somehow. Here we can use Hibernate and the H2 in-memory database, for testing purposes.


- How did you mock database access in your tests, using an in-memory database and/or mockito → Refer to your code




- Explain the concept Build Server and the role Github Actions play here

GitHub runs it own build server, that runs our .jar file before deploying to the production environment. This is how we ensure that the build isn't full of errors that could stir things up. GitHub actions is a way of using CI/CD pipeline, where the code is automaticcly deployed to a build server in the event of a push to the repository or something else specified in a relevant YAML file.

- Explain maven, relevant parts in maven, and how maven is used in our CI setup. Explain where maven is used by your GitHub Actions Script(s)

Maven is one of the most important factors in the DevOps way of doing things, as it manages our code in different ways. Maven is responsible for building the .jar file by setting up relevant dependencies and other crucial funcitionality. 


-  Understand and chose cloud service models (IaaS, PaaS, SaaS, DBaaS)for your projects -> Just explain what you have used for this handin

By deploying the programme with Azure Web Services, we're using a Paas service. We are responsible for the code and the database, whereas Azure hosts the programme in the cloud. One could also "outsource" the database layer to Azure, adding the DBaaS to our model. 
