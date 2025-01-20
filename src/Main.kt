import kotlin.random.Random

fun main(){
    var rm =ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")

    val palabras= listOf("John Wick","Helen Wick","Aurelio","Winston Scott","Charon","Viggo Tarasov","Iosef Tarasov","Marcus","Sofia Al-Azwar","Cassian","Perkins")
    val erroresMaximos=7
    var erroresActuales=0
    var letrasIntroducidas:MutableList<Char> = mutableListOf()
    val numPalabra = Random.nextInt(0, palabras.size-1)
    val palabra=palabras[numPalabra].lowercase() // somos buena gente no hay que diferencias mayuscula de minuscula
    val palabraModificada=StringBuilder("*".repeat(palabra.length))
//    Invita la casa
    if (palabra.contains(" ")){
        for (i in 0..palabra.length-1){
            if (palabra[i]==' '){
                palabraModificada[i]=' '
            }
        }
    }
    letrasIntroducidas.add(' ')

    println("Debes averiguar un personaje del universo John Wick deberían corresponder a uno de las 3 primeras peliculas")
    while (erroresActuales<erroresMaximos){
        println("Tu palabra actual esta: $palabraModificada")
        println("Llevas $erroresActuales de $erroresMaximos. Introduce a continuacion una letra (en caso de accidente hay tolerancia por si introduces varios o repites caracter")
        val entrada= readln().lowercase().first() // somos buena gente te pasamos el caracter introducido a minuscula
        if (letrasIntroducidas.contains(entrada)){
            println("Ese caracter $entrada ya ha sido introducido. Le recuerdo cuales ya estan introducidos $letrasIntroducidas")
            continue
        }
        letrasIntroducidas.add(entrada)
        if (palabra.contains(entrada)){
            for (i in 0..palabra.length-1){
                if (palabra[i]==entrada){
                    palabraModificada[i]=entrada
                }
            }
        }
        else{
            erroresActuales++
        }
        if (palabra==palabraModificada.toString()){
            break
        }

    }
    if (palabra==palabraModificada.toString()){
        println("Has ganado la partida. La palabra es $palabra")
    }
    else {
        println("Has perdido la partida la palabra que buscabas era $palabra")
    }

    rm.cerrar()
}