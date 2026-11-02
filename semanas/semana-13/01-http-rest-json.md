# HTTP, REST y JSON

## Objetivo y problema
Una aplicación con datos fijos cambia solo cuando editamos su código. Para consultar información mantenida por otro sistema necesita un contrato de comunicación. HTTP transporta solicitudes y respuestas; REST es un estilo de diseño de servicios; JSON es un formato de representación de datos. Son conceptos distintos.

## Solicitud y respuesta
Una solicitud identifica método, URL, cabeceras y, cuando corresponde, cuerpo. Por ejemplo:

```http
GET https://jsonplaceholder.typicode.com/posts?userId=1
Accept: application/json
```

La ruta `/posts` identifica recursos; `userId=1` es un filtro. GET consulta información. POST suele crear; PUT reemplaza una representación; PATCH modifica parcialmente; DELETE elimina. Sus efectos concretos dependen del contrato de cada API.

La respuesta incluye un código HTTP, cabeceras y un cuerpo. `200` indica éxito, `201` creación, `204` éxito sin cuerpo, `400` solicitud inválida, `401` falta de autenticación válida, `403` acceso denegado, `404` recurso inexistente y `500` fallo del servidor. Una falla de red puede impedir recibir cualquier código HTTP.

## Leer JSON antes de programar
Ejemplo didáctico de un objeto (no una respuesta literal garantizada del servicio):

```json
{"userId": 1, "id": 7, "title": "Una lectura", "body": "Contenido"}
```

Un objeto usa `{}` y una lista usa `[]`. Números y booleanos no llevan comillas; las cadenas sí. Un campo ausente y un campo `null` requieren revisar el contrato; no asumir que un texto siempre existe.

```kotlin
data class PublicacionDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
```

DTO significa objeto de transferencia de datos. Representa el contrato remoto y no tiene por qué ser idéntico al modelo de dominio ni al estado de una pantalla. La conversión JSON → Kotlin la realiza el convertidor configurado en Retrofit.

## Errores frecuentes
- Confundir lista vacía con falla: `200` con `[]` puede ser un resultado válido.
- Suponer que recibir JSON implica éxito: también un error HTTP puede traer JSON.
- Cambiar nombres de propiedades sin configurar su correspondencia con el contrato remoto.
- Confundir una API de demostración con un backend persistente: JSONPlaceholder simula escrituras, no conserva los cambios.
- Colocar datos sensibles en URLs, código o repositorios públicos.

## Comprueba y continúa
Abre la URL del ejemplo en el navegador. Identifica lista, campos y filtro. Cambia `userId=1` por `userId=999999` y compara. Explica por qué una respuesta vacía no equivale a desconexión. Continúa con [Retrofit y MVVM](02-retrofit-mvvm-compose.md).

Fuente primaria: [JSONPlaceholder](https://jsonplaceholder.typicode.com/), documentación de rutas y limitaciones.
