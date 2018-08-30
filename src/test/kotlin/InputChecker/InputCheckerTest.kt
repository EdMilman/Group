package InputChecker

import Pegs.ColouredPeg
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InputCheckerTest {

    private val check = InputChecker()

    @Test
    fun validateGuess() {
        assertTrue(check.validateGuess("RBRB"))
        assertFalse(check.validateGuess("RBRX"))
        assertFalse(check.validateGuess("RB"))
    }

    @Test
    fun parseUserInput() {
        assertEquals(listOf(ColouredPeg("Red")), check.parseUserInput("R"))
        assertEquals(listOf(ColouredPeg("Blue")), check.parseUserInput("B"))
        assertEquals(listOf(ColouredPeg("Blue"), ColouredPeg("Red")), check.parseUserInput("BR"))
    }
}