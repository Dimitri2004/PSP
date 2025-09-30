/**
 * Ejemplo de una máquina de café con estados usando Kotlin.
 * Incluye estados como Idle, MakingCoffee, ServingCoffee, SirviendoconLeche y SirviendoconAzucar.
 * La máquina puede hacer café, servirlo con leche o azúcar, y manejar errores.
 * @author Dima
 * @version 1.0
 */
fun main() {
    StateMachine.updateState(CoffeeMachineState.Idle)

    while (true) {
        val currentState = StateMachine.getState()

        if ( currentState is CoffeeMachineState.SirviendoconAzucar) {
            println("\n--- Fin café ---")
            break
        }
    }

}

