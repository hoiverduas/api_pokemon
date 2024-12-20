# Sistema de Información Pokémon

Este proyecto es una API REST desarrollada con **Spring Boot** y **Java** que permite consultar información sobre Pokémon utilizando la API pública [pokeapi.co](https://pokeapi.co/).
Además, incluye un módulo para gestionar entrenadores Pokémon, y la autenticación está protegida con JWT utilizando **Spring Security**. 

El sistema sigue el patrón de diseño **Modelo Vista Controlador** (MVC) y utiliza **PostgreSQL** para la persistencia de datos.

## Requerimientos Funcionales

### Módulo de Pokémon
1. **Consultar información de un Pokémon**:
   - Permite obtener la información de un Pokémon por su nombre o ID.
   - Se retorna la siguiente información:
     - Nombre.
     - Altura.
     - Peso.
     - Habilidades.
     - Especie.
     - Formas.
   
2. **Consultar habilidades**:
   - Permite obtener un listado de las primeras 50 habilidades que tienen los Pokémon, ordenadas alfabéticamente.

### Módulo de Entrenadores
1. **Base de datos de entrenadores**:
   - Cada entrenador tiene los siguientes datos:
     - ID único.
     - Nombre.
     - Ciudad de residencia.
     - Lista de Pokémon favoritos.
     - Puntaje.

2. **Operaciones disponibles**:
   - Crear un entrenador.
   - Actualizar la información de un entrenador.
   - Consultar información de un entrenador.
   - Eliminar un entrenador.

## Requerimientos Técnicos

1. **Patrón de diseño MVC**:
   - Se ha implementado el patrón Modelo Vista Controlador (MVC) para separar las responsabilidades entre el backend, la lógica de negocios y la presentación.
   
2. **Persistencia en PostgreSQL**:
   - Utiliza **Spring Data JPA** para interactuar con una base de datos **PostgreSQL**.

3. **Manejo de errores**:
   - Se manejan errores como 404 si un Pokémon o entrenador no es encontrado.

4. **Spring Boot + Java**:
   - El backend está desarrollado utilizando **Spring Boot** y **Java** para la creación de la API REST.

5. **Autenticación JWT con Spring Security**:
   - La API implementa autenticación mediante **JWT** utilizando **Spring Security** para proteger las rutas de los entrenadores.

6. **Interfaz Gráfica** (Bonus):
   - Se desarrolló una interfaz gráfica utilizando **React** que permite visualizar la información de los Pokémon y los entrenadores.

## Instrucciones de Ejecución

### Requisitos previos
- Tener **Java 17 o superior** instalado.
- Tener **Maven** instalado.
- Tener **PostgreSQL** instalado y configurado.

Autenticación
POST /api/auth: Autenticación y generación de JWT.
Parámetros: email, password
Respuesta: { "token": "jwt_token" }
Pokémon
GET /api/pokemon/{identifier}: Obtiene la información de un Pokémon por nombre o ID.

Parámetros: identifier (nombre o ID del Pokémon)
Respuesta:
json
Copiar código
{
  "name": "pikachu",
  "height": 0.4,
  "weight": 6.0,
  "abilities": ["static", "lightning-rod"],
  "species": "pikachu",
  "forms": ["pikachu"]
}
GET /api/pokemon/abilities: Obtiene un listado de las primeras 50 habilidades de los Pokémon, ordenadas alfabéticamente.

Respuesta:
json
Copiar código
[
  "ability1",
  "ability2",
  "ability3",
  ...
]
Entrenadores
POST /api/trainers: Crear un entrenador.

Parámetros: { "name": "Ash", "city": "Pallet Town", "favoritePokemons": [...], "score": 100 }
Respuesta: { "id": 1, "name": "Ash", "city": "Pallet Town", "favoritePokemons": [...], "score": 100 }
GET /api/trainers/{id}: Consultar la información de un entrenador.

Parámetros: id (ID del entrenador)
Respuesta:
json
Copiar código
{
  "id": 1,
  "name": "Ash",
  "city": "Pallet Town",
  "favoritePokemons": [...],
  "score": 100
}
PUT /api/trainers/{id}: Actualizar la información de un entrenador.

Parámetros: { "name": "Ash", "city": "Pallet Town", "favoritePokemons": [...], "score": 110 }
Respuesta:
json
Copiar código
{
  "id": 1,
  "name": "Ash",
  "city": "Pallet Town",
  "favoritePokemons": [...],
  "score": 110
}
DELETE /api/trainers/{id}: Eliminar un entrenador.

Parámetros: id (ID del entrenador)
Respuesta: HTTP 200 OK
Autenticación
La API usa JWT para proteger las rutas relacionadas con los entrenadores. Para realizar solicitudes a estas rutas,
debes incluir el token JWT en el encabezado Authorization de la siguiente manera:


Copiar código
Authorization: Bearer {jwt_token}
Contribuciones
Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:





### Rutas permitidas sin autenticación

Las siguientes rutas son accesibles sin necesidad de un token JWT:


- **`POST /api/auth`**: Permite la autenticación y creación de un nuevo token JWT.
- **`GET /api/pokemon/**`**: Permite consultar la información de los Pokémon sin autenticación.
- **`GET /api/trainers/allTrainers`**: Permite consultar la lista de todos los entrenadores sin autenticación.
- **`POST /api/trainers`**: Permite crear un nuevo entrenador sin necesidad de autenticación.

### Rutas que requieren autenticación

Las siguientes rutas requieren un token JWT válido con el rol de **`TRAINER`**:

- **`GET /api/trainers/{id}`**: Consultar la información de un entrenador específico.
- **`PUT /api/trainers/{id}`**: Actualizar la información de un entrenador específico.
- **`DELETE /api/trainers/{id}`**: Eliminar un entrenador específico.
- **`GET /api/trainers/{id}/pokemon`**: Consultar los Pokémon favoritos de un entrenador.



