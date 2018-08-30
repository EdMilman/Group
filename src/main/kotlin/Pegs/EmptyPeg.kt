package Pegs

/**
 * peg implementation of an 'empty' peg - used to fill the board at the start of the game
 */
class EmptyPeg: Peg{
    override val colour: String
        get() = "."
    override val code: Char
        get() = '.'

}