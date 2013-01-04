/**
 *
 */
package de.fhkoeln.mastermind.model

/**
 * @author Owl Mirror
 *
 */
class Code (val Combination : Array[Digit]){
var size = Combination.length

/**
 * compare this Code with an other Code. Return the result as a Response-Object
 */
def cmp(Other:Code) : Response = {
		var Answer = new Response();
		if(size != Other.size) Answer.IsValid = false
		else for(i<-0 until size){
			if(Combination(i).toString == Other.Combination(i).toString) Answer.inc_Full
			else {for(j<-0 until size)
			if(Combination(i).toString == Other.Combination(j).toString) Answer.inc_Color}
		}
		Answer
}
override def toString : String = {
  var returnstring= ""
  for(i<-0 until size)
    returnstring = returnstring  + Combination(i).toString() + " "
  returnstring
  }
// BSP: var MyCode = new Code(Array(new Digit("A"),new Digit("A"),new Digit("C")))
}