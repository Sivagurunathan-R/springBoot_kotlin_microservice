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
 
   # 1.Charging Service 
      
     -call to EV-Charging Station Using Api key (Access error due to RBAC )
      so
     -call to Petrol Stations Using Api key
     
   # 2.Parking facility Service 
      
     -call to On-Street Parking Using Api key (Access error due to RBAC )
      so
     -call to Petrol Stations Using Api key 
     
   # 3.Eat Drink Service 
      
     call to Eat-drink api Using Api key   as below 
 
 # Url's to Services
 
  eurka server will be running on http://localhost:8761/
 
  Charging Station Api is running on http://localhost:8791
 
  Eat Drink Api is running on http://localhost:8751
 
  Parking facility is running on http://localhost8781
 
  gataway is mapped to three services under http://localhost:8080

 
 # Microservice parrallel calls with location as parameter to return 3 nearest POI's

       localhost:8761/getdata/52.5166,13.3778          // 52.5166,13.3778 -> location parameter need to be passed default size is 3
 
 # Microservice calls with location as parameter and size as parameter
  
       localhost:8761/getdata/52.5166,13.3778/1        // 52.5166,13.3778 -> location parameter and 1 is size
      
      
 Each Microservices calling HereMap Rest Api's to Get Datas, all the calls are executed under port 8080
 
     example url :http://localhost:8080/parking-facility/get?at=52.5164%2C13.3742&cat=shopping&size=3

  # Spring cache
   
   To avoid multiple calls to the provider(Here Maps) the response is ideally cached in memory,Response will be cached for parrallel calls and as well as standalone services.
   
   
  
  
