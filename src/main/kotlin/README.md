# 📌 Proyecto de Gestión de Empleados en Kotlin

Este proyecto es una aplicación de consola en **Kotlin** que demuestra el uso de **colecciones** (`List`, `Set`, `Map`) y **operaciones de orden superior** (`filter`, `map`, `groupBy`, `associate`).  

La aplicación permite:  
- Registrar empleados en una lista.  
- Filtrar empleados según condiciones (ej: mayores de 30).  
- Agrupar empleados por departamento.  
- Calcular salarios promedios por departamento.  
- Convertir una lista en un mapa `nombre → salario`.  

---

## 🏗️ Diseño de las colecciones en Kotlin

### 1. **List y MutableList**
- Una `List` es **inmutable**, no se puede modificar después de creada.  
- Una `MutableList` es **mutable**, permite añadir, eliminar o actualizar elementos.  

```kotlin
val numeros = listOf(1, 2, 3)           // Lista inmutable
val letras = mutableListOf("a", "b")    // Lista mutable

letras.add("c")      // ["a", "b", "c"]
```

En este proyecto, los **empleados** se almacenan en una lista:

```kotlin
val empleados = listOf(
    Empleado("Ana", 25, 2500.0, "Ventas"),
    Empleado("Luis", 35, 3200.0, "TI"),
    Empleado("María", 40, 4000.0, "TI"),
    Empleado("Pedro", 28, 2800.0, "Marketing"),
    Empleado("Sofía", 33, 3500.0, "Ventas")
)
```

---

### 2. **Set y MutableSet**
- Un `Set` es una colección de **elementos únicos**, sin duplicados.  
- Un `MutableSet` permite añadir y quitar elementos.  

Ejemplo:

```kotlin
val conjunto = setOf(1, 2, 2, 3)
println(conjunto) // [1, 2, 3] (los duplicados se eliminan)
```

Se usan `Set` cuando se quiere garantizar **unicidad**, aunque en este proyecto no es el enfoque principal.

---

### 3. **Map y MutableMap**
- Un `Map` asocia **claves únicas** con valores.  
- Un `MutableMap` permite añadir, actualizar o eliminar pares clave-valor.  

Ejemplo:

```kotlin
val edades = mapOf("Ana" to 25, "Luis" to 35)
println(edades["Luis"]) // 35
```

En este proyecto se crea un mapa `nombre → salario`:

```kotlin
val mapaNombreSalario = empleados.associate { it.nombre to it.salario }
println(mapaNombreSalario) 
// {Ana=2500.0, Luis=3200.0, María=4000.0, Pedro=2800.0, Sofía=3500.0}
```

---

## ⚙️ Operaciones de orden superior

### 🔹 `filter` → Filtrar elementos
```kotlin
val mayoresDe30 = empleados.filter { it.edad > 30 }
println(mayoresDe30)
// [Empleado(nombre=Luis, ...), Empleado(nombre=María, ...), Empleado(nombre=Sofía, ...)]
```

---

### 🔹 `groupBy` → Agrupar elementos
```kotlin
val agrupadosPorDepto = empleados.groupBy { it.departamento }
println(agrupadosPorDepto)
// {Ventas=[Empleado(nombre=Ana,...), Empleado(nombre=Sofía,...)], 
//  TI=[Empleado(nombre=Luis,...), Empleado(nombre=María,...)], 
//  Marketing=[Empleado(nombre=Pedro,...)]}
```

---

### 🔹 `map` → Transformar elementos
```kotlin
val nombres = empleados.map { it.nombre }
println(nombres)
// [Ana, Luis, María, Pedro, Sofía]
```

---

### 🔹 `associate` → Convertir lista en mapa
```kotlin
val mapaNombreSalario = empleados.associate { it.nombre to it.salario }
println(mapaNombreSalario)
// {Ana=2500.0, Luis=3200.0, María=4000.0, Pedro=2800.0, Sofía=3500.0}
```

---

## 🚀 Ejecución

1. Compila el proyecto:  
   ```bash
   kotlinc Empleado.kt Main.kt -include-runtime -d app.jar
   ```

2. Ejecuta la aplicación:  
   ```bash
   java -jar app.jar
   ```

---

📖 Este proyecto es un ejemplo práctico para **aprender colecciones en Kotlin** y cómo aplicar operaciones de orden superior en la manipulación de datos.
