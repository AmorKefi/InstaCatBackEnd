# 📌 InstaCatBackEnd

Back-end Spring Boot pour **InstaCat** — API REST de gestion de chats pour le projet Cat Voting (InstaCat). Ce serveur fournit les endpoints pour récupérer les chats, voter, et afficher les scores.

---

## 🚀 Fonctionnalités

- Récupération de la liste des chats
- Vote pour un chat
- Mise à jour du score
- API RESTful consommable par un front Angular
- CORS configuré pour les clients externes

---

## 💡 Stack technique

| Technologie | Version |
|-------------|---------|
| Java | 17+ |
| Spring Boot | 3.x |
| Spring Web | REST API |
| Spring Data |
| Maven | Build & dépendances |

---

## 📁 Structure du projet

```
InstaCatBackEnd/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
├── .gitignore
├── pom.xml
└── README.md
```

---

## 🛠️ Installation et démarrage

### 1. Cloner le dépôt

```bash
git clone https://github.com/AmorKefi/InstaCatBackEnd.git
cd InstaCatBackEnd
```

### 2. Compiler

```bash
mvn clean install
```

### 3. Lancer l’API

```bash
mvn spring-boot:run
```

L’API sera disponible sur :

```
http://localhost:8080
```

---

## ⚙️ Configuration (application.yaml)

Exemple :

```properties
spring:
  application:
    name: instaCatBack
  datasource:
    url: jdbc:h2:mem:instacatdb;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false
    driver-class-name: org.h2.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
  h2:
    console:
      enabled: true
```

---

## 📍 Endpoints API

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | `/api/cats` | Liste tous les chats |
| PUT | `/api/cats/{id}/vote` | Vote et incrémente score |

### Réponse GET :

```json
[
  { "id": "1", "url": "https://…", "score": 10 },
  { "id": "2", "url": "https://…", "score": 5 }
]
```

---

## 📦 Intégration Angular

```ts
export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:8080/V1/api'
};
```

---

## 🧪 Tests

Exécution :

```bash
mvn test
```

---

## 🚀 Déploiement

Compatible avec :

- Heroku
- Render
- Railway
- AWS
- Azure
- Docker

---

## 📄 Licence

Open-source 

---

## 👤 Auteur

**Amor Kefi**  
Repo : https://github.com/AmorKefi/InstaCatBackEnd
