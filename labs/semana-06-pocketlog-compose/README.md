# Laboratorio Semana 6 · PocketLog Android: migrar funcionalidad, no dibujar una demo

## Propósito
Tomar **PocketLog v0.4 de consola** y llevarlo a Android/Compose conservando los requerimientos ya construidos.

Referencia: `proyecto-formativo/checkpoints/semana-04/PocketLog.kt`  
Checkpoint Android: `proyecto-formativo/checkpoints/semana-06/android/`

## Parte 0 · Ejecutar la versión anterior
Probar registrar, listar, completar, filtrar y estadísticas. Anotar qué funciones deben sobrevivir al cambio de interfaz.

## Parte 1 · Crear y validar Android
Crear Empty Activity con Compose, ejecutar el template y confirmar emulador/dispositivo antes de continuar.

## Parte 2 · Migrar el modelo
Crear `domain/Registro.kt` como `data class` con id, título, categoría y completado.

## Parte 3 · Fuente de datos en memoria
Crear `RegistroRepository`: mantiene lista, genera IDs, agrega y completa. No agregar Room/SQLite.

## Parte 4 · Estado de pantalla
Crear `PocketLogUiState`: registros visibles, título, categoría, filtro, mensaje y contadores.

## Parte 5 · ViewModel
Implementar en orden `cambiarTitulo`, `cambiarCategoria`, `agregarRegistro`, `completarRegistro`, `cambiarFiltro`, `refrescar`. Compilar después de cada paso.

## Parte 6 · UI Compose
1. encabezado y contadores;
2. dos `OutlinedTextField`;
3. botón agregar;
4. tres `FilterChip`;
5. `LazyColumn`;
6. tarjeta por registro;
7. botón completar sólo para pendientes.

## Parte 7 · MainActivity
Sólo obtiene ViewModel, observa estado y llama `PocketLogScreen`.

## Parte 8 · Casos manuales
| Caso | Resultado |
|---|---|
| guardar vacío | mensaje de validación |
| agregar válido | aparece en lista |
| completar | cambia a COMPLETADO |
| pendientes | oculta completados |
| completados | sólo completados |
| todos | lista completa |
| contadores | coinciden |

## Parte 9 · DevLog
Registrar código preservado, responsabilidades, error principal, captura y commit.

## Criterio de término
```text
usuario → Composable → ViewModel → Repository → UiState → Compose redibuja
```
El estudiante debe poder explicar ese flujo; no basta con que la pantalla se vea bien.
