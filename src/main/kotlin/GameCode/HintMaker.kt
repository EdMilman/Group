package GameCode

import Pegs.HintPeg
import Pegs.Peg

class HintMaker {
    fun checkGuess(secretCode: List<Peg>, guess: List<Peg>): List<Peg> {
        fun helper(secretCode: List<Peg>, guess: List<Peg>, white: List<Peg>, black: List<Peg>, index: Int): List<Peg> {
            return when (index) {
                guess.size -> return black + white
                else -> {
                    if (secretCode.contains(guess[index])) {
                        if (guess[index] == secretCode[index]) {
                            helper(secretCode, guess, white, black + HintPeg("Black"), index + 1)
                        } else {
                            helper(secretCode, guess, white + HintPeg("White"), black, index + 1)
                        }
                    } else {
                        helper(secretCode, guess, white, black, index + 1)
                    }
                }
            }
        }
        return helper(secretCode, guess, emptyList(), emptyList(), 0)
    }
}