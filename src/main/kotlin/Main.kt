import Class.Empleado

fun main() {
    // 2. Crear una lista de al menos 5 empleados
    val empleados = listOf(
        Empleado("Claudia", 25, 2500.0, "Ventas"),
        Empleado("Marta", 35, 3200.0, "TI"),
        Empleado("Mauricio", 40, 4000.0, "TI"),
        Empleado("Ramiro", 28, 2800.0, "Marketing"),
        Empleado("Fabio", 33, 3500.0, "Ventas")
    )

    println("=== Lista de empleados ===")
    empleados.forEach { println(it) }

    // 3. Filtrar los mayores de 30 años
    val mayoresDe30 = empleados.filter { it.edad > 30 }
    println("\n=== Empleados mayores de 30 años ===")
    mayoresDe30.forEach { println(it) }

    // 4. Agruparlos por departamento
    val agrupadosPorDepto = empleados.groupBy { it.departamento }
    println("\n=== Empleados agrupados por departamento ===")
    agrupadosPorDepto.forEach { (depto, lista) ->
        println("$depto: ${lista.map { it.nombre }}")
    }

    // 5. Calcular salario promedio por departamento
    val salarioPromedioPorDepto = empleados
        .groupBy { it.departamento }
        .mapValues { (_, lista) -> lista.map { it.salario }.average() }

    println("\n=== Salario promedio por departamento ===")
    salarioPromedioPorDepto.forEach { (depto, promedio) ->
        println("$depto → $promedio")
    }

    // 6. Convertir la lista en un mapa nombre → salario
    val mapaNombreSalario = empleados.associate { it.nombre to it.salario }
    println("\n=== Mapa nombre → salario ===")
    mapaNombreSalario.forEach { (nombre, salario) ->
        println("$nombre → $salario")
    }
}