# CI/CD-Pipeline für die fiktive Firma WebCore Solutions GmbH

Dieses Repository enthält die implementierte **Continuous Integration / Continuous Delivery (CI/CD)**-Pipeline der fiktiven Firma **WebCore Solutions GmbH**.  
Die Pipeline wurde mit **GitHub Actions**, **Maven** und **Docker** realisiert und stellt eine vollständig automatisierte Auslieferungsinfrastruktur für Spring-Boot-basierte Webanwendungen dar.

---

##  Übersicht

Die Pipeline deckt den gesamten Lebenszyklus einer Webanwendung ab – vom Commit bis zur produktiven Bereitstellung.  
Sie besteht aus drei aufeinanderfolgenden Jobs:

1. **Build, Test & Dockerize**  
   - Automatisiert das Kompilieren, Testen und Containerisieren der Anwendung.
   - Führt automatisierte Unit- und Integrationstests aus.
   - Checkt den Code-Stil mit Checkstyle.
   - Erstellt ein Docker-Image und pusht es (bei erfolgreichem Build auf `main`) zum Docker Hub.

2. **Staging Deployment**  
   - Stellt das erzeugte Docker-Image in einer Staging-Umgebung bereit.
   - Dient der fachlichen und funktionalen Validierung.

3. **Production Deployment**  
   - Erfolgt nur nach erfolgreicher Staging-Phase und manueller Freigabe.
   - Rollt das Image produktiv aus und markiert die Pipeline als abgeschlossen.

---

##  Technologien & Tools

| Kategorie | Tool / Technologie | Beschreibung |
|------------|-------------------|---------------|
| Versionsverwaltung | **GitHub** | Code Repository und Actions-Runner |
| Build-System | **Maven** | Automatisierter Build & Test-Prozess |
| Containerisierung | **Docker** | Einheitliche, reproduzierbare Laufzeitumgebung |
| Pipeline | **GitHub Actions** | CI/CD-Workflow mit sequentiellen Jobs |
| Tests | **JUnit**, **Checkstyle** | Qualitätssicherung & Stilprüfung |
| Metriken | **DORA-Metrics Logging** | Automatische Berechnung von Lead Time, MTTR, etc. |

---

##  Architektur

```mermaid
flowchart TD
    A[Push / PR auf main] --> B[Build, Test & Dockerize]
    B --> C[Deploy Staging]
    C --> D[Deploy Production - nach Freigabe]
    D --> E[DORA-Metriken: Logging & Abschluss]

