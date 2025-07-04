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