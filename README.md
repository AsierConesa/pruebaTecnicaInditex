# Prueba técnica Inditex
## Desarrollador: Asier Conesa Torres

La aplicación ha sido desarrollada con java 17 utilizando Springboot

### Desglose de la aplicación

#### Endpoint:
Se han desarrollado dos endpoints:
El solicitado GET para obtener los datos solicitados de la tabla Prices. 
Un endpoint EXTRA de tipo POST para crear un nuevo registro y publicarlo a un tópico de kafka

La colección de postman necesaria para testearlo está dentro de la carpeta collections dentro del proyecto.

#### Docker

Esta aplicación usa Kafka como funcionalidad extra a la solicitada a la tarea, para correr la aplicacion es importante utilizar docker-compose up -d para correr en docker el kafka, no es necesario crear los tópicos posteriormente ya que se hace automáticamente con los @Bean dentro del código

#### Base de datos

Se ha implementado una base de datos h2 que se lanza al iniciar la aplicación, esta cuenta con los registros dados en el enunciado del ejercicio.
Esta base de datos se carga en memoria, por lo tanto al cerrar la aplicación cualquier cambio que se haya efectuado se perderá, si se quiere mantener se debe cambiar a un fichero, en el application.propierties he puesto la opción comentada.

#### Flyway

Para el control de versiones de la base de datos he implementado flyway, de forma que la aplicación guarda un registro de todos los cambios de la base de datos en caso de querer volver a una versión más antigua de la misma.

#### Arquitectura Hexagonal

Se ha dividido la aplicación en tres grandes grupos siguiendo la convención de la arquitectura hexagonal separando la aplicación por capas de profundidad, donde diferenciamos
- dominio
- aplicación
- infraestructura

#### Solid

Todas las clases están segmantadas de forma ordenada por nivel de profundidad.
- DTO (Data transfer Object)
- Dominio
- MO (Model Object)

También se diferencian las distintas clases como
- Controladores
- Servicios
- Repositorios
- Mappers

Y otros como los puertos y adaptadores.
Además se ha optado por una estructura package-by-feature para una mayor cohesión y mantenibilidad del código.

#### Mapstructs

Se ha utilizado Mapstructs para el mappeo de las entidades entre las distintas capas. No es realmente necesario en esta aplicación pues es bastante pequeña y no varían demasiado las entidades, pero en caso de escalabilidad Mapstructs cuenta con variedad de herramientas para mappear entidades con facilidad.

#### TDD

Se han realizado los tests de integración solicitados y se han ejecutado correctamente

#### DDD

Las entidades de dominio permanecen inmutables, si bien podrían convertirse en records o usar la etiqueta @Value, Mapstructs requiere de getters y setters para realizar los mappeos correctamente, y estas entidades no permiten crearlos. Sin embargo, la entidad de dominio tiene una única funcionalidad y un objeto de dominio creado permanece inmutable a nivel práctico

#### Kafka

Aunque en la tarea no se solicitaba, como funcionalidad extra he añadido un publicador de kafka, para probar la funcionalidad se puede hacer mediante el endpoint de creacion otorgado en la colección postman
