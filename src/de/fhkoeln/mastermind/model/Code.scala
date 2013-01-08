/**
 *
 */
package de.fhkoeln.mastermind.model

/**
 * saves a combination of digits in an array with certain methods. 
 * This class includes methods to compare itself with another CODE with same length 
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
			else { 
			  var j = 0
			  var found = false 
			  while (j < size && !found){
				  
				  if(Combination(i).toString == Other.Combination(j).toString) {
				     Answer.inc_Color
				     found = true
				  }
				  j+=1
			  }
			}
		}
		Answer
}
/**
 * prints the value of the digits in a row, with a ' ' between every digit
 */
override def toString : String = {
  var returnstring= ""
  for(i<-0 until size)
    returnstring = returnstring  + Combination(i).toString() + " "
  returnstring.substring(0,returnstring.length()-1) //removing last " "
  }

}