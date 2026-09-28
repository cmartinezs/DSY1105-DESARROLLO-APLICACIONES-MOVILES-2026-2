# Laboratorio Semana 8 · RegistroUsuario

## Propósito

Construir desde cero el flujo completo definido por Guía 11: formulario reactivo, validación desde ViewModel, StateFlow, navegación y pantalla resumen con ViewModel compartido.

## Resultado esperado

```text
Registro
→ validación
→ Resumen
```

## Paso 0 · Crear proyecto

Crear Empty Activity con Compose, Material 3 y Navigation Compose. Ejecutar antes de modificar.

## Paso 1 · Estructura

Organizar al menos:
- `model/`;
- `viewmodel/`;
- `ui/screen/`;
- `navigation/`.

## Paso 2 · Modelar estado

Crear `UsuarioUiState` con:
- nombre;
- correo;
- clave;
- dirección;
- acepta términos;
- `UsuarioErrores`.

## Paso 3 · ViewModel

Implementar:
- `MutableStateFlow<UsuarioUiState>`;
- `StateFlow<UsuarioUiState>` público;
- funciones de cambio por campo;
- limpieza de errores corregidos;
- `validarFormulario(): Boolean`.

## Paso 4 · RegistroScreen

Usar:
- `OutlinedTextField`;
- `PasswordVisualTransformation`;
- `Checkbox`;
- `Button`;
- `isError`;
- `supportingText`;
- `collectAsState`.

## Paso 5 · Validación

Definir reglas justificables para:
- nombre;
- correo;
- clave;
- dirección;
- aceptación de términos.

No inventar complejidad innecesaria.

## Paso 6 · Navegación

Crear rutas:
- `registro`;
- `resumen`.

Navegar a Resumen sólo cuando `validarFormulario()` retorne `true`.

## Paso 7 · Shared ViewModel

RegistroScreen y ResumenScreen deben observar el mismo ViewModel.

## Paso 8 · ResumenScreen

Mostrar:
- nombre;
- correo;
- dirección;
- estado de aceptación.

No mostrar la clave en texto abierto.

## Paso 9 · Casos manuales

| Caso | Resultado |
|---|---|
| formulario vacío | muestra errores |
| corregir campo | limpia/actualiza su error |
| correo inválido | bloquea avance |
| datos válidos | navega a Resumen |
| volver | conserva el estado del flujo |
| Resumen | muestra los mismos datos observados |

## Paso 10 · GitHub y DevLog

Registrar:
- rama de trabajo;
- commits progresivos;
- captura del formulario;
- captura del resumen;
- explicación de `MutableStateFlow`;
- explicación de por qué ambas pantallas comparten ViewModel.

## Criterio de término

Puedes explicar sin mirar el código:

```text
evento de UI
→ ViewModel
→ MutableStateFlow
→ collectAsState
→ validación
→ navegación
→ misma información en Resumen
```
