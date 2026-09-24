# Trabajo Práctico N° 2: Programación Orientada a Objetos en Java
**Unidad 2: Organización, reutilización y recursos avanzados en POO**  
**Cátedra:** Paradigmas de Programación  
**Institución:** Universidad Tecnológica Nacional – Facultad Regional Mendoza (UTN - FRM)  
**Alumno:** Santiago García Day  
**Legajo:** 53372  

---

## 📌 Descripción General

El presente proyecto consiste en la evolución y escalabilidad del **Sistema de Gestión de Eventos Universitarios** desarrollado en el TP1. En esta entrega se incorporan técnicas avanzadas de diseño y programación orientada a objetos en Java:

- **Modularización y Encapsulamiento:** Organización del modelo en paquetes lógicos (`modelo`, `actividades`, `certificacion`, `excepciones`, `hilos`).
- **Manejo de Excepciones:** Control de tolerancia a fallos ante cupos excedidos y gestión granular de excepciones de entrada/salida.
- **Persistencia de Objetos:** Serialización y deserialización de instancias de eventos en disco binario.
- **Interfaces:** Desacoplamiento de responsabilidades mediante la interfaz `Certificable` para la emisión condicional de certificados.
- **Generics y Wildcards:** Métodos parametrizados acotados (`<T extends Actividad>`) y comodines (`List<? extends Actividad>`) para tipado seguro y flexible.
- **Clases Anidadas:** Modelado de `TicketDeAcceso` como clase miembro anidada dentro de `Inscripcion`.
- **Concurrencia y Multithreading:** Ejecución asíncrona mediante `EnvioTicketsThread` para enviar tickets sin bloquear el flujo principal de ejecución.

---

## 🏗️ Estructura del Proyecto

El código fuente está modularizado en los siguientes paquetes bajo `src/`:

```text
src/
└── modelo/
    ├── EventoUniversitario.java       # Entidad central del evento, cálculo de costos y persistencia
    ├── Sala.java                      # Sala asignada al evento
    ├── Estudiante.java                # Datos del estudiante (legajo, nombre)
    ├── Inscripcion.java               # Registro de inscripción con estado y clase anidada TicketDeAcceso
    ├── actividades/
    │   ├── Actividad.java             # Clase abstracta base de actividades
    │   ├── Charla.java                # Subclase no certificable (disertante)
    │   ├── Taller.java                # Subclase certificable (requiereNotebook)
    │   └── Curso.java                 # Subclase certificable (horas)
    ├── certificacion/
    │   └── Certificable.java          # Interfaz para emisión de certificados de asistencia
    ├── excepciones/
    │   └── CupoExcedidoException.java # Excepción chequeada personalizada
    └── hilos/
        └── EnvioTicketsThread.java    # Hilo concurrente para simular el despacho de accesos
App.java                               # Clase ejecutable principal con los escenarios de prueba
