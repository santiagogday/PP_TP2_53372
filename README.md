## 📌 DESCRICPCIÓN

En este práctico ampliamos el sistema de eventos que arrancamos en el TP1, utilizando genericos, serializacion y manejo de errores.

- **Manejo de excepciones:** Creamos y gestionamos excepciones para evitar que se inscriban alumnos cuando ya no hay lugar.
- **Persistencia con serialización:** Guardamos y recuperamos los eventos directamente en disco usando streams de objetos de Java, manejando cualquier fallo de E/S de forma granular.
- **Interfaces:** Incorporamos la emisión de certificados mediante una interfaz que sólo implementan las actividades que corresponden (talleres y cursos, dejando afuera a las charlas).
- **Genéricos y Wildcards:** Filtramos actividades por clase asegurando listas tipadas en tiempo de compilación (`<T extends Actividad>`) y calculamos costos de materiales aceptando cualquier subtipo mediante comodines acotados (`List<? extends Actividad>`)[cite: 1].
- **Clases anidadas e hilos:** Modelamos el ticket de acceso como una clase anidada dentro de la inscripción y armamos un hilo independiente para procesar el envío de tickets en segundo plano sin congelar la consola principal.


La salida en consola del ejercicio 4 es: 

