# springboot-kotlin-microservice
 Use the Here Maps Parking and Charging Station API’s to find Offstreet, OnStreet parking spots and Charging Station near the user provided location. 

# Technologies used:
   
   SpringBoot : 2.3.1
   java       : 1.8
   Kotlin     : 1.3.70
   Microservice
   webflux,web
   
   I have used Mono<Any> here as a return type since we are not used any Database to store the data or service class to return particular object , so  i didnt use Model/pojo     class as a return type.
 
 # Services
 
   # 1.Charging Service Api
      
   # 2.Parking facility Api 
         
   # 3.Eat Drink Api 
   
   # 4.Gateway
   
   # 5.Eureka Server
 
 # Url's to Services
 
  eurka server will be running on http://localhost:8761/
 
  Charging Station Api is running on http://localhost:8791
 
  Eat Drink Api is running on http://localhost:8751
 
  Parking facility is running on http://localhost8781
 
  gataway is mapped to three services under http://localhost:8080
  
 ---------------------------------------
 Sample Examples
 ---------------------------------------
 
  under examples folder i have attached screenshot of servical examples for better understandinf
  
 ------------------------------------------------------------------- 
 # Microservice Call to discover nearby places /getdata/{location}
 -------------------------------------------------------------------
 
 this rest api will parallel call to HERE MAP rest API's to get nearby location Services under categories of
             
             1. Category = PETROL STATION  & in Microservice = Charging Station API Service
             2. Category = EAT DRINK  & in Microservice   Eat Drink Api Service
             3. Category = SHOPPING  & in Microservice  Parking Facility Api Service

 # Microservice parrallel calls with location as parameter to return 3 nearest POI's

       localhost:8761/getdata/52.5166,13.3778          // 52.5166,13.3778 -> location parameter need to be passed default size is 3
 
 # Microservice calls with location as parameter and size as parameter
  
       localhost:8761/getdata/52.5166,13.3778/1        // 52.5166,13.3778 -> location parameter and 1 is size
       
 -------------------------------------------------------------------------
 # Microservice Call to Vehicle Connected Service /getVCS/{location}
 -------------------------------------------------------------------------
 
 this rest api will parallel call to HERE MAP rest API's to get nearby location Services under categories of
             
             1. Category = On-Street Parking  & in Microservice =  Parking Facility Api Service
             2. Category = Off-Street Parking  & in Microservice =  Eat Drink Api Service
             3. Category = EV-Charging-Station  & in Microservice =  Charging Station API Service

 # Microservice parrallel calls with location as parameter to return 3 nearest POI's

       localhost:8761/getVCS/52.5166,13.3778          // 52.5166,13.3778 -> location parameter need to be passed default size is 3
      
 -------------------------------------------------------------------------
 # Microservice Call to Vehicle Connected Service /hello
 -------------------------------------------------------------------------

 Sends rest calls to three microservices to know whether services are up, which returns hello message from all services
 
       localhost:8761/hello 
 
 # Zuul Gateway Proxy
   
   All the MicroService call ports are Mapped to zuul gateway under 8080, so that 8080 port can access microservice mapped rest API's
     
       example url :http://localhost:8080/parking-facility/get?at=52.5164%2C13.3742&cat=shopping&size=3

  # Spring cache
   
   To avoid multiple calls to the provider(Here Maps) the response is ideally cached in memory,Response will be cached for parrallel calls and as well as standalone services.
   CacheEvict is Scheduled to clear caches frequently with timelimit of 5 minutes.
  
  ---------------------------------------
  Refer example folder for clear view
  ----------------------------------------
