package Board

import Pegs.*
import Rules.*

/**
 * Implementation of Board interface - modelling a board in the game Mastermind
 */

class BoardImpl(val rules: RulesetInterface) : Board {

    private val colourPegs: ArrayList<List<Peg>>
    private val hintPegs: ArrayList<List<Peg>>
    private var move: Int = 0

    // new board is initialised with empty pegs
    init {
        val emptyPegs = buildEmptyList(listOf())
        colourPegs = buildList(listOf(emptyPegs))
        hintPegs = buildList(listOf(emptyPegs))
    }

    /**
     * function to update the board with the players guesses and the computers 'responses'
     * @param colourPegs - list of pegs representing the players move
     * @param hintPeg - list of pegs representing the computers response
     */
    override fun update(colourPegs: List<Peg>, hintPeg: List<Peg>){
        this.colourPegs[move] = colourPegs
        this.hintPegs[move] = hintPeg
        move++
    }

    /**
     * function to print the current state of the board
     */
    override fun print(){
        for(i in 0 until rules.totalNumberOfGuesses){
            printRow(colourPegs[i], hintPegs[i])
        }
    }

    /**
     * helper function for print
     */
    private fun printRow(colourPegs: List<Peg>, hintPegs: List<Peg>) {
        printColouredPegs(colourPegs)
        print(" | ")
        printHintPegs(hintPegs)
        println()

    }

    /**
     * helper function for printRow
     */
    private fun printColouredPegs(pegs: List<Peg>) {
        for (peg in pegs) {
            print("${peg.code} ")
        }
    }

    /**
     * helper function for printRow
     */
    private fun printHintPegs(pegs: List<Peg>) {
        for (peg in pegs) {
            print("${peg.colour} ")
        }
    }

    /**
     * recursive function to build a list of pegs
     * @param list - list containing one peg that you want built
     * @return List<Peg> - immutable list of size specified in RulessetImpl of the given type of peg
     */
    private fun buildEmptyList(list: List<Peg>): List<Peg>{
        return when{
            list.size < rules.codeLength -> buildEmptyList(list + listOf(EmptyPeg()))
            else -> list
        }
    }

    /**
     * recursive function to build a list of pegs
     * @param list - list of list of required peg type
     * @return - arraylist of list of the required peg type
     */
    private fun buildList(list: List<List<Peg>>): ArrayList<List<Peg>>{
        return when{
            list.size < rules.totalNumberOfGuesses -> buildList(list + list)
            else -> list as ArrayList<List<Peg>>
        }
    }
}