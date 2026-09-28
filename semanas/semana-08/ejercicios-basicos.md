# Ejercicio Semana 8 · PerfilContacto

## Propósito

Aplicar el patrón de Guía 11 en un dominio pequeño sin copiar su formulario de usuario literalmente.

## Flujo

```text
PerfilForm
→ validar
→ ResumenPerfil
```

Ambas pantallas comparten un `PerfilViewModel`.

## Campos

- nombre;
- correo;
- teléfono opcional;
- acepta contacto.

## Estado

Crea:
- `PerfilUiState`;
- `PerfilErrores`;
- `MutableStateFlow<PerfilUiState>`.

## Reglas

- nombre: mínimo 3 caracteres;
- correo: formato básico justificable;
- teléfono: opcional; si existe, debe cumplir una regla definida;
- la decisión de contacto se representa mediante `Checkbox`.

## Requisitos

- `OutlinedTextField`;
- `isError`;
- `supportingText`;
- ViewModel con funciones de cambio de campo;
- `validarFormulario(): Boolean`;
- observación mediante `collectAsState`;
- navegación a resumen sólo con formulario válido;
- ResumenPerfil observa el mismo ViewModel.

## Preguntas

1. ¿Qué datos forman parte del estado?
2. ¿Qué errores son derivados?
3. ¿Por qué el ViewModel no debería llamar directamente a `navigate`?
4. ¿Por qué aquí usamos ViewModel compartido en vez de pasar todos los campos por ruta?
5. ¿Qué cambiaría si el perfil tuviera que sobrevivir al cierre de la app?
