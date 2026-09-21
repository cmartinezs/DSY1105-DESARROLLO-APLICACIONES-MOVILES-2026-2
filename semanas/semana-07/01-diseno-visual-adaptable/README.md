# Profundización · Diseño adaptable en Compose

Esta ampliación es opcional. Úsala cuando el estudiante ya domina el contenido base y necesita entender **por qué** un layout funciona bien en distintos dispositivos.

## 1. Adaptable no significa “hacer todo más grande”

Un layout adaptable conserva intención y legibilidad cuando cambia el espacio disponible. No consiste en multiplicar medidas por el tamaño de pantalla.

## 2. Restricciones antes que coordenadas

Compose funciona mejor cuando declaramos restricciones:

```text
ocupa el ancho disponible
pero no más de 720 dp
mantén 16 dp de margen
distribuye el resto proporcionalmente
```

que cuando intentamos ubicar cada elemento mediante coordenadas.

## 3. BoxWithConstraints

Para decisiones simples dependientes del espacio:

```kotlin
BoxWithConstraints(Modifier.fillMaxSize()) {
    if (maxWidth < 600.dp) {
        ContenidoCompacto()
    } else {
        ContenidoAmplio()
    }
}
```

No conviertas cada diferencia visual en un `if`. Úsalo cuando la estructura realmente necesite cambiar.

## 4. Ancho legible

En una tablet, una columna de texto ocupando todo el ancho puede ser peor que una columna centrada y limitada.

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

## 5. Estado y adaptación

Cambiar el layout no debería duplicar el estado de negocio.

```text
mismo UiState
   ├── presentación compacta
   └── presentación amplia
```

Ésta es una de las razones para no esconder lógica de negocio dentro de Composables visuales.

## 6. Accesibilidad visual básica

Sin convertir esta semana en un módulo completo de accesibilidad:

- no expreses significado sólo mediante color;
- usa componentes Material cuando sea posible;
- evita textos demasiado pequeños;
- conserva áreas táctiles razonables;
- escribe labels comprensibles.

## 7. Qué viene después

Material 3 Adaptive permite construir patrones más sofisticados para ventanas y dispositivos diversos. No es requisito de Semana 7: primero domina restricciones, jerarquía y composición antes de sumar otra capa de abstracción.
