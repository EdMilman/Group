package Pegs

/**
 * peg implementation of a coloured peg - representing a guess made by a player
 */
data class ColouredPeg(override val colour: String) : Peg{
    override val code: Char
        get() = colour[0].toUpperCase()

}