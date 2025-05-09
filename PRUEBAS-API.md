# Pruebas de la API SOAP

Este documento muestra cómo probar cada operación de los servicios SOAP expuestos en `ec.edu.espe` usando SoapUI u otro cliente SOAP.

---

## Requisitos previos

* La aplicación Spring Boot debe estar ejecutándose en `http://localhost:8080`.
* Instalar SoapUI Open Source ([https://www.soapui.org/downloads/soapui/](https://www.soapui.org/downloads/soapui/)).

---

## 1. ClienteService

* **WSDL**: `http://localhost:8080/services/ClienteService?wsdl`
* **Endpoint**: `http://localhost:8080/services/ClienteService`

### 1.1 Importar WSDL

1. Abrir SoapUI → **File → New SOAP Project**.
2. Nombre: `Pruebas-ClienteService`.
3. Pegar la URL del WSDL.
4. Marcar **Create Requests** → **OK**.

### 1.2 Operaciones y ejemplos

#### listClientes

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:listClientes/>
  </soapenv:Body>
</soapenv:Envelope>
```

* Seleccionar `listClientes` → `Request 1` → ▶️ → Verificar lista de `<Cliente>` en la respuesta.

#### getCliente

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:getCliente>
      <id>1</id>
    </soap:getCliente>
  </soapenv:Body>
</soapenv:Envelope>
```

* Reemplazar `<id>` con un valor existente → ▶️ → Debe devolver el `<Cliente>` con ese ID.

#### createCliente

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:createCliente>
      <cliente>
        <nombre>Juan Gómez</nombre>
        <email>juan.gomez@espe.edu.ec</email>
      </cliente>
    </soap:createCliente>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Debe retornar el `<Cliente>` creado con su `<id>` asignado.

#### deleteCliente

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:deleteCliente>
      <id>1</id>
    </soap:deleteCliente>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Debe retornar `true` si el cliente existía y fue borrado.

---

## 2. CategoriaService

* **WSDL**: `http://localhost:8080/services/CategoriaService?wsdl`
* **Endpoint**: `http://localhost:8080/services/CategoriaService`

### 2.1 Importar WSDL

Repetir los pasos de la sección 1.1 cambiando nombre a `Pruebas-CategoriaService`.

### 2.2 Operaciones y ejemplos

#### listCategorias

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:listCategorias/>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Debe devolver todas las `<Categoria>`.

#### getCategoria

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:getCategoria>
      <id>1</id>
    </soap:getCategoria>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → `<Categoria>` con el ID especificado.

#### createCategoria

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:createCategoria>
      <categoria>
        <nombre>Electrónica</nombre>
      </categoria>
    </soap:createCategoria>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Retorna la nueva `<Categoria>` con `<id>`.

#### deleteCategoria

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:deleteCategoria>
      <id>1</id>
    </soap:deleteCategoria>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Retorna `true` si la categoría se eliminó.

---

## 3. ProductoService

* **WSDL**: `http://localhost:8080/services/ProductoService?wsdl`
* **Endpoint**: `http://localhost:8080/services/ProductoService`

### 3.1 Importar WSDL

Repetir pasos de sección 1.1 con nombre `Pruebas-ProductoService`.

### 3.2 Operaciones y ejemplos

#### listProductos

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:listProductos/>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Lista de `<Producto>` con su `<Categoria>`.

#### getProducto

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:getProducto>
      <id>1</id>
    </soap:getProducto>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → `<Producto>` con el ID dado.

#### createProducto

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:createProducto>
      <producto>
        <nombre>Smartphone X</nombre>
        <precio>799.99</precio>
        <categoria>
          <id>1</id>
        </categoria>
      </producto>
    </soap:createProducto>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Retorna el `<Producto>` creado.

#### deleteProducto

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://soap.espe.edu.ec/">
  <soapenv:Header/>
  <soapenv:Body>
    <soap:deleteProducto>
      <id>1</id>
    </soap:deleteProducto>
  </soapenv:Body>
</soapenv:Envelope>
```

* ▶️ → Retorna `true` si el producto fue eliminado.

---

Con estos pasos y ejemplos podrás verificar el correcto funcionamiento de cada operación en SoapUI.
