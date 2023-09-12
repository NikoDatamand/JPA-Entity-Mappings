### Where and why you have used a @OneToMany annotation 
I've used it in the entities "Member" and "Car", regarding their relation to the "Reservation" entity. One member or car can have one to many reservations. This annotation ensures that the JPA specification can handle the relations in the queries being sent to the database.

### Where an why you have used a @ManyToOne annotation
This has been used in the "Reservation" entity to decribe its relation to the two other entities. 

### The purpose of the CascadeType, FetchType and mappedBy attributes you can use with one-to-many
A way of sorting and preparing the data in our database. Fx. the Oprhan Removal attribute ensures that if an entity is reliant on one or more obsolete entities, it gets removed.

### How/where you have (if done) added user defined queries to you repositories
I have only added one of these, in the ReservationRepo, that checks if a reservation exists based on the carId and rentalDate. 

### A few words, explaining what you had to do on your Azure App Service in order to make your Spring Boot App connect to your Azure MySqlDatabase
I haven't made this functional, as the whole SSH key setup seems very difficult to me, albeit having read all of the guides that has been given.

### A few words about where you have used inheritance in your project, and how it's reflected in your database
I've used inheritance in multiple cases, such as the entities extending either the "AdminDetails" or "UserWithRole" superclass. In the case of the member entity, it isn't created in a table corresponding to its name, but rather a table named after its superclass "UsersWithRole"

### What are the pros & cons of using the Single Table Strategy for inheritance?
As I understand it, the single table strategy is simple and efficient to implement. However, it can lead to storage inefficiency when many properties are unique to specific subclasses and may result in slower queries for specific subclass data. There may be more things to it?
(Had to ask Chat-GPT)

### How are passwords stored in the database with the changes suggested in part-6 of the exercise
Even though i've mostly copied the ready-made solution into my Spring Boot project, I've understood it as the Spring Security dependency stores the passwords in a OAuth2 Resource Server that is securely stored using encryption and tokens. Key values like the TOKEN_SECRET, token-expiration, and token-issuer are used for token generation and validation, ensuring password security. Something like that, at least.

