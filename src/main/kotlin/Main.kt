var encendido : Boolean = false
var velocidad : Int = 0
var accionAcelerar: Boolean = false


class coche(val Marca: String, val Modelo: String, val Color: String, var velocidadMax: Int, var gasolina: Int
, var tanque: Int, var numeroMarchas: Int = 5, var marcha: Int = 1) {


    init
    {   require(velocidadMax in 10..250) { "Velocidad invalida." }
    }

    fun encender(){

        if(encendido==false){
            encendido = true
            println("Se ha encendido el motor")
        }
        else{
            println("El motor ya está encendido")
        }

    }

    fun apagar(){
        if (encendido == false){
            println("El motor ya está apagado")
        }
        else{
            encendido = false
            println("El motor se ha apagado")
        }
    }

    fun iniciar()
    {
        if (encendido==true)
        {
            marcha = 1
            acelerar()
        }
    }

    fun parar()
    {
        marcha = 0
        velocidad = 0
        println("El coche está parado")
    }

    fun acelerar()
    {
        if (gasolina>0)
        {
            if (velocidad + 10 < velocidadMax)
            {
                println("El coche acelera de una velocidad de $velocidad a ${velocidad + 10}")
                velocidad = velocidad + 10
                //Esta variable activa el método controlMarchas para que se reste la gasolina al acelerar
                accionAcelerar = true

            }
            else
            {
                velocidad = velocidadMax
                accionAcelerar = true
                println("El coche va a máxima velocidad")
            }
        }
        else
        {
            println("No queda gasolina, el coche se va a parar.")
            parar()

        }
    }

    fun frenar()
    {
        velocidad = 0
        accionAcelerar = true
        println("El coche ha frenado")
    }

    fun incrementarMarcha()
    {
        marcha = marcha + 1
    }

    fun decrementarMarcha()
    {
        marcha = marcha - 1
    }

    fun llenarTanque(){
        gasolina = tanque
        println("El tanque de gasolina ahora está lleno")
    }

    fun controlMarchas()
    {
        var continuar = true
        while (continuar == true)
        {
            if (accionAcelerar==true) {

                when (marcha) {

                    1 ->
                    {
                        gasolina - 5
                        accionAcelerar = false
                    }
                    2 ->                     {
                        gasolina - 4
                        accionAcelerar = false
                    }
                    3 ->                     {
                        gasolina - 3
                        accionAcelerar = false
                    }
                    4 ->                     {
                        gasolina - 2
                        accionAcelerar = false
                    }
                    5 ->                     {
                        gasolina - 1
                        accionAcelerar = false
                    }

                }
            }
        }
    }
}




fun main() {


    var coche1 = coche("Toyota","Auri", "Rojo", 200,200,250)

    coche1.controlMarchas()





}