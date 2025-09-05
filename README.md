# Fantasy Premier League Fixtures – Spring Boot

This is a Spring Boot application that fetches football fixture data from the [Fantasy Premier League API](https://fantasy.premierleague.com/api/fixtures), filters only **August fixtures**, and saves them into an **in-memory H2 database**.

The project demonstrates:
- REST API consumption with `RestTemplate`
- JSON → Java mapping using Jackson
- Filtering & saving data with Spring Data JPA
- In-memory database persistence using H2
- Lombok for boilerplate reduction

---

## ⚙️ Tech Stack
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Postgres
- Jackson (for JSON parsing)
- Lombok

---
