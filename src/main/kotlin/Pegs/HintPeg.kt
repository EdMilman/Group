package Pegs

/**
 * peg implementation for a hint peg - the peg used by the computer to give a response
 */
data class HintPeg(override val colour: String) : Peg {
    override val code: Char
        get() = colour[0].toUpperCase()
}