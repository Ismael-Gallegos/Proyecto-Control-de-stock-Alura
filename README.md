# Control de Stock - Aplicación Java con JDBC

Este es un programa de control de stock desarrollado en Java utilizando JDBC para interactuar con una base de datos MySQL. La aplicación permite gestionar productos y categorías, realizando operaciones como agregar, modificar, eliminar y listar productos, así como generar un reporte de productos por categoría.

## Características

- Interfaz de usuario gráfica (GUI) para gestionar productos y categorías.
- Uso de la biblioteca `javax.swing` para la interfaz de usuario.
- Uso de la biblioteca `c3p0` para implementar un pool de conexiones a la base de datos.
- Uso de JDBC para realizar operaciones CRUD (crear, leer, actualizar, eliminar) en la base de datos.
- Modelo de datos con clases Java que representan las entidades `Producto` y `Categoría`.
- Manejo de transacciones para asegurar la consistencia de la base de datos.
- Generación de informes de productos por categoría.

## Tabla de Contenidos

- [Requisitos](#requisitos)
- [Configuración de la Base de Datos](#configuración-de-la-base-de-datos)
- [Instrucciones de Uso](#instrucciones-de-uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Notas Adicionales](#notas-adicionales)

## Requisitos

- Java 8 o superior.
- MySQL Server instalado y configurado.
- Bibliotecas `c3p0` y conector JDBC de MySQL.

## Configuración

1. Clona este repositorio en tu máquina local.
2. Configura la base de datos:
   - Ejecuta el script `database.sql` en tu base de datos MySQL para crear las tablas necesarias.
   - Modifica las credenciales de conexión en `com.alura.jdbc.factory.ConnectionFactory` con los valores correspondientes a tu base de datos.
3. Importa el proyecto en tu entorno de desarrollo (por ejemplo, Eclipse o IntelliJ).
4. Compila y ejecuta el programa desde la clase `com.alura.jdbc.pruebas.PruebaConexion` para verificar la conexión a la base de datos.

## Configuración de la Base de Datos

1. Ejecuta el script `create_database.sql` en tu servidor MySQL para crear la base de datos y las tablas necesarias. El script se encuentra en la carpeta `database`.

2. Abre el archivo `src/main/java/com/alura/jdbc/factory/ConnectionFactory.java` y ajusta los valores de `jdbcUrl`, `user` y `password` de acuerdo a tu configuración de MySQL.

## Instrucciones de Uso

1. Compila y ejecuta la clase `PruebaConexion` en el paquete `com.alura.jdbc.pruebas` para verificar la conexión a la base de datos.

2. Compila y ejecuta la clase `ControlDeStockFrame` en el paquete `com.alura.jdbc.view` para abrir la interfaz gráfica de la aplicación.

3. Desde la interfaz, puedes realizar operaciones CRUD en productos y categorías. También puedes generar informes de productos por categoría.

## Uso

- Ejecuta la clase `com.alura.jdbc.view.ControlDeStockFrame` para abrir la interfaz gráfica de gestión de productos y categorías.
- Utiliza los botones y formularios de la interfaz para agregar, modificar, eliminar y listar productos.
- El botón "Ver Reporte" genera un informe de productos por categoría.

## Estructura del Proyecto

control-de-stock-app/ ├── base de datos/ │ └── create_database.sql ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ ├── com.alura.jd antes de Cristo controlador/ │ │ │ ├── com.alura.jdbc.dao/ │ │ │ ├── com.alura.jdbc.factory/ │ │ │ ├── com.alura.jdbc.modelo/ │ │ │ ├ ── com.alura.jdbc.pruebas/ │ │ │ └── com.alura.jdbc.view/ │ │ └── recursos/ │ │ └── ... │ └── ... ├── ... └── LÉAME.md

## Contribuciones

Si deseas contribuir a este proyecto, no dudes en hacer un fork y enviar tus pull requests. ¡Todas las contribuciones son bienvenidas!

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.


## Notas Adicionales

- Esta aplicación fue desarrollada como parte de un curso de Java y JDBC de Alura.
- Asegúrate de configurar adecuadamente los parámetros de conexión a la base de datos para que la aplicación funcione correctamente.
- Si encuentras algún problema o tienes preguntas, no dudes en ponerte en contacto con el desarrollador.
