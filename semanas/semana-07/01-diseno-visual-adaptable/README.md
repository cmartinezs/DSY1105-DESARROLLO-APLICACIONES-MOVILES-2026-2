# Profundización · Window Size Classes y diseño adaptable

## Adaptable no significa responsive por escala

Una app adaptable conserva intención, legibilidad y prioridad cuando cambia el espacio. No consiste en multiplicar tamaños.

## Window Size Classes como decisión estructural

Guía 9 trabaja explícitamente clases de ventana para identificar tamaños Compact, Medium y Expanded. Úsalas cuando el layout necesite cambiar de estructura.

## Restricciones antes que coordenadas

Incluso dentro de una clase de ventana siguen siendo útiles `fillMaxWidth`, `weight`, `widthIn` y espaciado consistente.

## Estado único, presentaciones múltiples

```text
UiState
├── HomeCompact
├── HomeMedium
└── HomeExpanded
```

La adaptación no debe duplicar lógica de negocio.

## Previews

Crea previews con dimensiones diferentes para detectar:
- contenido cortado;
- botones fuera de pantalla;
- jerarquía perdida;
- columnas demasiado anchas;
- oportunidades para cambiar la estructura.

## Accesibilidad visual básica

- no comunicar significado sólo mediante color;
- mantener áreas táctiles razonables;
- evitar texto demasiado pequeño;
- usar componentes Material cuando corresponda.

## Cuándo NO crear otra variante

Si sólo necesitas limitar ancho o redistribuir espacio, no hace falta un Composable completamente distinto. Crea variantes cuando cambie la organización de la experiencia.

## Puente hacia navegación

Una UI adaptativa puede cambiar su estructura sin cambiar la semántica de sus destinos. La navegación y el estado visual son responsabilidades relacionadas, pero distintas.
