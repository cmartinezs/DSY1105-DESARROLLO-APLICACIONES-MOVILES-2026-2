# PocketLog · Semana 08 · v0.8 · Formularios reactivos

## RECIBE

PocketLog v0.7 ya tiene:
- Inicio;
- Registros;
- Detalle;
- Navigation Compose;
- ViewModel;
- UiState;
- datos en memoria.

## OBJETIVO

Incorporar un flujo formal de creación/edición aplicando el patrón de Guía 11.

```text
Registros
→ Nuevo registro
→ validar
→ Resumen previo / confirmación
→ guardar en memoria
→ Detalle
```

## APRENDEMOS

- UiState de formulario;
- modelo de errores;
- `MutableStateFlow`;
- `collectAsState`;
- validación desde ViewModel;
- feedback con `isError` y `supportingText`;
- Shared ViewModel dentro del flujo de creación;
- navegación posterior a una acción válida.

## DECISIÓN

PocketLog mantiene su dominio y repositorio en memoria. Semana 8 no introduce Room ni DataStore.

## PASO A PASO

1. crear `RegistroFormUiState`;
2. crear modelo de errores;
3. exponer estado con `StateFlow`;
4. implementar eventos de cambios de campos;
5. implementar validación final;
6. construir `NuevoRegistroScreen`;
7. construir pantalla de resumen/confirmación;
8. compartir el ViewModel durante ese flujo;
9. confirmar y guardar en el repositorio en memoria;
10. navegar al detalle del nuevo registro;
11. comprobar que lista y filtros anteriores siguen funcionando.

## COMPRUEBA

- errores específicos;
- corrección de errores;
- navegación sólo con estado válido;
- resumen observa los mismos datos;
- no se expone información sensible innecesaria;
- ViewModel no conoce `NavController`;
- no se introdujo persistencia antes de tiempo.

## DEJA ABIERTO

La persistencia local resolverá posteriormente la duración de los datos más allá de la memoria de la aplicación.
