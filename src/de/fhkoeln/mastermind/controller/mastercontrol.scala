
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
	var supercode : Code = null
	var playground: Field = null
	var lastresponse: Response = null 
	var issolved: Boolean = false
	var gameover: Boolean = false
	if(maxtry <= 0) gameover = true
  def ini(newsize:Int): Unit =
  {
	codesize = newsize
    supercode = randcode
    playground = new Field(supercode) 
  }
	
	
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
	
	
	def randcode: Code = 
	{
	  var returndigits : List[Digit]= List()
	  var Randgen = new Random()
	  for(i<- 1 to codesize) returndigits=(alphabet(abs(Randgen.nextInt) % alphabet.length))::returndigits
	  
	  new Code(returndigits.toArray)
	}
	
	
	def autodefinemaxtry: Unit = maxtry = alphabet.length+codesize
	
	
	override def toString: String = 
	{
	
	  playground.toString
	  	  
	} 
	
	
}