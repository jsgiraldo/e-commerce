# 🛒 Emazon - Tienda Virtual

**Emazon** es una plataforma de tienda virtual diseñada para facilitar la compra y administración de artículos en línea. Este proyecto sigue una arquitectura hexagonal para asegurar que el sistema sea modular, mantenible y escalable. 

## 🚀 Descripción del Proyecto

El propósito principal de "Emazon" es conectar a los clientes con una amplia variedad de artículos, permitiendo a los usuarios realizar compras de manera sencilla y eficiente. Además, proporciona a los administradores y auxiliares de bodega herramientas para gestionar el inventario, suministros y obtener informes detallados para la toma de decisiones.

## 📂 Estructura del Proyecto

El proyecto está organizado en varios microservicios, cada uno siguiendo las mejores prácticas de arquitectura hexagonal:

- **Frontend:** Interfaz de usuario basada en diseño mobile-first y principios de atomic design.
- **Backend:** Microservicios separados para cada función, cada uno con su propia base de datos y documentación OpenAPI.
- **Pruebas:** Pruebas unitarias que aseguran que cada regla de negocio se comporta correctamente.

## 📦 Microservicios Principales

1. **Stock Service** (`emazon-stock-service`) 🛠️
   - Gestión de categorías y artículos.
   - Implementa la lógica de negocios para la administración del inventario.

2. **Cart Service** (`emazon-cart-service`) 🛒
   - Gestión del carrito de compras de los usuarios.
   - Procesa la compra de artículos y limpia el carrito tras la compra.

3. **Order Service** (`emazon-order-service`) 📦
   - Gestión de órdenes de compra.
   - Disminuye la cantidad de existencias de los artículos comprados.

4. **Report Service** (`emazon-report-service`) 📊
   - Generación de informes para el administrador.
   - Permite identificar los artículos más vendidos y favoritos de los clientes.

## 🛠️ Tecnologías Utilizadas

- **Java** con **Spring Boot** para el backend.
- **MySQL** para la persistencia de datos.
- **Angular** para el frontend.
- **Gradle** para la gestión de dependencias y construcción.
- **MapStruct** para el mapeo de entidades y DTOs.
- **SonarLint** para asegurar la calidad del código.
- **GitFlow** como estrategia de ramas para control de versiones.

## 🌐 Arquitectura Hexagonal

Cada microservicio sigue una arquitectura hexagonal que consiste en:

- **Dominios:** Encapsulan la lógica de negocio y están completamente desacoplados de las tecnologías subyacentes.
- **Adaptadores:** Implementan la lógica específica para la interacción con bases de datos, API externas, o cualquier otro sistema externo.
- **Puertos:** Interfaces que conectan el dominio con los adaptadores, asegurando que el dominio no dependa de la infraestructura.

## 📋 Requisitos

- **Java 17** o superior.
- **Gradle 7** o superior.
- **Docker** (opcional, para la contenedorización de los microservicios).
- **MySQL** o cualquier base de datos compatible con JPA.

## 🛠️ Configuración del Entorno

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/tu-usuario/emazon.git
   cd emazon

## 👥 Contribuciones
¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar el proyecto, 
si encuentras algún error, o si quieres añadir nuevas funcionalidades, no dudes en abrir
un pull request o reportar un issue.

