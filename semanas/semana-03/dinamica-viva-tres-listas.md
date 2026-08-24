# Dinámica viva · Tres listas son una pista

**Duración:** 15 minutos.  
**Momento:** después de colecciones, antes de explicar clases.

Mostrar este diseño:

```kotlin
val titulos = mutableListOf("Leer", "Comprar")
val categorias = mutableListOf("Estudio", "Personal")
val completados = mutableListOf(false, true)
```

Preguntar sin mencionar POO: ¿qué representa el elemento 0?, ¿qué pasa si eliminamos solo una categoría?, ¿cómo pasaríamos un registro completo a una función?, ¿qué estructura querríamos que mantuviera unidos esos tres datos?

Los estudiantes proponen soluciones. Recién entonces se presenta:

```kotlin
class Registro(val titulo: String, val categoria: String, var completado: Boolean)
```

## Idea de cierre

La clase no aparece porque «ahora toca POO». Aparece porque el modelo actual tiene una tensión concreta que necesita una abstracción mejor.