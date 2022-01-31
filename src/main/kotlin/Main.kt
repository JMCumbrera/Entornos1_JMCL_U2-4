/**
 * Fecha: 26/01/2022
 * Versión: 1.0
 * Autor: Juan Manuel Cumbrera López
 * Empresa/Entidad: Estudiante
 * Proyecto: Actividad 4 del Tema 2
 */
class ArrayOperations(private var arr1: Array<Int?>) {
    var arr2: Array<Int?> = arrayOfNulls(20)

    init {
        require(arr1.size == 20) { "El tamaño del array debe ser de 20" }
    }

    private fun fillArray(): Array<Int?> {
        for (i in 0 until 20) {
            arr1[i] = (0..1000).random()
        }

        arr2 = arr1
        return arr2
    }

    private fun sortArray(): Array<Int?> {
        arr1.sort()

        arr2 = arr1
        return arr2
    }

    fun prepareAndReturnArray(): Array<Int?> {
        fillArray()
        sortArray()

        return arr2
    }
}

fun resultadoNota(n: Int): String {
    return when (n) {
        in 0..4 -> "Suspenso"
        in 5..6 -> "Aprobado"
        in 7..8 -> "Notable"
        in 9..10 -> "Sobresaliente"
        else -> "El valor introducido no es correcto"
    }
}

fun main() {
    /**
     * Ejercicio 2:
     */
    val array: Array<Int?> = arrayOfNulls(20)
    val claseArray = ArrayOperations(array)
    val array2 = claseArray.prepareAndReturnArray()

    println("Array ordenado: ")
    array2.forEach { print("$it ") }
    println("\n")

    println("Números pares del array: ")
    array2.forEach { if (it != null) if (it % 2 == 0) print("$it ") }
    println("\n")

    println("Primer elemento del array: ")
    println(array2[0])
    println("\n")

    println("Último elemento del array: ")
    println(array2[19])
    println("\n")

    println("Suma de todos los elementos del array: ")
    var suma = 0
    for (element in array2) {
        suma += element!!
    }
    println(suma)
    println("\n")

    println("Array SIN elementos impares: ")
    val oddList = arrayListOf<Int>()
    for (i in 0..array2.size - 1) if (array2[i]!! % 2 == 0) array2[i]?.let { oddList.add(it) }
    oddList.forEach { print("$it ") }
    println("\n")

    /**
     * Ejercicio 1:
     */
    val nota1 = 10
    val nota2 = 8
    val nota3 = 6
    val nota4 = 3
    val nota5 = -10
    
    println(resultadoNota(nota1))
    println(resultadoNota(nota2))
    println(resultadoNota(nota3))
    println(resultadoNota(nota4))
    println(resultadoNota(nota5))
}