# PocketLog · Checkpoint Semana 03 · v0.3

## Propósito curricular

Este checkpoint representa el **estado objetivo de PocketLog al cierre de la Semana 03**, no una afirmación automática de que toda la sección ya lo alcanzó.

La evolución esperada es:

```text
listas paralelas
→ colección de objetos
→ modelo Registro
→ comportamiento y validaciones
→ resultados explícitos
→ data class / sealed class
→ introducción conceptual a suspend/corrutinas
```

## Alcance

- Kotlin de consola;
- `data class Registro`;
- colección `MutableList<Registro>`;
- `filter`, `count`, `find` e `indexOfFirst` sobre objetos;
- operación para completar por id;
- resultado cerrado mediante `sealed class`;
- manejo explícito de registro inexistente;
- ejemplo mínimo de función `suspend` sin Android, red ni persistencia.

## Fuera de alcance

- Android;
- Jetpack Compose;
- ViewModel;
- SQLite;
- Retrofit;
- Repository como obligación arquitectónica.

El avance real debe registrarse en `data/weekly/semana-03.yml`. Si una parte no fue trabajada efectivamente, se conserva como objetivo curricular y no se declara como cubierta.
