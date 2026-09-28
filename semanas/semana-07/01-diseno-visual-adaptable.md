# 01 · Diseño visual profesional y adaptable

## Qué problema resolvemos

Una pantalla puede funcionar y aun así ser difícil de usar o degradarse cuando cambia el espacio disponible. Semana 7 trabaja jerarquía visual y adaptación declarativa.

## 1. Jerarquía visual

Usa roles de `MaterialTheme.typography`, espaciado, agrupación, contraste y posición para indicar qué debe mirar primero el usuario.

## 2. Evitar layouts rígidos

Prefiere restricciones y espacio disponible antes que medidas arbitrarias:

```kotlin
Modifier
    .fillMaxWidth()
    .widthIn(max = 720.dp)
```

## 3. Window Size Classes

Guía 9 pide trabajar con las clases de tamaño de ventana de Material 3 para distinguir, de forma declarativa, contextos como:

```text
Compact
Medium
Expanded
```

La idea no es agrandar todo, sino cambiar la composición cuando el espacio lo justifique.

Ejemplo conceptual:

```kotlin
when (windowWidthSizeClass) {
    WindowWidthSizeClass.Compact -> HomeCompact()
    WindowWidthSizeClass.Medium -> HomeMedium()
    WindowWidthSizeClass.Expanded -> HomeExpanded()
}
```

## 4. Variantes de pantalla

Una variante debe existir porque cambia la estructura, no sólo porque cambió el ancho.

```text
mismo estado
├── Compact  → una columna
├── Medium   → más aire / distribución distinta
└── Expanded → dos zonas o paneles
```

El estado de negocio no se duplica.

## 5. Scaffold y estructura

`Scaffold` organiza elementos estructurales como barras superiores, contenido y navegación.

## 6. Preview por tamaño

Crea previews representativos para observar cómo responde la UI antes de ejecutar.

## 7. Probar en dispositivos distintos

Como mínimo compara una ventana compacta con una más amplia. Idealmente observa Compact, Medium y Expanded cuando el entorno lo permita.

## Definition of Done

Puedes explicar qué cambia entre tamaños, qué se mantiene, por qué existe cada variante y cómo el mismo estado alimenta todas las presentaciones.
