@file:Suppress("DUPLICATE_BRANCH_CONDITION_IN_WHEN")

object StateMachine {
   public var currentState: CoffeeMachineState = CoffeeMachineState.Idle


    fun setState(newState: CoffeeMachineState) {
        if (isCorrectoPedido(currentState, newState)) {
            currentState = newState
            updateState(CoffeeMachineState.Idle)

        } else {
            println("No es posible en $currentState para $newState")
        }
    }

    private fun isCorrectoPedido(from: CoffeeMachineState, to: CoffeeMachineState): Boolean {
        return when (from) {
            CoffeeMachineState.Idle -> to == CoffeeMachineState.MakingCoffee
            CoffeeMachineState.MakingCoffee -> to == CoffeeMachineState.ServingCoffee
            CoffeeMachineState.ServingCoffee -> to == CoffeeMachineState.SirviendoconLeche
            CoffeeMachineState.SirviendoconLeche -> to == CoffeeMachineState.SirviendoconAzucar
            CoffeeMachineState.SirviendoconAzucar -> to == CoffeeMachineState.Idle
            is CoffeeMachineState.Error -> to == CoffeeMachineState.Idle
            else -> false
        }

    }

    fun getState(): CoffeeMachineState {
        return currentState
    }

    fun updateState(newState: CoffeeMachineState) {
        println("[StateMachine] Estado actual: $currentState")
        currentState.onEnter(this)
    }

}


        /*
        fun clean() {
            println("Limpiando la máquina...")
            currentState = CoffeeMachineState.Idle
            println("Máquina limpia. Estado: $currentState")
        }
        */