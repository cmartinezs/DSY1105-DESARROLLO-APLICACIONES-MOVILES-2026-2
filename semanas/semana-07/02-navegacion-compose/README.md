# Profundización · Rutas, eventos y límites de navegación

## La navegación es estado

El back stack representa la historia de destinos activos.

## Rutas como contrato

Centralizar rutas reduce strings mágicos. Guía 10 recomienda una `sealed class` como una opción segura y reutilizable.

## Eventos de navegación

Puede existir un contrato de eventos para representar intenciones como abrir perfil, ir a ajustes o volver.

La UI emite la intención; la infraestructura decide cómo traducirla a `NavController`.

## ViewModel y navegación

Evita acoplar el ViewModel directamente al `NavController`. El ViewModel puede producir estado o eventos; la capa de navegación resuelve la ruta.

## TopAppBar, Drawer y NavigationBar

No es necesario usar las tres piezas en todas las pantallas. Elige según jerarquía y destinos:
- TopAppBar para contexto/acciones de pantalla;
- NavigationBar para destinos principales frecuentes;
- NavigationDrawer cuando existe un conjunto más amplio de destinos.

## Adaptabilidad

La estructura de navegación también puede cambiar con el espacio disponible. La semántica del destino debería mantenerse aunque cambie la forma visual.

## Errores comunes

- pasar `NavController` a todos los Composables;
- rutas duplicadas;
- usar navegación para estados internos simples;
- menús que no representan destinos reales;
- mezclar formularios de Semana 8 antes de tiempo.

## Navigation 2

La asignatura trabaja Navigation Compose clásico porque hace visibles rutas, `NavHost`, `NavController` y back stack sin sumar más abstracciones de las necesarias.
