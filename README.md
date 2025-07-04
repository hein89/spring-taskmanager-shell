# Spring TaskManager (Spring Shell)

### Beschreibung / Description

Ein leichtgewichtiges Aufgabenverwaltungs-Tool auf Basis von Spring Boot und Spring Shell.  
A lightweight task manager built using Spring Boot and Spring Shell.

---

A lightweight task manager built using Spring Boot and Spring Shell.  
Ein leichtgewichtiges Aufgabenverwaltungs-Tool auf Basis von Spring Boot und Spring Shell.

### Funktionen / Features

- Aufgaben hinzufügen, anzeigen, bearbeiten und löschen
- Umschaltbar zwischen In-Memory- und Datei-basiertem TaskService
- Persistente Speicherung in `tasks.json` (bei FileTaskService)
- Auswahl des aktiven TaskService zur Laufzeit über die Shell

---

- Add, list, update, and delete tasks
- Switch between in-memory and file-based TaskService
- Persistent storage in `tasks.json` (when using FileTaskService)
- Change the active TaskService at runtime via the shell

### Beispielbefehle / Example Commands

```shell
add "Einkaufen gehen"                   # Neue Aufgabe hinzufügen
list                                    # Alle Aufgaben anzeigen
update <id> "Neue Beschreibung"         # Aufgabe aktualisieren
delete <id>                             # Aufgabe löschen
switch-service file|memory              # TaskService wechseln
get-active-service                      # Aktuellen TaskService anzeigen

---------------------------------------------------------------------------

add "Go grocery shopping"               # Add a new task
list                                    # Show all tasks
update <id> "New description"           # Update an existing task
delete <id>                             # Delete a task
switch-service file|memory              # Switch TaskService
get-active-service                      # Show currently active TaskService
```

### Verwendete Spring-Technologien / Used Spring Technologies

- **Spring Core Container**  
  Verwaltung des Bean-Lebenszyklus, Container für Spring-Managed Beans  
- **Design und Modularisierung von Anwendungen**  
  Klare Trennung der Komponenten durch Schnittstellen und Implementierungen  
- **Classpath-Scanning und automatische Bean-Registrierung**  
  Spring erkennt automatisch Komponenten und verwaltet sie  
- **Inversion of Control (IoC) und Dependency Injection (DI)**  
  Entkopplung der Komponenten durch automatische Abhängigkeitsverwaltung  
- **Spring Shell**  
  Interaktive Kommandozeilen-Anwendung für einfache Bedienung  
- **Konfigurationsklassen und Fabrikmethoden**  
  Dynamische Bean-Erzeugung und flexible Konfiguration der Services zur Laufzeit

---

- **Spring Core Container**  
  Manages the lifecycle of beans, container for Spring-managed beans
- **Application design and modularization**  
  Clear separation of components via interfaces and implementations
- **Classpath scanning and automatic bean registration**  
  Spring automatically detects and manages components
- **Inversion of Control (IoC) and Dependency Injection (DI)**  
  Decoupling components by automatic dependency management
- **Spring Shell**  
  Interactive command-line interface for easy usage
- **Configuration classes and factory methods**  
  Dynamic bean creation and flexible runtime configuration of services