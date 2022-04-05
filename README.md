# PruebaMantenedorN1
Mantenedor de prueba =>

Paso 1: descargar repositorio git.
paso 2: en motor de base de datos postgresql crear tabla ejecutando script "script tabla tarea -db postgresql.txt" copntenido en el repositorio.
paso 3: modificar properties de conexión a BD, reemplazando las credenciales existentes , por las de su servidor =>
                                                                  ################ Configuracion BD POSTGRES Local ##################
                                                                  spring.datasource.url=jdbc:postgresql://localhost:5432/db_springboot_cloud
                                                                  spring.datasource.username=postgres
                                                                  spring.datasource.password=sasa
paso 4: actualizar dependencias Maven
paso 5: levantar proyecto con spring boot.

PD: 
- url de swagger => http://localhost:8082/swagger-ui/index.html  , debe reemplazar host y puerto que corresponda.
- tambien puede utilizar archivo "PruebaMantenedorN1Coopeuch.postman_collection.json" agregandolo a postman
 




