# Seguimiento de proyectos BackUp

## Descripción

Este proyecto tiene como objetivo asegurar la preservación de datos críticos mediante un sistema de respaldo para proyectos de seguimiento. La aplicación permite al usuario descargar toda la información almacenada, con la opción de generar un archivo JSON o realizar una migración completa de la base de datos desde Firebase (NoSQL) a una base de datos MySQL (SQL).

## Funcionalidades

- Exportación de datos a un archivo JSON para respaldo rápido.
- Migración de datos de Firebase a MySQL, facilitando la conversión entre bases de datos NoSQL y SQL.
- Integración con CommandLineRunner para la ejecución de comandos de respaldo automatizados.


## Tecnologías utilizadas

- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java logo" width="20" height="20"/> Java 23
- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="Spring Boot logo" width="20" height="20"/> Spring Boot 3.2
- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="MySQL logo" width="20" height="20"/> MySQL 9
- <img src="https://www.vectorlogo.zone/logos/firebase/firebase-icon.svg" alt="Firebase logo" width="20" height="20"/> Firebase

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/mbr100/SeguimientoProyectos2.0.git
    ```
2. Configura las credenciales para Firebase en el archivo de configuración application.yml.
3. Configura la conexión a la base de datos MySQL y ajusta los parámetros según tus credenciales.
4. Descarga las credenciales de Firebase y guárdalas en la carpeta resources.
5. Ajusta el archivo de configuración en FirebaseInitalization con la ruta de las credenciales de Firebase.
6. Ejecuta la aplicación y se ejecuta en la terminal 

## Uso
Ejecuta la aplicación desde el entorno de desarrollo (IntelliJ, Eclipse, etc.) o desde la terminal:

 ```bash
./mvnw spring-boot:run
```

Selecciona el modo de respaldo preferido (JSON o MySQL).

## Contribuciones
Las contribuciones son bienvenidas. Para contribuir:

- Haz un fork del proyecto.
- Crea una rama para tu función (feature/nueva-funcion).
- Realiza un pull request con una descripción clara de tu contribución.

## Licencia
Este proyecto está licenciado bajo la Licencia Creative Commons Atribución-NoComercial 4.0 Internacional (CC BY-NC 4.0). Puedes usar, modificar y distribuir el código para fines no comerciales siempre que otorgues el crédito correspondiente a su autor, Mario Borrego. Para cualquier uso comercial de este software, por favor, contacta previamente con el autor.

Para más detalles, visita: CC BY-NC 4.0.