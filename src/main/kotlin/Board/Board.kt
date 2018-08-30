package Board

import Pegs.*

/**
 * interface for modelling a board in the game Mastermind
 */
interface Board {
    fun update(colourPegs: List<Peg>, hintPeg: List<Peg>)

    fun print()
}