# Integración Semana 6 · PocketLog v0.6 en Android/Compose

Este material ya no cumple el rol de “primer lab desde cero”. Para eso usa:

→ [ChecklistDiaria](../semana-06-checklist-diaria/README.md)

Aquí aplicamos lo aprendido sobre el **proyecto transversal PocketLog**.

## Propósito

Tomar PocketLog v0.4 de consola y migrarlo a Android/Compose **conservando su comportamiento**.

Referencia de consola: `proyecto-formativo/checkpoints/semana-04/PocketLog.kt`  
Checkpoint Android: `proyecto-formativo/checkpoints/semana-06/android/`

## Parte 0 · Inventario funcional

Ejecuta v0.4 y prueba:
- registrar;
- listar;
- completar;
- filtrar;
- estadísticas;
- validaciones.

Escribe una lista de lo que debe sobrevivir.

## Parte 1 · Base Android

Crea/abre proyecto Compose y ejecuta el template.

## Parte 2 · Dominio

Traslada `Registro` sin introducir conceptos visuales.

## Parte 3 · Repository en memoria

Encapsula lista, IDs, agregar y completar.

No es persistencia.

## Parte 4 · UiState

Incluye registros visibles, campos, filtro, mensaje y contadores.

## Parte 5 · ViewModel

Implementa incrementalmente:
1. cambiar título;
2. cambiar categoría;
3. agregar;
4. completar;
5. cambiar filtro;
6. refrescar.

Compila tras cada capacidad.

## Parte 6 · UI

Construye por capas:
1. encabezado;
2. contadores;
3. campos;
4. botón agregar;
5. filtros;
6. LazyColumn;
7. Card;
8. completar.

## Parte 7 · Activity

Sólo conecta ViewModel, estado y Screen.

## Parte 8 · Equivalencia

| Capacidad v0.4 | Evidencia v0.6 |
|---|---|
| registrar | formulario + agregar |
| listar | LazyColumn |
| completar | acción por tarjeta |
| filtrar | FilterChip |
| contar | resumen |
| validar | mensaje UI |

## Parte 9 · DevLog

Registra:
- qué se preservó;
- qué cambió por pasar a Android;
- una responsabilidad del ViewModel;
- por qué aún no existe persistencia;
- captura y commit.

## Criterio de término

```text
usuario → Composable → ViewModel → Repository → UiState → Compose
```

Debes poder explicar el flujo y demostrar que el producto no perdió sus capacidades principales.
