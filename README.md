# soap-springboot

Este proyecto proporciona una API SOAP **code-first** implementada con Spring Boot, JPA, PostgreSQL, Lombok y Apache CXF. Está diseñada bajo el dominio `ec.edu.espe` y expone tres servicios principales:

* **ClienteService**: gestión de clientes.
* **CategoriaService**: gestión de categorías.
* **ProductoService**: gestión de productos (relacionados con categorías mediante `@ManyToOne` y `@OneToMany`).

Los contratos WSDL y los tipos JAXB se generan automáticamente a partir de las clases Java, sin necesidad de archivos XSD manuales.

---

## Dependencias para incluir desde [start.spring.io](https://start.spring.io)

Al generar el proyecto, selecciona las siguientes dependencias:

* **Spring Web** (`spring-boot-starter-web`)
* **Spring Data JPA** (`spring-boot-starter-data-jpa`)
* **PostgreSQL Driver** (`postgresql`)
* **Lombok** (`lombok`, scope *provided*)

> **Nota**: tras descargar el proyecto, agrega manualmente en el `pom.xml`:
>
> ```xml
> <!-- Apache CXF para SOAP code-first -->
> <dependency>
>   <groupId>org.apache.cxf</groupId>
>   <artifactId>cxf-spring-boot-starter-jaxws</artifactId>
>   <version>4.0.0</version>
> </dependency>
>
> <!-- JAX-WS API (anotaciones jakarta.jws) -->
> <dependency>
>   <groupId>jakarta.xml.ws</groupId>
>   <artifactId>jakarta.xml.ws-api</artifactId>
>   <version>3.0.0</version>
> </dependency>
>
> <!-- JAXB API para tipos generados -->
> <dependency>
>   <groupId>jakarta.xml.bind</groupId>
>   <artifactId>jakarta.xml.bind-api</artifactId>
> </dependency>
> ```

---

Con esto tendrás tu API SOAP lista para arranque inmediato y pruebas vía SoapUI u otro cliente SOAP.
