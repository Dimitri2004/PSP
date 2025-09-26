import CoffeeMachineState.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CoffeeMachineTest {



    @BeforeEach
    fun setUp() {
        CoffeeMachine.currentState = Idle
    }

        @Test
        fun testNoHaceCafeSiYaEstaSirviendo() {
            CoffeeMachine.currentState = ServingCoffee("Capuccino")
            val outContent = ByteArrayOutputStream()
            System.setOut(PrintStream(outContent))

            CoffeeMachine.makeCoffee()

            System.setOut(System.out)
            assertTrue(outContent.toString().contains("Ya hay café servido. Por favor, toma tu café."))
            assertTrue(CoffeeMachine.currentState is ServingCoffee)
        }
        @Test
        fun testNoHaceCafeSiYaEstaHaciendolo() {
            CoffeeMachine.currentState = MakingCoffee
            val outContent = ByteArrayOutputStream()
            System.setOut(PrintStream(outContent))

            CoffeeMachine.makeCoffee()

            System.setOut(System.out)
            assertTrue(outContent.toString().contains("¡Espera! La máquina ya está haciendo café."))
            assertTrue(CoffeeMachine.currentState is MakingCoffee)

        }

        @Test
        fun testSirviendoConLecheNoPermiteMasLeche() {
            CoffeeMachine.currentState = CoffeeMachineState.SirviendoconLeche(false)
            val outContent = ByteArrayOutputStream()
            System.setOut(PrintStream(outContent))

            CoffeeMachine.makeCoffee()

            System.setOut(System.out)
            assertTrue(outContent.toString().contains("Exception: No puedes añadir más leche"))
            assertTrue(CoffeeMachine.currentState is CoffeeMachineState.Error)
        }
        @Test
        fun testSirviendoConAzucarNoPermiteMasAzucar() {
            CoffeeMachine.currentState = CoffeeMachineState.SirviendoconAzucar(false)
            val outContent = ByteArrayOutputStream()
            System.setOut(PrintStream(outContent))

            CoffeeMachine.makeCoffee()

            System.setOut(System.out)
            assertTrue(outContent.toString().contains("Exception: No puedes añadir más azúcar"))
            assertTrue(CoffeeMachine.currentState is CoffeeMachineState.Error)
        }

        @Test
        fun testHaceCafeDesdeIdle() {
            CoffeeMachine.currentState = Idle
            val outContent = ByteArrayOutputStream()
            System.setOut(PrintStream(outContent))

            CoffeeMachine.makeCoffee()

            System.setOut(System.out)
            assertTrue(outContent.toString().contains("¡Café listo! Estado: ServingCoffee(brand=Capuccino)"))
            assertTrue(CoffeeMachine.currentState is ServingCoffee)
        }
    }

