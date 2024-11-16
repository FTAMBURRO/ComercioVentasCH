# Proyecto de Comercio Electrónico

Este proyecto es una API REST desarrollada en **Spring Boot** para la gestión de ventas, clientes y productos en un entorno de comercio electrónico.

## Descripción

El objetivo de este proyecto es implementar un sistema de backend que permita manejar las operaciones básicas de un comercio. La aplicación soporta la gestión de clientes, productos, y la generación de comprobantes de venta, permitiendo la creación, modificación, eliminación y consulta de estos elementos.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación utilizado para el desarrollo de la aplicación.
- **Spring Boot 3.x**: Framework utilizado para la creación de la API REST.
- **MySQL**: Base de datos relacional utilizada para el almacenamiento de la información.
- **Maven**: Herramienta de gestión de dependencias y automatización del proyecto.
- **Postman**: Utilizado para pruebas de la API.
- **Eclipse IDE**: Entorno de desarrollo integrado utilizado para escribir y gestionar el código del proyecto.
- **Git**: Control de versiones utilizado para la gestión del proyecto en GitHub.

## Estructura del Proyecto

El proyecto sigue una arquitectura estándar de Spring Boot con la siguiente estructura:

- **src/main/java**: Código fuente de la aplicación.
  - **controller**: Controladores REST que manejan las solicitudes HTTP.
  - **model**: Entidades que representan las tablas de la base de datos.
  - **repository**: Interfaces que extienden `JpaRepository` para la interacción con la base de datos.
  - **service**: Lógica de negocio para gestionar las operaciones de la aplicación.
- **src/main/resources**: Recursos del proyecto.
  - **application.properties**: Archivo de configuración para la conexión a la base de datos y otras configuraciones de la aplicación.

