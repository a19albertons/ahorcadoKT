import kotlin.random.Random

fun main(){
    val rm =ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(1000)

    val palabras= listOf("John Wick","Baba Yaga","Helen Wick","Aurelio","Winston Scott","Charon","Viggo Tarasov","Iosef Tarasov","Marcus","Sofia Al-Azwar","Cassian","Perkins")
    val erroresMaximos=7
    var erroresActuales=0
    val letrasIntroducidas:MutableList<Char> = mutableListOf()
    val numPalabra = Random.nextInt(0, palabras.size-1)
    val palabra=palabras[numPalabra].lowercase() // somos buena gente no hay que diferencias mayuscula de minuscula
    val palabraModificada=StringBuilder("*".repeat(palabra.length))
    val caracteres_gratis= listOf(' ', '-')
//    Invita la casa
    for (i in caracteres_gratis){
        if (palabra.contains(i)){
            for (j in 0..palabra.length-1){
                if (palabra[j]==i){
                    palabraModificada[j]=i
                }
            }
        }
        letrasIntroducidas.add(i)
    }



    println("Debes averiguar un personaje del universo John Wick deberían corresponder a uno de las 3 primeras peliculas")
    while (erroresActuales<erroresMaximos){
        println("Tu nombre actual esta: $palabraModificada")
        println("Llevas $erroresActuales de $erroresMaximos. Introduce a continuacion una letra (en caso de accidente hay tolerancia por si introduces varios o repites caracter)")
        val entrada= readln().lowercase().first() // somos buena gente te pasamos el caracter introducido a minuscula
        if (letrasIntroducidas.contains(entrada)){
            println("Ese caracter $entrada ya ha sido introducido. Le recuerdo cuales ya estan introducidos $letrasIntroducidas")
            Thread.sleep(20)
            continue
        }
        letrasIntroducidas.add(entrada)
        Thread.sleep(100)
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
        Thread.sleep(10)
        if (palabra==palabraModificada.toString()){
            break
        }

    }
    if (palabra==palabraModificada.toString()){
        println("Has ganado la partida. El nombre es $palabra")
    }
    else {
        println("Has perdido la partida el nombre que buscabas era $palabra")
    }

    rm.cerrar()
}