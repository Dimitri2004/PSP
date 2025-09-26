@file:Suppress("DUPLICATE_BRANCH_CONDITION_IN_WHEN")

/**
 *
 * Controlador de la máquina de café que gestiona los estados y las operaciones.
 * @property currentState El estado actual de la máquina de café.
 * @property cantidadLeche La cantidad de leche disponible en ml.
 * @property cantidadAzucar La cantidad de azúcar disponible en gramos.
 * @author Dima
 * @version 1.0
 */
object StateMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle


    fun setState(newState: CoffeeMachineState) {
        if (esCorrectoPedido(currentState, newState)) {
            currentState = newState

            updateState()

        } else {
            println("No es posible en $currentState para $newState")
        }
    }

    private fun esCorrectoPedido(from: CoffeeMachineState, to: CoffeeMachineState): Boolean {
        return when (from) {
            CoffeeMachineState.Idle -> to == CoffeeMachineState.MakingCoffee
            CoffeeMachineState.MakingCoffee -> to == CoffeeMachineState.ServingCoffee
            CoffeeMachineState.ServingCoffee -> to == CoffeeMachineState.SirviendoconLeche
            CoffeeMachineState.ServingCoffee -> to == CoffeeMachineState.SirviendoconAzucar
            CoffeeMachineState.SirviendoconAzucar -> to == CoffeeMachineState.Idle
            else -> false
        }

    }

    fun getState(): CoffeeMachineState {
        return currentState
    }

    fun updateState() {
        println("[StateMachine] Estado actual: $currentState")
        currentState.onEnter(this)
    }

}

        /**
         * Limpia la máquina y resetea su estado a Idle.
         * @param
         */
        /*
        fun clean() {
            println("Limpiando la máquina...")
            currentState = CoffeeMachineState.Idle
            println("Máquina limpia. Estado: $currentState")
        }
        */