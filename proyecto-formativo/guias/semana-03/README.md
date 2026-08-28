# PocketLog · Guía Semana 03 · v0.3

## Punto de partida

PocketLog v0.2 mantiene datos relacionados en listas separadas. Esa deuda se usa para justificar el paso a objetos.

## Secuencia

1. Cierra `List` / `MutableList`, recorridos y operaciones funcionales pendientes.
2. Identifica el problema de las listas paralelas.
3. Modela un `Registro` como objeto.
4. Reemplaza las listas paralelas por `MutableList<Registro>`.
5. Separa operaciones que retornan datos de las que imprimen.
6. Incorpora validación y manejo explícito de errores.
7. Usa `data class` y `sealed class` cuando hayan sido explicadas.
8. Introduce `suspend`/corrutinas sólo después de comprender el problema de bloqueo.

## Resultado objetivo

Una aplicación Kotlin de consola con un dominio reconocible y reutilizable, todavía sin dependencias Android.

## No adelantar

- Activity;
- Compose;
- ViewModel;
- SQLite;
- Retrofit;
- Repository como requisito arquitectónico.

El código vivo está en `../../pocketlog/` y el estado objetivo histórico en `../../checkpoints/semana-03/`.
