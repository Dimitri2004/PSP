

    sealed class CoffeeMachineState {
        object Idle : CoffeeMachineState()//Estados
        object MakingCoffee : CoffeeMachineState()//Estados
        data class ServingCoffee(val brand: String) : CoffeeMachineState()//Almacenar datos en estado
        data class SirviendoconLeche(val leche: Int) : CoffeeMachineState()
        data class SirviendoconAzucar(val azucar: Int):CoffeeMachineState()
        data class Error(val message: String) : CoffeeMachineState()
    }
