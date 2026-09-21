# 01 · Diseño visual profesional y adaptable

## Qué problema resolvemos

Una pantalla puede funcionar y aun así ser difícil de usar. El objetivo de esta semana es aprender a organizar visualmente la información para que el usuario entienda qué es importante, qué puede hacer y qué contenido pertenece junto.

## 1. Jerarquía visual

La jerarquía visual responde:

> ¿Qué debería mirar primero el usuario?

En Compose podemos expresarla con:

- tipografía de `MaterialTheme.typography`;
- peso visual;
- espaciado;
- agrupación;
- contraste;
- tamaño y posición.

Ejemplo:

```kotlin
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
) {
    Text(
        text = "RutaLocal",
        style = MaterialTheme.typography.headlineMedium
    )

    Text(
        text = "Lugares guardados",
        style = MaterialTheme.typography.titleMedium
    )

    Text(
        text = "Selecciona un lugar para ver su detalle.",
        style = MaterialTheme.typography.bodyMedium
    )
}
```

No uses tamaños arbitrarios para cada texto si el tema ya expresa roles semánticos.

## 2. Espaciado como relación

El espacio no es decoración. Ayuda a decir qué elementos pertenecen juntos.

```kotlin
Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Text("Biblioteca")
    Text("Av. Ejemplo 123")
}
```

Si dos bloques pertenecen a grupos diferentes, aumenta la separación entre grupos en vez de llenar la UI de separadores.

## 3. Contenedores

Usa el contenedor que representa mejor el problema:

- `Column`: flujo vertical;
- `Row`: contenido horizontal;
- `Box`: superposición o alineación dentro de un mismo espacio;
- `LazyColumn`: listas;
- `Scaffold`: estructura general de pantalla.

## 4. Evitar layouts rígidos

Mala idea:

```kotlin
Modifier.width(390.dp)
```

Mejor:

```kotlin
Modifier.fillMaxWidth()
```

Cuando necesites controlar el ancho en pantallas grandes puedes limitarlo:

```kotlin
Modifier
    .fillMaxWidth()
    .widthIn(max = 720.dp)
```

## 5. Repartir espacio disponible

```kotlin
Row(Modifier.fillMaxWidth()) {
    Text(
        text = "Biblioteca",
        modifier = Modifier.weight(1f)
    )

    Text("Abierto")
}
```

`weight` expresa proporción respecto del espacio disponible; evita calcular anchos manualmente.

## 6. Scaffold

```kotlin
Scaffold(
    topBar = {
        TopAppBar(title = { Text("RutaLocal") })
    }
) { innerPadding ->
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        // contenido
    }
}
```

El `innerPadding` importa: impide que el contenido quede bajo la barra.

## 7. Probar adaptabilidad

Como mínimo prueba:

1. teléfono vertical;
2. teléfono horizontal o dispositivo de mayor ancho.

Preguntas:

- ¿se corta texto?;
- ¿quedan botones fuera de pantalla?;
- ¿el contenido usa un ancho razonable?;
- ¿la jerarquía sigue siendo clara?;
- ¿algún tamaño fijo está causando el problema?

## Definition of Done

Puedes cerrar este contenido cuando seas capaz de transformar una pantalla plana en una pantalla donde el orden de lectura, la agrupación y las acciones se entienden sin explicación adicional.
