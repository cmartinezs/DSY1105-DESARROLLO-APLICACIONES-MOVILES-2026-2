# 2 · POO en Kotlin · de clases a polimorfismo

## 1. Clase, propiedades, métodos y objetos

Una clase agrupa datos relacionados y comportamiento bajo una misma abstracción.

```kotlin
class Registro(
    val titulo: String,
    val categoria: String,
    var completado: Boolean = false
) {
    fun completar() {
        completado = true
    }

    fun resumen(): String {
        return "$titulo [$categoria] - ${if (completado) "OK" else "Pendiente"}"
    }
}
```

```kotlin
val registro = Registro("Practicar Kotlin", "Estudio")
println(registro.resumen())
registro.completar()
println(registro.resumen())
```

Relaciona explícitamente:

```text
clase → define la estructura y comportamiento
propiedad → estado del objeto
método → comportamiento
objeto → instancia concreta de la clase
```

## 2. Kotlin reduce ceremonia, no elimina conceptos

El constructor primario puede declararse en la cabecera. `val` crea una propiedad no reasignable y `var` una propiedad reasignable. Esto no implica que todo deba quedar público y mutable.

## 3. Encapsulamiento

```kotlin
class Cuenta(saldoInicial: Double) {
    private var saldo: Double = saldoInicial

    fun depositar(monto: Double) {
        if (monto > 0) {
            saldo += monto
        }
    }

    fun consultarSaldo(): Double = saldo
}
```

El estado interno se modifica mediante comportamiento controlado.

## 4. Herencia en Kotlin

Las clases Kotlin son `final` por defecto. Si una clase puede heredarse debe declararse `open`.

```kotlin
open class Notificacion(
    val destinatario: String
) {
    open fun enviar() {
        println("Notificación para $destinatario")
    }
}

class Email(destinatario: String) : Notificacion(destinatario) {
    override fun enviar() {
        println("Email enviado a $destinatario")
    }
}
```

Conceptos que deben reconocerse:

- `open`: permite herencia o sobrescritura;
- `:`: expresa la relación de herencia;
- `override`: sobrescribe comportamiento heredado;
- el constructor de la clase padre se invoca en la declaración de la subclase.

## 5. Polimorfismo

```kotlin
class Sms(destinatario: String) : Notificacion(destinatario) {
    override fun enviar() {
        println("SMS enviado a $destinatario")
    }
}

val notificaciones: List<Notificacion> = listOf(
    Email("ana@ejemplo.cl"),
    Sms("+56911111111")
)

notificaciones.forEach { it.enviar() }
```

La lista usa el tipo general `Notificacion`, pero cada objeto ejecuta su implementación concreta de `enviar()`.

Eso es polimorfismo en ejecución.

## 6. Comparación conceptual con Java

No traduzcas línea por línea. Busca primero el concepto:

| Concepto | Java | Kotlin |
|---|---|---|
| herencia | `extends` | `:` |
| clase heredable | normal por defecto | `open class` |
| método sobrescribible | normal salvo `final` | `open fun` |
| sobrescritura | `@Override` | `override` obligatorio |
| getter trivial | método explícito frecuente | propiedad |
| constructor | bloque separado | constructor primario en cabecera |

## 7. Colecciones de objetos

```kotlin
val registros = mutableListOf(
    Registro("Leer", "Estudio"),
    Registro("Comprar alimento", "Personal")
)

val pendientes = registros.filter { !it.completado }
```

Aquí se conectan colecciones y objetos sin convertir PocketLog en el ejemplo principal del contenido.

## Ejercicios breves

1. Crea `Producto` con propiedades y un método `aplicarDescuento()`.
2. Crea `Empleado` y una subclase `Desarrollador` que sobrescriba `trabajar()`.
3. Crea una lista `List<Empleado>` con objetos de tipos distintos y recórrela ejecutando `trabajar()`.
4. Explica qué línea demuestra herencia, cuál demuestra sobrescritura y cuál demuestra polimorfismo.

## Checkpoint

Debes poder explicar con tus palabras:

- clase vs objeto;
- propiedad vs variable local;
- método/comportamiento;
- `val` vs `var` dentro de un modelo;
- encapsulamiento;
- relación `es-un`;
- por qué Kotlin exige `open`;
- diferencia entre herencia, sobrescritura y polimorfismo.