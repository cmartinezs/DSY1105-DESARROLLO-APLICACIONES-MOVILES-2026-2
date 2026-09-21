# Laboratorio Semana 7 · RutaLocal

## Propósito

Construir desde cero una aplicación Android útil para consultar lugares frecuentes de una ciudad o campus, practicando **jerarquía visual, adaptabilidad y navegación estructurada**.

RutaLocal no persiste datos ni usa formularios. Todo el contenido es local y fijo porque esta semana el foco es visual + navegación.

## Resultado esperado

```text
Inicio
  ↓
Lugares
  ↓
Detalle de lugar
```

El usuario puede explorar una lista de lugares, abrir su detalle y volver.

---

## Paso 0 · Crear el proyecto

En Android Studio:

1. crear un proyecto nuevo con **Empty Activity**;
2. nombre: `RutaLocal`;
3. package sugerido: `cl.duoc.rutalocal`;
4. Kotlin;
5. Jetpack Compose habilitado;
6. ejecutar el template antes de modificarlo.

**Checkpoint:** la app inicial abre en emulador o dispositivo.

---

## Paso 1 · Agregar Navigation Compose

En `app/build.gradle.kts` agrega:

```kotlin
implementation("androidx.navigation:navigation-compose:2.10.1")
```

Sincroniza Gradle.

**Checkpoint:** el proyecto vuelve a compilar.

---

## Paso 2 · Crear el modelo local

Crea `Lugar.kt`:

```kotlin
data class Lugar(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val descripcion: String,
    val referencia: String
)
```

Agrega una lista hardcoded con al menos cuatro lugares.

No uses repositorio, Room ni ViewModel: todavía no hacen falta para este laboratorio.

---

## Paso 3 · Crear una pantalla Inicio

Debe contener:

- nombre de la app;
- descripción;
- una pequeña explicación de utilidad;
- botón `Explorar lugares`.

Primero construye una pantalla visualmente clara sin navegación.

**Checkpoint:** Inicio se ve correctamente.

---

## Paso 4 · Crear pantalla de lista

Usa `LazyColumn` y una `Card` por lugar.

Cada tarjeta muestra:

- nombre;
- categoría;
- referencia breve.

La tarjeta expone:

```kotlin
onSeleccionar: (Int) -> Unit
```

La pantalla no conoce `NavController`.

**Checkpoint:** la lista puede renderizar todos los lugares.

---

## Paso 5 · Crear pantalla de detalle

Recibe:

```kotlin
lugar: Lugar?
onVolver: () -> Unit
```

Muestra nombre, categoría, descripción y referencia.

Si el ID no existe, muestra un mensaje comprensible.

**Checkpoint:** puedes renderizar manualmente el detalle antes de conectar navegación.

---

## Paso 6 · Crear navegación

Define:

```text
inicio
lugares
detalle/{id}
```

Crea `RutaLocalApp` con:

- `rememberNavController()`;
- `NavHost`;
- tres `composable`.

Conecta:

```text
Inicio
  --Explorar lugares-->
Lugares
  --seleccionar id-->
Detalle
  --volver-->
Lugares
```

**Checkpoint:** todo el recorrido funciona.

---

## Paso 7 · Mejorar jerarquía visual

Revisa cada pantalla:

- `headlineMedium` para títulos principales;
- `titleMedium` para títulos secundarios;
- `bodyMedium/bodyLarge` para información;
- espacios consistentes;
- acciones visibles;
- agrupación semántica mediante `Card`.

No “diseñes” sólo agregando colores al azar.

---

## Paso 8 · Adaptabilidad

Envuelve el contenido principal en una estructura similar a:

```kotlin
Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.TopCenter
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 720.dp)
            .padding(16.dp)
    ) {
        // contenido
    }
}
```

Prueba en:

1. teléfono vertical;
2. teléfono horizontal o ventana más ancha.

**Checkpoint:** contenido legible, sin recortes ni anchos absurdos.

---

## Paso 9 · Separar infraestructura de navegación

Comprueba que:

- `RutaLocalApp` conoce `NavController`;
- las pantallas reciben callbacks;
- las pantallas no construyen rutas;
- el modelo no conoce Android Navigation.

```text
navigation → decide destino
screen     → dibuja y emite intención
model      → representa datos
```

---

## Paso 10 · Casos manuales

| Caso | Resultado esperado |
|---|---|
| abrir app | muestra Inicio |
| pulsar Explorar | abre Lugares |
| seleccionar lugar 2 | abre el detalle correcto |
| volver | regresa a Lugares |
| seleccionar lugar distinto | muestra el nuevo detalle |
| ancho mayor | contenido mantiene ancho legible |
| ID inexistente | detalle muestra mensaje controlado |

---

## Paso 11 · DevLog

Registra:

- qué jerarquía visual decidiste;
- qué medida rígida evitaste;
- qué rutas definiste;
- cómo separaste navegación y pantalla;
- captura vertical;
- captura horizontal/ancha;
- commit final.

## Criterio de término

El laboratorio está terminado cuando puedes explicar este flujo sin mirar el código:

```text
evento usuario
→ callback de pantalla
→ NavController
→ nueva ruta en back stack
→ NavHost selecciona destino
→ Compose dibuja nueva pantalla
```

→ [Código de referencia](./app/src/main/java/cl/duoc/rutalocal/)
