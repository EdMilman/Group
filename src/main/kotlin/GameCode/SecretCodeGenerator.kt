package GameCode

import Pegs.ColouredPeg
import Pegs.Peg
import Rules.RulesetInterface
import java.util.*

/**
 * class to hold a companion object to generate a random secret code for use in the game
 */
class SecretCodeGenerator{
    companion object {
        lateinit var generator: Random
        fun generateCode(rules: RulesetInterface, test: Boolean = false): List<Peg>{
            generator = if(test) Random(1) else Random()
            /**
             * recursive function to construct a list of random pegs of appropriate size taken from the Rulesset
             * @param list - list to which random coloured pegs will be added
             * @return list of random coloured pegs of the appropriate size
             */
            fun makeList(list: List<Peg>): List<Peg>{
                return when{
                    list.size < rules.codeLength -> makeList(list + listOf(ColouredPeg(rules.allColours[generator.nextInt(rules.allColours.size)])))
                    else -> list
                }
            }
            return makeList(listOf())
        }
    }
}