# Paradigmas de Programación - Trabajo Práctico N° 2
**POO en Java: Organización, reutilización y recursos avanzados**  
**UTN FRM - Ingeniería en Sistemas de Información**  
**Alumno:** Santiago García Day  
**Legajo:** 53372  

---

## 📌 De qué trata el TP

En este práctico ampliamos el sistema de eventos que arrancamos en el TP1, llevándolo a un nivel más modular, robusto y escalable. La idea principal fue estructurar mejor las responsabilidades en paquetes y aplicar conceptos avanzados de Java:

- **Manejo de excepciones:** Creamos y gestionamos excepciones chequeadas para evitar que se inscriban alumnos cuando ya no hay lugar.
- **Persistencia con serialización:** Guardamos y recuperamos los eventos directamente en disco usando streams de objetos de Java, manejando cualquier fallo de E/S de forma granular.
- **Interfaces:** Incorporamos la emisión de certificados mediante una interfaz que sólo implementan las actividades que corresponden (talleres y cursos, dejando afuera a las charlas).
- **Genéricos y Wildcards:** Filtramos actividades por clase asegurando listas tipadas en tiempo de compilación (`<T extends Actividad>`) y calculamos costos de materiales aceptando cualquier subtipo mediante comodines acotados (`List<? extends Actividad>`)[cite: 1].
- **Clases anidadas e hilos:** Modelamos el ticket de acceso como una clase anidada dentro de la inscripción y armamos un hilo independiente para procesar el envío de tickets en segundo plano sin congelar la consola principal[cite: 1].

---

## 🏗️ Organización de paquetes

El proyecto quedó organizado en paquetes para respetar el encapsulamiento y modularidad pedidos en el diagrama de clases[cite: 1]:

```text
src/
└── modelo/
    ├── EventoUniversitario.java       # Manejo del evento, salas, actividades y serialización
    ├── Sala.java                      # Sala vinculada al evento
    ├── Estudiante.java                # Datos del alumno (legajo y nombre)
    ├── Inscripcion.java               # Registro de inscripción con su TicketDeAcceso anidado
    ├── actividades/
    │   ├── Actividad.java             # Clase abstracta base
    │   ├── Charla.java                # Actividad común (no emite certificado)
    │   ├── Taller.java                # Actividad certificable con requerimiento de notebook
    │   └── Curso.java                 # Actividad certificable con carga horaria
    ├── certificacion/
    │   └── Certificable.java          # Interfaz para generar los certificados
    ├── excepciones/
    │   └── CupoExcedidoException.java # Excepción chequeada para cupos agotados
    └── hilos/
        └── EnvioTicketsThread.java    # Hilo para procesar y enviar tickets en paralelo
App.java                               # Clase principal con todas las pruebas y ejecuciones
