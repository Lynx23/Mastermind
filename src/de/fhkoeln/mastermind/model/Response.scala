/**
 *
 */
package de.fhkoeln.mastermind.model

/**
 * result of a comparison of two codes
 * saves the amount of pins which have the correct color&correct place or just the correct color
 * @author Owl Mirror
 *
 */
class Response {
  var FullFit: Int = 0 //Amount of correct Digits
  var ColorFit: Int = 0 //Amount of color-correct Digits
  var IsValid : Boolean = true
  def inc_Full :Unit = FullFit+=1   
  def inc_Color :Unit = ColorFit+=1	
  
  override def toString : String = "#" + FullFit + " +" + ColorFit
}