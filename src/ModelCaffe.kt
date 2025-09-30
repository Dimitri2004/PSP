

interface ICoffeeMachineState {
    fun onEnter(stateMachine: StateMachine)

}

sealed class CoffeeMachineState: ICoffeeMachineState {
        object Idle : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine){
                println("[Idle]Estando en Idle ...")
            }
            init {
                println("[idle] Máquina en estado Idle.")
            }
        }
        object MakingCoffee : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine){
                println("[Making]Empezando a hacer cafe....")
                stateMachine.setState(ServingCoffee)
            }
            init {
                println("[Making] Máquina en estado MakingCoffee.")
            }
        }
        object ServingCoffee : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine){
                println("[Serving]Sirviendo cafe...")
                stateMachine.setState(SirviendoconLeche)
                }
            init {
                println("[Serving] Máquina en estado ServingCoffee.")
            }
            }
            object SirviendoconLeche : CoffeeMachineState() {
                override fun onEnter(stateMachine: StateMachine) {
                    println("[SirviendoLeche]Sirviendo con leche...")
                    stateMachine.setState(SirviendoconAzucar)
                }
                init {
                    println("[SirviendoLeche] Máquina en estado SirviendoconLeche.")
                }
            }
            object SirviendoconAzucar : CoffeeMachineState(){
                override fun onEnter(stateMachine: StateMachine){
                    println("[SirviendoLeche]Sirviendo con leche...")
                    stateMachine.setState(Idle)
             }
                init {
                    println("[SirviendoAzucar] Máquina en estado SirviendoconAzucar.")
                }
        }
        data class Error(val message: String) : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine) {
                TODO("NO implementado")
            }
        }
    }
