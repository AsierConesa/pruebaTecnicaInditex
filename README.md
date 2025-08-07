# Prueba técnica Inditex
## Desarrollador: Asier Conesa Torres

La aplicación ha sido desarrollada con java 17 utilizando Springboot

##IMPORTANTE

Esta aplicación usa Kafka como funcionalidad extra a la solicitada a la tarea, para correr la aplicacion es importante utilizar docker-compose up -d para correr en docker el kafka, no es necesario crear los tópicos posteriormente ya que se hace automáticamente con los @Bean dentro del código

### Desglose de la aplicación

#### Endpoint:
Se han desarrollado dos endpoints:
El solicitado GET para obtener los datos solicitados de la tabla Prices. 
Un endpoint EXTRA de tipo POST para crear un nuevo registro y publicarlo a un tópico de kafka

La colección de postman necesaria para testearlo está dentro de la carpeta collections dentro del proyecto.

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

#### SOLID

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

La estructura de la aplicación separa todas las entidades y clases por funcionalidad, permitiendo una gran escalabilidad.

#### Mapstructs

Se ha utilizado Mapstructs para el mappeo de las entidades entre las distintas capas. No es realmente necesario en esta aplicación pues es bastante pequeña y no varían demasiado las entidades, pero en caso de escalabilidad Mapstructs cuenta con variedad de herramientas para mappear entidades con facilidad.

#### TDD

Se han realizado los tests de integración solicitados y se han ejecutado correctamente

#### DDD

Las entidades de dominio permanecen inmutables, si bien podrían convertirse en records o usar la etiqueta @Value, Mapstructs requiere de getters y setters para realizar los mappeos correctamente, y estas entidades no permiten crearlos. Sin embargo, la entidad de dominio tiene una única funcionalidad y un objeto de dominio creado permanece inmutable a nivel práctico

#### Kafka

Aunque en la tarea no se solicitaba, como funcionalidad extra he añadido un publicador de kafka, para probar la funcionalidad se puede hacer mediante el endpoint de creacion otorgado en la colección postman, importante recordar que hay que lanzar el kafka en 

#### Git

En cuanto al control de versiones, he trabajado en la rama main, con commits frecuentes y mensajes claros, reflejando el avance por funcionalidades.

Además, he utilizado Flyway para mantener un control de versiones explícito de los cambios en la base de datos, asegurando trazabilidad y reversibilidad en cada migración.

He preparado la estructura de ramas para entornos separados, como producción y preproducción, aunque para esta prueba técnica solo se ha trabajado directamente sobre main. Me parece importante dejar esa base lista de cara a un ciclo de vida real del proyecto en caso de compartir el desarrollo con algún compañero habría seguido el estándar gitflow con ramas feature, fix y hotfix.

#### Documentación

Toda la aplicación está comentada con javadoc para poder generar una documentación detallada de toda la aplicación

#### Buenas practicas con Linter y Sonar

He seguido las indicaciones de Linter para asegurarme que todo el código sigue buenas prácticas, también he añadido herramientas para generar reportes con JaCoCo y poder analizar la cobertura y los smells con Sonar

#### Eficiencia

Se ha revisado el código intentando evitar expresiones como .findFirst() y utlizando en su lugar consultas nativas con LIMIT 1
