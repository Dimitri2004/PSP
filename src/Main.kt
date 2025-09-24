/**
 * Ejemplo de una máquina de café con estados usando Kotlin.
 * Incluye estados como Idle, MakingCoffee, ServingCoffee, SirviendoconLeche y SirviendoconAzucar.
 * La máquina puede hacer café, servirlo con leche o azúcar, y manejar errores.
 * @author Dima
 * @version 1.0
 */
fun main(){
    println("Iniciando la máquina de café...")
    CoffeeMachine.makeCoffee()
    CoffeeMachine.currentState= CoffeeMachineState.Idle
    CoffeeMachine.currentState= CoffeeMachineState.SirviendoconLeche(true)
    CoffeeMachine.makeCoffee()
    CoffeeMachine.currentState= CoffeeMachineState.SirviendoconAzucar(false)
    CoffeeMachine.makeCoffee()
    CoffeeMachine.clean()
    println("Proceso terminado.")
}

