# Semana 06 · Ejercicio focalizado · HabitCounter

## Propósito
Practicar sólo **Compose, estado, eventos, ViewModel y separación UI/comportamiento**, sin reutilizar PocketLog.

## Requerimiento
Construye una app de una pantalla llamada **HabitCounter**:
- muestra “Tomar agua”;
- muestra un contador;
- permite incrementar;
- permite disminuir sin bajar de cero;
- permite reiniciar;
- muestra un mensaje al llegar a 8.

## Debes utilizar
- `MaterialTheme`;
- `Column` y/o `Row`;
- `Text`;
- `Button`;
- `Modifier`;
- `HabitUiState`;
- `HabitViewModel`.

`Scaffold` puede utilizarse si ya lo comprendes, pero **no es requisito** de este ejercicio. La estructura de pantalla con `Scaffold` se trabaja explícitamente en Semana 7.

## No utilizar
Navigation Compose, Room/SQLite, REST, DI, persistencia ni múltiples pantallas.

## Flujo esperado
```text
tap → callback → HabitViewModel → HabitUiState → Compose actualiza
```

## Criterios
- [ ] inicia en 0;
- [ ] incrementa;
- [ ] nunca queda negativo;
- [ ] reinicia;
- [ ] muestra mensaje en 8;
- [ ] la regla del contador no vive en el composable;
- [ ] puedes explicar dónde vive el estado.

## Desafío opcional
Agrega un segundo hábito sin duplicar toda la pantalla.
