package GameCode

import InputChecker.InputChecker
import Pegs.Peg

/**
 * abstract representation of MasterMind game
 */
abstract class GameAbstractImpl(private val showCode: Boolean) : Game {
    abstract var currentGuessParsed : ArrayList<Peg>
    abstract var theCode: List<Peg>
    abstract var IC: InputChecker
    abstract var HM: HintMaker
    abstract fun showCode(showTheCode : Boolean)
    abstract fun checkCode(currentGuess : ArrayList<Peg>): Boolean
    abstract fun printIntroText()
    abstract fun resetGame()
    abstract fun gameLoop()
}