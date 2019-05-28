package com.daniel.calculator

import java.lang.Exception

//mostrar un titulo
//pedir un numero
//preguntar que operacion quiere hacer
//pedir otro numero
//dar resultado
//preguntar otra vez que operacion quiere hacer
//....
class FinalCalculator {
    fun selectOptions(): Int {
        println("¿Que quiere hacer?")
        println("1.SUMAR")
        println("2.RESTAR")
        println("3.MULTIPLICAR")
        println("4.DIVIDIR")
        println("5.SALIR")
        val answer = try {
            readLine()?.toInt() ?: 0
        } catch (e: Exception) {
            println("Esto no es un numero valido")
            0
        }
        if (answer !in 1..5) {
            println("esa respuesta no es valida")
        }
        return answer
    }

    private fun increment(number1: Double, number2: Double) = number1 + number2

    private fun subtract(number1: Double, number2: Double) = number1 - number2

    private fun multip(number1: Double, number2: Double) = number1 * number2

    private fun divi(number1: Double, number2: Double) = if (number2 != 0.0) {
        number1 / number2
    }else{
        println("no se puede dividir por 0")
        number1
    }

    fun calculate(answer: Int, num1: Double, num2: Double): Double {
        return when (answer) {
            1 -> {
                increment(number1 = num1, number2 = num2)
            }
            2 -> {
                subtract(number1 = num1, number2 = num2)
            }
            3 -> {
                multip(number1 = num1, number2 = num2)
            }
            4 -> {
                divi(number1 = num1, number2 = num2)
            }
            5 ->{
                println("Adios")
                0.0
            }
            else ->{
                println("Esa tecla no es valida")
                0.0
            }
        }
    }
}

fun main (args: Array<String>) {
    val finalCalculator = FinalCalculator()
    println("com/daniel/calculator")
    println("Escribe un numero")
    var result = try {
        readLine()?.toDouble() ?: 0.0
    } catch (e: Exception) {
        println("Esto no es un numero valido")
        0.0
    }
    do {
        println("Escribe otro numero")
        val nextNumber = try {
            readLine()?.toDouble() ?: 0.0
        } catch (e: Exception) {
            println("Esto no es un numero valido")
            0.0
        }
        var option: Int
        do {
            option = finalCalculator.selectOptions()
        } while (option !in 1..5)

        result = finalCalculator.calculate(num1 = result, num2 = nextNumber, answer = option)
        println("su resultado es igual a $result")
    } while(option != 5)
}