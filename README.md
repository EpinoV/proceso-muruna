# Proyecto postulación Muruna

### Proyecto SpringBoot para postulación a cargo de Developer en Muruna

#### Este proyecto cuenta con un archivo en la raiz (postulacion_muruna.postman_collection.json), el cual debe importarse en Postman como collection y podrán probarse todos los endpoints

### IMPORTANTE
#### Para ejecutar cualquiera de los servicios, previamente se debe ejecutar el servicio de autenticacion (Authenticate), este proveerá un token AWT para acceder a los demas servicios

# Enpoints disponibles
## Authenticate (POST)
### http://localhost:8086/proceso-muruna/api/v1/auth/authenticate
## Register (POST)
### http://localhost:8086/proceso-muruna/api/v1/auth/register
## All Users (GET)
### http://localhost:8086/proceso-muruna/api/v1/private/allUsers
## User By Email (GET)
### http://localhost:8086/proceso-muruna/api/v1/private/userByEmail?email=<EMAIL>
## New User (POST)
### http://localhost:8086/proceso-muruna/api/v1/private/newUser


