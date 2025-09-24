


    object CoffeeMachine {
        var currentState: CoffeeMachineState = CoffeeMachineState.Idle
        

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
                    //Crea un proceso sirviondo el cafe con leche
                    currentState=CoffeeMachineState.SirviendoconLeche(50)
                    println("Cafe con leche listo Estado: $currentState"+ "ml")
                    //Crea un proceso sirviondo el cafe con azucar
                    currentState=CoffeeMachineState.SirviendoconAzucar(50)

                    println("Cafe con azucar listo Estado: $currentState"+ "mg")
                }

                is CoffeeMachineState.MakingCoffee -> {
                    println("¡Espera! La máquina ya está haciendo café.")
                }

                is CoffeeMachineState.ServingCoffee -> {
                    println("Ya hay café servido. Por favor, toma tu café.")
                }
                is CoffeeMachineState.SirviendoconLeche->{
                    println("No necesitas tanta Leche")
                }
                is CoffeeMachineState.SirviendoconAzucar->{
                    println("Ya tiene suficiente azucar ")
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
