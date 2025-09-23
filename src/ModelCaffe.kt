

    sealed class CoffeeMachineState {
        object Idle : CoffeeMachineState()//Estados
        object MakingCoffee : CoffeeMachineState()//Estados
        data class ServingCoffee(val brand: String) : CoffeeMachineState()//Almacenar datos en estado
        data class SirviendoconLeche(val cantidadL: Int) : CoffeeMachineState()
        data class SirviendoconAzucar(val cantidadA: Int):CoffeeMachineState()
        data class Error(val message: String) : CoffeeMachineState()
    }
