
# 🚀 CRUD Example: Spacecraft Management System

Este repositorio contiene un proyecto de ejemplo para gestionar **naves espaciales** inspirado en series y películas. Se trata de un sistema desarrollado en **Java 21** con **Spring Boot**, que implementa un mantenimiento CRUD completo (Crear, Leer, Actualizar y Eliminar) para naves espaciales.

---

## 📂 Contenido del repositorio

- **`Crud Example/`**: Carpeta que contiene el código fuente del proyecto.
  - Se implementaron funcionalidades como:
    - **Paginación y Búsqueda**.
    - **Validación centralizada** y **gestión de excepciones**.
    - **Caché para mejorar el rendimiento**.
    - Almacenamiento en una base de datos **H2 en memoria**.
    - **Logging avanzado** con Aspect-Oriented Programming (AOP).
    - **Tests unitarios** e integración con Maven.

- **`crud-app.tar`**: Imagen Dockerizada del proyecto para su descarga y despliegue.

---

## 🚀 Cómo ejecutar el proyecto

### **1. Descargar el código fuente**
Puedes clonar este repositorio y acceder a la carpeta `Crud Example` para ver y ejecutar el código fuente.

```bash
git clone https://github.com/tu-usuario/spacecraft-crud.git
cd spacecraft-crud/Crud Example
```

### **2. Desplegar el proyecto con Docker**
Si no deseas ejecutar el código fuente directamente, puedes utilizar el archivo Docker tar disponible en este link:
https://drive.google.com/file/d/1e3rakb29ctsBThnBFQtOtB576Usye1vk/view?usp=drive_link

#### **Pasos:**
1. Descarga el archivo `crud-app.tar`.
2. Importa la imagen Docker en tu sistema:

   ```bash
   docker load -i crud-app.tar
   ```

3. Inicia el contenedor:

   ```bash
   docker run -p 8080:8080 crud-app
   ```

4. Accede a la aplicación desde tu navegador en: [http://localhost:8080](http://localhost:8080).

---

## 🛠️ Tecnologías utilizadas

- **Java 21**: Última versión LTS del lenguaje de programación.
- **Spring Boot**: Framework para aplicaciones empresariales.
- **Maven**: Herramienta de gestión de dependencias.
- **Docker**: Contenerización de la aplicación.
- **H2 Database**: Base de datos en memoria para simplificar el despliegue.

---

## 📖 Funcionalidades principales

1. CRUD para naves espaciales:
   - Crear, listar, buscar, actualizar y eliminar registros.
2. **Búsqueda por parámetros**: Encuentra naves espaciales por nombre o modelo.
3. **Paginación y ordenación**: Gestión eficiente de grandes volúmenes de datos.
4. **Validaciones y manejo de excepciones**: Respuestas claras y precisas ante errores.
5. **Tests unitarios**: Aseguramos la calidad y estabilidad del código.

---

## 👩‍💻 Cómo colaboramos

Este proyecto fue desarrollado en colaboración con **Teresa Aguilera Corpas** y está inspirado en su interés por trabajar en soluciones completas y robustas, combinando funcionalidades modernas con buenas prácticas de desarrollo.

---

## 🌟 Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar el proyecto o implementar nuevas funcionalidades, no dudes en enviar un pull request.
