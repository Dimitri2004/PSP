

interface ICoffeeMachineState {
    fun onEnter(stateMachine: StateMachine)

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
                stateMachine.setState(SirviendoconLeche)
                }

            }
            object SirviendoconLeche : CoffeeMachineState() {
                override fun onEnter(stateMachine: StateMachine) {
                    println("[SirviendoLeche]Sirviendo con leche...")
                    stateMachine.setState(SirviendoconAzucar)
                }

            }
            object SirviendoconAzucar : CoffeeMachineState(){
                override fun onEnter(stateMachine: StateMachine){
                    println("[SirviendoAzucar]Sirviendo con azucar...")
                    //stateMachine.setState(Idle)

             }

        }
        data class Error(val message: String) : CoffeeMachineState(){
            override fun onEnter(stateMachine: StateMachine) {
                TODO("NO implementado")
            }
        }
    }
