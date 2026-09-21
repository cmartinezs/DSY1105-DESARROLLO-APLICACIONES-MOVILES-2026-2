# Ejercicio Semana 7 · Tres pantallas, una responsabilidad

**Propósito:** practicar exclusivamente diseño visual, adaptabilidad y navegación. No usa persistencia, formularios, red ni recursos nativos.

## Contexto

Construye una pequeña aplicación llamada **MiniCatálogo** con tres destinos:

```text
Inicio → Categorías → Detalle
```

## Requisitos

### Pantalla Inicio
- título con jerarquía visual;
- texto descriptivo;
- botón “Ver categorías”.

### Pantalla Categorías
- muestra tres tarjetas hardcoded;
- cada tarjeta tiene nombre y descripción breve;
- al seleccionar una categoría navega a `detalle/{id}`.

### Pantalla Detalle
- recibe el ID de la categoría;
- muestra nombre y descripción;
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

## Desafío

Haz que el contenido se mantenga centrado y legible cuando aumente el ancho de la ventana.

## Comprobación

1. Inicio abre correctamente.
2. Inicio → Categorías.
3. Categorías → Detalle.
4. Detalle muestra el elemento seleccionado.
5. Atrás vuelve a Categorías.
6. El contenido no se desborda en horizontal.
7. Puedes explicar dónde vive la navegación y dónde vive la UI.

→ [Código de referencia](../../examples/semana-07/navegacion-simple/)
