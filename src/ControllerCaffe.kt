


    object CoffeeMachine {
        var currentState: CoffeeMachineState = CoffeeMachineState.Idle
        var currwntState : CoffeeMachineState = CoffeeMachineState.SirviendoconLeche(7)

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

                    currentState=CoffeeMachineState.SirviendoconLeche(50)
                    println("$currentState")

                    currentState=CoffeeMachineState.SirviendoconAzucar(50)

                    println("$currentState")
                }

                is CoffeeMachineState.MakingCoffee -> {
                    println("¡Espera! La máquina ya está haciendo café.")
                }

                is CoffeeMachineState.ServingCoffee -> {
                    println("Ya hay café servido. Por favor, toma tu café.")
                }
                is CoffeeMachineState.SirviendoconLeche->{

                    println("Agregando Leche:$currentState")
                }
                is CoffeeMachineState.SirviendoconAzucar->{
                    currentState=CoffeeMachineState.SirviendoconLeche(50)

                    println("Agregando Leche:$currentState")
                }
                is CoffeeMachineState.Error -> {
                    println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
                }
            }
        }
        fun clean() {
            println("Limpiando la máquina...")
            currentState = CoffeeMachineState.Idle
            println("Máquina limpia. Estado: $currentState")
        }
    }
