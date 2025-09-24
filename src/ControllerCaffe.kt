/**
 *
 * Controlador de la máquina de café que gestiona los estados y las operaciones.
 * @property currentState El estado actual de la máquina de café.
 * @property cantidadLeche La cantidad de leche disponible en ml.
 * @property cantidadAzucar La cantidad de azúcar disponible en gramos.
 * @author Dima
 * @version 1.0
 */
object CoffeeMachine {
        var currentState: CoffeeMachineState = CoffeeMachineState.Idle
        var cantidadLeche: Int = 70
        var cantidadAzucar: Int = 40


        /**
         * Inicia el proceso de hacer café dependiendo del estado actual de la máquina.
         * @param brand La marca del café a preparar (opcional).
         * @param leche Indica si se debe añadir leche (opcional).
         * @param azucar Indica si se debe añadir azúcar (opcional).
         */
        fun makeCoffee() {
            println("Estado actual: $currentState")//Inicializa el estado base al que represente

            when (currentState) {
                is CoffeeMachineState.Idle -> {
                    println("Máquina encendida. Empezando a hacer café...")
                    currentState = CoffeeMachineState.MakingCoffee
                    Thread.sleep(2000)
                    // Simula un proceso de preparación
                    currentState = CoffeeMachineState.ServingCoffee("Capuccino")
                    println("¡Café listo! Estado: $currentState")
                    // Cambia al estado de sirviendo café
                }

                is CoffeeMachineState.MakingCoffee -> {
                    println("¡Espera! La máquina ya está haciendo café.")
                }

                is CoffeeMachineState.ServingCoffee -> {
                    println("Ya hay café servido. Por favor, toma tu café.")
                }
                is CoffeeMachineState.SirviendoconLeche -> {
                    if ((currentState as CoffeeMachineState.SirviendoconLeche).leche==false) {
                        currentState = CoffeeMachineState.Error("No puedes añadir más leche")
                        println("Exception: ${(currentState as CoffeeMachineState.Error).message}")
                        //Lanza una excepcion si se intenta añadir más leche
                    } else {
                        println("Estado: ${CoffeeMachineState.ServingCoffee("Capuccino")} con $cantidadLeche ml de leche")
                    }
                }
                is CoffeeMachineState.SirviendoconAzucar -> {

                    if ((currentState as CoffeeMachineState.SirviendoconAzucar).azucar==false) {
                        currentState = CoffeeMachineState.Error("No puedes añadir más azúcar")
                        println("Exception: ${(currentState as CoffeeMachineState.Error).message}")
                        //Lanza una excepcion si se intenta añadir más azucar
                    } else {
                        println("Sirviendo cafe con $cantidadAzucar g de azúcar ")
                    }
                }
                is CoffeeMachineState.Error -> {
                    println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
                }

            }

        }

        /**
         * Limpia la máquina y resetea su estado a Idle.
         * @param
         */
        fun clean() {
            println("Limpiando la máquina...")
            currentState = CoffeeMachineState.Idle
            println("Máquina limpia. Estado: $currentState")
        }

    }
