# Demo Shop API

## Démarrage

Lancez l'application Spring Boot (`DemoApplication`). L'API sera disponible sur `http://localhost:8080`.

## Endpoints disponibles

### 1. Récupérer le panier d'un utilisateur

- **GET** `/shop/cart/{uuidUser}`

**Exemple :**

```
GET http://localhost:8080/shop/cart/a4ae3f6f-f25e-4492-b259-b54507ce1f51
```

**Réponse :**

```json
[
    {
        "id": "04d37b37-7b08-45cf-8224-dec9f58029eb",
        "products": [
            {
                "id": "61082a4a-ec0a-4365-ab37-960bc6c267ba",
                "name": "PS5",
                "price": 499.99,
                "available": true
            }
        ],
        "user": {
            "uuid": "a4ae3f6f-f25e-4492-b259-b54507ce1f51",
            "name": "Kaci HAMMACHI"
        }
    }
]
```

### 2. Ajouter un produit au panier d'un utilisateur

- **GET** `/shop/cart/{uuidUser}/{uuidProduct}`

**Exemple :**

```
GET http://localhost:8080/shop/cart/a4ae3f6f-f25e-4492-b259-b54507ce1f51/61082a4a-ec0a-4365-ab37-960bc6c267ba
```

**Réponse :**

- 200 OK si le produit a été ajouté.
- 404 si l'utilisateur ou le produit n'existe pas.

## Données de test

- **Utilisateur :**
    - uuid : `a4ae3f6f-f25e-4492-b259-b54507ce1f51`
    - name : `Kaci HAMMACHI`
- **Produits :**
    - PS5 : `61082a4a-ec0a-4365-ab37-960bc6c267ba`
    - XBOX : `fd30b73b-0af0-4b89-9d65-0a6eff61331a`
    - SWITCH 2 : `5c462607-d286-44a5-97e6-86afb1f545b1` (non disponible)

## Remarques

- Les endpoints sont accessibles sans authentification.
- Les UUIDs sont à adapter selon vos données.
