# PokeDex API

This API is built using Spring Boot with a clean MVC architecture that displays all the Pokemon available along with their details.

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

[
  {
      "content": [
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
    ],
      {...},
      ...
  }
]
```
