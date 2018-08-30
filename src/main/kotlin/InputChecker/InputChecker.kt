package InputChecker

import Pegs.ColouredPeg
import Pegs.Peg

class InputChecker {
    val colours = listOf("Red", "Blue") // TODO: This should be in ruleset
    val codeLength = 4  // TODO: This should be in ruleset
    fun validateGuess(guess: String) : Boolean {
        val stripped = guess.replace(" ", "")
        return stripped.length == codeLength &&
                stripped.toUpperCase()
                        .split("")
                        .all { letter -> letter in colours.map { colour -> colour[0].toUpperCase() }.joinToString() }
    }

    fun parseUserInput(guess: String): List<Peg> {
        return guess.split("")
                .filter { it.isNotBlank() }
                .map { letter -> colours.first { it.startsWith(letter) } }
                .map { ColouredPeg(it) }
    }
}