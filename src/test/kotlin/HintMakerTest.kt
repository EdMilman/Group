package HintMaker

import GameCode.HintMaker
import Pegs.ColouredPeg
import Pegs.HintPeg
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HintMakerTest {

    @Test
    fun testingHintMakerAllBlack(){
        var testHintMaker = HintMaker()

        var guessTest = listOf(ColouredPeg("Blue"), ColouredPeg("Blue"),
                ColouredPeg("Green"), ColouredPeg("Green"))

        var secretCodeTest = listOf(ColouredPeg("Blue"), ColouredPeg("Blue"),
                ColouredPeg("Green"), ColouredPeg("Green"))

        var resultTest = arrayListOf(HintPeg("Black"), HintPeg("Black"),
                HintPeg("Black"), HintPeg("Black"))

        assertEquals(testHintMaker.checkGuess(secretCodeTest, guessTest), resultTest)
    }
    @Test
    fun testingHintMakerAllWhite(){
        var testHintMaker = HintMaker()

        var guessTest = listOf(ColouredPeg("Green"), ColouredPeg("Green"),
                ColouredPeg("Blue"), ColouredPeg("Blue"))

        var secretCodeTest = listOf(ColouredPeg("Blue"), ColouredPeg("Blue"),
                ColouredPeg("Green"), ColouredPeg("Green"))

        var resultTest = arrayListOf(HintPeg("White"), HintPeg("White"),
                HintPeg("White"), HintPeg("White"))

        assertEquals(testHintMaker.checkGuess(secretCodeTest, guessTest), resultTest)
    }
    @Test
    fun testingHintMakerWhiteAndBlack(){
        var testHintMaker = HintMaker()

        var guessTest = listOf(ColouredPeg("Green"), ColouredPeg("Green"),
                ColouredPeg("Green"), ColouredPeg("Blue"))

        var secretCodeTest = listOf(ColouredPeg("Green"), ColouredPeg("Green"),
                ColouredPeg("Blue"), ColouredPeg("Green"))

        var resultTest = arrayListOf(HintPeg("Black"), HintPeg("Black"),
                HintPeg("White"), HintPeg("White"))

        assertEquals(testHintMaker.checkGuess(secretCodeTest, guessTest), resultTest)
    }

    @Test
    fun testingHintMakerNone(){
        var testHintMaker = HintMaker()

        var guessTest = listOf(ColouredPeg("Green"), ColouredPeg("Green")               )

        var secretCodeTest = listOf(ColouredPeg("Blue"), ColouredPeg("Blue"))

        var resultTest = arrayListOf<HintPeg>()

        assertEquals(testHintMaker.checkGuess(secretCodeTest, guessTest), resultTest)
    }





}
