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

interface ICoffeeMachineState {
    fun onEnter(stateMachine: StateMachine){
        StateMachine.getState()
    }
}

sealed class CoffeeMachineState: ICoffeeMachineState {
        object Idle : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine){
                println("[Idle]Estando en Idle ...")
                stateMachine.setState(MakingCoffee)
            }
        }
        object MakingCoffee : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine){
                println("[Making]Empezando a hacer cafe....")
                stateMachine.setState(ServingCoffee)
            }
        }
            object ServingCoffee : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine){
                println("[Serving]Sirviendo cafe...")
                stateMachine.setState(ServingCoffee)
            }
        }
            object SirviendoconLeche : CoffeeMachineState() {
                override fun onEnter(stateMachine: StateMachine) {
                    println("[SirviendoLeche]Sirviendo con leche...")
                    stateMachine.setState(ServingCoffee)
                }
            }
            object SirviendoconAzucar : CoffeeMachineState(){
                override fun onEnter(stateMachine: StateMachine){
                    println("[SirviendoLeche]Sirviendo con leche...")
                    stateMachine.setState(ServingCoffee)
             }
        }
        data class Error(val message: String) : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine) {
                TODO("Not yet implemented")
            }
        }
    }
