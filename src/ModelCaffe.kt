/**
 * Estados de la maquina de cafe
 * @property Idle Estado inicial, la máquina está apagada.
 * @property MakingCoffee La máquina está en proceso de hacer café.
 * @property ServingCoffee La máquina ha servido el café, almacena la marca del café.
 * @property SirviendoconLeche La máquina está sirviendo café con leche, almacena si se puede añadir más leche.
 * @property SirviendoconAzucar La máquina está sirviendo café con azúcar, almacena si se puede añadir más azúcar.
 * @property Error La máquina ha encontrado un error, almacena el mensaje de error.
 * @constructor Crea un estado de la máquina de café.
 * @author Dima
 * @version 1.0
 */
sealed class CoffeeMachineState {
        object Idle : CoffeeMachineState()//Estados
        object MakingCoffee : CoffeeMachineState()//Estados
        data class ServingCoffee(val brand: String) : CoffeeMachineState()//Almacenar datos en estado
        data class SirviendoconLeche(val leche: Boolean) : CoffeeMachineState()
        data class SirviendoconAzucar(val azucar: Boolean):CoffeeMachineState()
        data class Error(val message: String) : CoffeeMachineState()
    }
