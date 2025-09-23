

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    CoffeeMachine.makeCoffee()
    CoffeeMachine.currentState = CoffeeMachineState.Error("Danger")
    CoffeeMachine.currentState = CoffeeMachineState.MakingCoffee
    CoffeeMachine.currentState = CoffeeMachineState.ServingCoffee("Capuccino")
    CoffeeMachine.currentState = CoffeeMachineState.MakingCoffee
    CoffeeMachine.currentState=CoffeeMachineState.SirviendoconLeche(5)
    CoffeeMachine.currentState = CoffeeMachineState.MakingCoffee
    CoffeeMachine.currentState=CoffeeMachineState.SirviendoconAzucar(5)
    CoffeeMachine.currentState = CoffeeMachineState.MakingCoffee
    CoffeeMachine.clean()

}