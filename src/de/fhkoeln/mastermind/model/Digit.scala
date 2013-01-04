/**
 *
 */
package de.fhkoeln.mastermind.model

/**
 * @author Owl Mirror
 * A simple "Digit" that you can combine to a "Code"
 */
class Digit(Value: String) {
	override def toString(): String = Value
}