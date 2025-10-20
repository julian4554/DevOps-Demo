# WebCore Solutions — Spring Boot Demo

Minimalistische Demo-Webapp für deine DevOps-Fallstudie: Build → Test → Docker → (Push).

## Stack
- Java 17, Spring Boot 3.3
- Maven
- Thymeleaf (kein Frontend-Framework)
- H2 In-Memory DB
- Docker (Multi-Stage)
- GitHub Actions (CI/CD)

## Lokal starten
```bash
mvn clean package
java -jar target/*.jar
# http://localhost:8080
```

## Docker
```bash
docker build -t webcore/app:latest .
docker run -p 8080:8080 webcore/app:latest
```

## CI/CD (GitHub Actions)
- Workflow-Datei: `.github/workflows/main.yml`
- Secrets im Repo setzen:
  - `DOCKERHUB_USERNAME`
  - `DOCKERHUB_TOKEN` (Docker Hub Access Token)
```

## DORA-Indikatoren (für die Fallstudie)
- Deployment Frequency: Anzahl erfolgreicher Workflow-Runs
- Lead Time for Changes: durchschnittliche Workflow-Dauer
- Change Failure Rate: fehlgeschlagene Runs / Gesamt
- MTTR: Zeit bis korrigierter Run nach Fehlschlag
```

## Endpunkte
- `/`       → Landing + Anfrageformular + letzte Einträge
- `/health` → einfacher Health-Check
- `/h2`     → H2-Konsole
```