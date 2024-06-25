## Sistema de Control y Seguridad en la FISI (SegurityFISI)

### Descripción del Proyecto
El proyecto "Sistema de Control y Seguridad en la FISI" (Segurity FISI) tiene como objetivo desarrollar un software de automatización de control y seguridad para la Facultad de Ingeniería de Sistemas e Informática de la UNMSM utilizando herramientas de estructura de datos. Este sistema está diseñado para asistir al personal de seguridad en la gestión de accesos, monitoreo, generación de reportes de incidencias, y otras tareas relacionadas con la seguridad y control de las instalaciones.

### Componentes del Sistema:

1. **Módulo de Registro y Salidas**
   - Funcionalidad: Ingresar y registrar las entradas y salidas de estudiantes, docentes y personal administrativo.

2. **Módulo de Personas en La Facultad**
   - Funcionalidad: Enlistar y mostrar las personas que se encuentran dentro de la facultad en tiempo real.

3. **Módulo de Gestión de Accesos**
   - Funcionalidad: Manejar el acceso a diferentes instalaciones de la facultad, incluyendo laboratorios, salas de docentes y otras áreas restringidas.

4. **Módulo de Configuración de Acceso por Roles**
   - Funcionalidad: Configurar, personalizar y controlar el acceso de los roles a ciertas instalaciones, definiendo permisos específicos para cada tipo de usuario.

5. **Módulo de Gestión de Reportes e Incidencias**
   - Funcionalidad: Acceder rápidamente a la información de contacto en caso de emergencias y generar reportes detallados de todas las incidencias registradas.

6. **Módulo de Gestión de Biblioteca**
   - Funcionalidad: Monitorear los recursos disponibles en la biblioteca y gestionar el préstamo de estos, incluyendo libros, revistas y otros materiales.



### Instalación
1. Clonar el repositorio:
   ```sh
   git clone https://github.com/usuario/proyecto-segurity-fisi.git
   ```
2. Navegar al directorio del proyecto:
   ```sh
   cd proyecto-segurity-fisi
   ```
3. Compilar el proyecto:
   ```sh
   javac -d bin src/*.java
   ```
4. Ejecutar la aplicación:
   ```sh
   java -cp bin Main
   ```
