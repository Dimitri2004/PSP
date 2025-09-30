import CoffeeMachineState.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CoffeeMachineTest {

    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
        StateMachine.currentState = Idle // Reset state before each test
    }

    @Test
    fun testInitialState() {
        assertEquals(Idle, StateMachine.getState())
    }

    @Test
    fun testTransitionIdleToMakingCoffee() {
        StateMachine.setState(MakingCoffee)
        assertEquals(MakingCoffee, StateMachine.getState())
        assertTrue(outputStreamCaptor.toString().contains("Estando en Idle"))
        assertTrue(outputStreamCaptor.toString().contains("Empezando a hacer cafe"))
    }

    @Test
    fun testTransitionMakingCoffeeToServingCoffee() {
        StateMachine.setState(MakingCoffee)
        outputStreamCaptor.reset()
        StateMachine.setState(ServingCoffee)
        assertEquals(ServingCoffee, StateMachine.getState())
        assertTrue(outputStreamCaptor.toString().contains("Empezando a hacer cafe"))
        assertTrue(outputStreamCaptor.toString().contains("Sirviendo cafe"))
    }

    @Test
    fun testInvalidTransitionFromIdleToServingCoffee() {
        StateMachine.setState(ServingCoffee)
        assertEquals(Idle, StateMachine.getState()) // Should remain in Idle
        assertTrue(outputStreamCaptor.toString().contains("No es posible en Idle para ServingCoffee"))
    }

    @Test
    fun testTransitionServingCoffeeToSirviendoconLeche() {
        StateMachine.setState(MakingCoffee)
        StateMachine.setState(ServingCoffee)
        outputStreamCaptor.reset()
        StateMachine.setState(SirviendoconLeche)
        assertEquals(SirviendoconLeche, StateMachine.getState())
        assertTrue(outputStreamCaptor.toString().contains("Sirviendo cafe"))
        assertTrue(outputStreamCaptor.toString().contains("Sirviendo con leche"))
    }

    @Test
    fun testTransitionSirviendoconLecheToIdle() {
        StateMachine.setState(MakingCoffee)
        StateMachine.setState(ServingCoffee)
        StateMachine.setState(SirviendoconLeche)
        outputStreamCaptor.reset()
        StateMachine.setState(Idle) // Invalid transition, should remain in SirviendoconLeche
        assertEquals(SirviendoconLeche, StateMachine.getState())
        assertTrue(outputStreamCaptor.toString().contains("No es posible en SirviendoconLeche para Idle"))
    }

    @Test
    fun testTransitionServingCoffeeToSirviendoconAzucar() {
        StateMachine.setState(MakingCoffee)
        StateMachine.setState(ServingCoffee)
        outputStreamCaptor.reset()
        StateMachine.setState(SirviendoconAzucar)
        assertEquals(SirviendoconAzucar, StateMachine.getState())
        assertTrue(outputStreamCaptor.toString().contains("Sirviendo cafe"))
        assertTrue(outputStreamCaptor.toString().contains("Sirviendo con leche"))
    }
}

