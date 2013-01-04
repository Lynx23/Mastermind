/**
 *
 */
package de.fhkoeln.mastermind.model

/**
 * @author Owl Mirror
 *
 */
class Response {
  var FullFit: Int = 0 //Anzahl der komplett richtigen
  var ColorFit: Int = 0 //Anzahl der farblich richtigen (die aber NICHT an der richtigen Position sind)
  var IsValid : Boolean = true
  def inc_Full :Unit = FullFit+=1   //Erhöht die Anzahl der komplett Richtigen
  def inc_Color :Unit = ColorFit+=1	//Erhöht die Anzahl der farblich Richtigen
  
  override def toString : String = "#" + FullFit + " +" + ColorFit
}