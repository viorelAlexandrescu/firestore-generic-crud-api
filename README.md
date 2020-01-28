# firestore-generic-crud-api
Generid CRUD API for Firestore. Based on DAO, Service, Controller layers.
To be used in a Spring based project. Works with Spring Boot :)

# Steps to succusefully use this API.
### 1. Configuration
  
  Since I've used this only in Spring Boot, all I can recommend is to configure the Firebase API in your main class.  
  Take [this class](https://github.com/viorelAlexandrescu/ourparking/blob/master/src/main/java/ro/avs/ourparking/OurParkingApplication.java) as an example.
  
### 2. Model
   
   Create your model class and extend the `ro.avs.fgca.model.BaseEntity` class
   
### 3. DAO

   Create your DAO class and extend the `ro.avs.fgca.dao.BaseDAO` class. It will require you to pass the type parameter.
   Use your previously created model class as this DAO will be used for that entity.
   You must implement the following methods.
   * `ro.avs.fgca.dao.BaseDAO#getCollectionName` where you must specify the Firestore collection name as a literal string.  
   * `ro.avs.fgca.dao.BaseDAO#parseDocument` in which you need to implement a way to parse the results from the query to your Firestore instance and return a new
   instance of that result set's model class.
   
   Take [this class](https://github.com/viorelAlexandrescu/ourparking/blob/master/src/main/java/ro/avs/ourparking/dao/CarsDAO.java) as an example.
   Take note if you're using Spring, you should annotate it with `@Repository`.
   
### 4. Service

   Create your Service class and extend the `ro.avs.fgca.service.BaseService` class.  
   Take note if you're using Spring, you should annotate it with `@Service` and autowire your entity's 
   DAO class in this class's constructor.
   Take [this class](https://github.com/viorelAlexandrescu/ourparking/blob/master/src/main/java/ro/avs/ourparking/service/RolesService.java) as an example.
   
### 5. Controller

   Create your Controller class and extend the `ro.avs.fgca.controller.BaseController` class
   Take note if you're using Spring, you should annotate it with `@RestController`, @RequestMapping to specifiy the endpoint
   of this controller and autowire your entity's Service class in this class's constructor.  
   Take [this class](https://github.com/viorelAlexandrescu/ourparking/blob/master/src/main/java/ro/avs/ourparking/controller/CarsController.java) as an example.
   
