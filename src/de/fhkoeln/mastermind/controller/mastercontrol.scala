
package de.fhkoeln.mastermind.controller
import de.fhkoeln.mastermind.model._
import scala.util.Random
import scala.Math._
/**
 *manages the whole game//contains rules of the game
 *it generates the supercode and the maximum number of trys.  
 * 
 * @author ti619
 * */
class mastercontrol(var maxtry: Int, var alphabet: Array [Digit]) {
  var codesize: Int = 3
	var supercode : Code = null		//code which the player has to find out
	var playground: Field = null	//the playground
	var lastresponse: Response = null //saves the last response of the last user try
	var issolved: Boolean = false	//true = player wins
	var gameover: Boolean = false	//true = player looses
	
	if(maxtry <= 0) gameover = true //check the maxtrys
	
	/**
	 * Initials the controller with new values which might have been change
	 * HAS TO RUN AT LEAST ONCE! 
	 */
  def ini(newsize:Int): Unit =
  {
	codesize = newsize
    supercode = randcode
    playground = new Field(supercode) 
  }
	
	/**
	 * check the code of the user
	 * if an error occours the game would be lost
	 */
	def solvetry(newtry: Code): Unit = 
	{
	  lastresponse = newtry.cmp(supercode)
	  if (lastresponse.IsValid  == false) gameover = true
	  
	  if (lastresponse.FullFit == codesize)
	  { 
	    
	    issolved = true
	    gameover = true
	  } 
	
	  	  
	  playground.addtry(newtry, lastresponse)
	  
	  maxtry= maxtry - 1
	  if(maxtry == 0) gameover = true	
	}
	
	//generates a random code for this controller
	def randcode: Code = 
	{
	  var returndigits : List[Digit]= List()
	  var Randgen = new Random()
	  for(i<- 1 to codesize) returndigits=(alphabet(abs(Randgen.nextInt) % alphabet.length))::returndigits
	  
	  new Code(returndigits.toArray)
	}
	
	/**
	 * set maxtry to a proper value
	 */
	def autodefinemaxtry: Unit = maxtry = alphabet.length+codesize
	
	/**
	 * textual return of the playground
	 */
	override def toString: String = 
	{
	
	  playground.toString
	  	  
	} 
	
	
}