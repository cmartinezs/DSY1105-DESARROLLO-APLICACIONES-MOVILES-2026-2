# Ejercicio Semana 7 · AgendaEventos

**Propósito:** practicar exclusivamente diseño visual, adaptabilidad y navegación. No usa persistencia, formularios, red ni recursos nativos.

## Contexto

Construye una pequeña aplicación llamada **AgendaEventos** con tres destinos:

```text
Inicio → Eventos → Detalle
```

El dominio es deliberadamente distinto al ejemplo de referencia. La idea es transferir el patrón de navegación y diseño, no renombrar una solución existente.

## Requisitos

### Pantalla Inicio
- título con jerarquía visual;
- texto descriptivo;
- botón “Ver eventos”.

### Pantalla Eventos
- muestra al menos tres eventos hardcoded;
- cada tarjeta incluye título, fecha resumida y lugar;
- al seleccionar un evento navega a `detalle/{id}`.

Ejemplos de eventos posibles:

- Feria tecnológica;
- Taller de Android;
- Jornada deportiva.

### Pantalla Detalle
- recibe el ID del evento;
- muestra título, fecha, lugar y descripción;
- permite volver.

## Restricciones

Debes usar:

- `Scaffold`;
- `MaterialTheme.typography`;
- `Card`;
- `fillMaxWidth()`;
- `widthIn(max = 720.dp)`;
- `NavHost`;
- `composable`;
- `navigate`;
- `popBackStack`.

No debes usar:

- ViewModel nuevo;
- Room/SQLite;
- Retrofit;
- formularios;
- validaciones;
- cámara;
- objetos serializados en rutas.

## Adaptabilidad

Prueba como mínimo:

1. teléfono vertical;
2. teléfono horizontal o una ventana de mayor ancho.

El contenido debe mantenerse centrado, legible y sin depender de un ancho fijo específico.

## Comprobación

1. Inicio abre correctamente.
2. Inicio → Eventos.
3. Eventos → Detalle.
4. Detalle muestra el evento seleccionado mediante su ID.
5. Atrás vuelve a Eventos.
6. El contenido no se desborda en horizontal.
7. Las pantallas no reciben `NavController` directamente.
8. Puedes explicar dónde vive la navegación y dónde vive la UI.

## Referencias de estudio

Los ejemplos de Semana 7 muestran las piezas por separado y una integración equivalente con otro dominio:

→ [Ejemplos guiados de Semana 7](../../examples/semana-07/)

Úsalos para entender el patrón. **No existe un código de referencia de AgendaEventos para copiar.**
