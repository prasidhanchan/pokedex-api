# PokeDex API

This is a RESTful API built using Spring Boot with a clean MVC architecture that displays all the Pokemon available along with their details.

# Features

- MVC architecture.
- Uses MongoDB Atlas for Database.

# Routes

### Get all Pokemon

| Parameter    | Description                                                                                                                                                                                   |
| ------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `size` (int) | (optional) by default the size is unlimited. Example: `GET /get-all-pokemon?size=1`                                                                                                           |
| `sort` (int) | (optional) by default there is not sort. Example: `GET /get-all-pokemon?size=1?sort=name`                                                                                                     |

Output:

```json

{
    "_id": "6612bba0ced75d1ea06af6d2",
    "name": "Pikachu",
    "image": "https://firebasestorage.googleapis.com/v0/b/pokedex-2002.appspot.com/o/Pokemon%2FPikachu%20.png?alt=media&token=9e2f5ac2-6818-4fad-9e3f-81258418aa5a",
    "color": "0xFFFAD04D",
    "description": "When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.",
    "type": "Electric",
    "category": "Mouse",
    "height": "1 '04",
    "weight": "13.2"
}
```

### Get Pokemon by name

| Parameter       | Description                                                                                                                                                                                   |
| --------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `name` (string) | Get Pokemon by it's name. Example: `GET /get-pokemon/Bulbasaur`                                                                                                                               |

Output:

```json

{
    "_id": "66115f5b647a215f0d1bc9c3",
    "name": "Bulbasaur",
    "image": "https://firebasestorage.googleapis.com/v0/b/pokedex-2002.appspot.com/o/Pokemon%2FBulbasaur.png?alt=media&token=daac3ff8-9f15-4d50-aae2-27c703ca1452",
    "color": "0xFF48BA78",
    "description": "For some time after its birth, it uses the nutrients that are packed into the seed on its back in order to grow.",
    "type": "Grass",
    "category": "Seed",
    "height": "2' 04\"",
    "weight": "15.2"
}
```

### Post a Pokemon

| Parameter       | Description                                                                                                                                                                                   |
| --------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `body`          | Post Pokemon by providing a body. Example: `POST /add-pokemon`                                                                                                                                |


Request Body:

```json

{
    "name": "Charizard",
    "image": "local image uri",
    "color": "0xFFF46565",
    "description": "If Charizard becomes truly angered, the flame at the tip of its tail burns in a light blue shade.",
    "type": "Fire",
    "category": "Flame",
    "height": "5' 07\"",
    "weight": "199.5"
}
```

Output:

```json

  Pokemon added successfully!
```


### Patch a Pokemon

| Parameter       | Description                                                                                                                                                                                   |
| --------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `_id` (string)  | Update a Pokemon by providing it's _id. Example: `PATCH /update-pokemon/6612bba0ced75d1ea06af6d2`                                                                                             |
| `body`          | Provide a body.                                                                                                                                                                               |


Request Body:

```json

{
    "name": "Charizard updated",
    "description": "If Charizard becomes truly angered, the flame at the tip of its tail burns in a light blue shade.",
    "type": "Fire",
    "category": "Flame",
    "height": "5' 07\"",
    "weight": "199.5"
}
```

Output:

```json

  Pokemon updated successfully!
```

### Delete a Pokemon

| Parameter       | Description                                                                                                                                                                                   |
| --------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `_id` (string)  | Delete a Pokemon by providing it's _id. Example: `DELETE /remove-pokemon/6612bba0ced75d1ea06af6d2`                                                                                            |


Output:

```json

  Pokemon removed successfully!
```