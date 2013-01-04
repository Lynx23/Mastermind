/**
 *
 */
package de.fhkoeln.mastermind.controller
import de.fhkoeln.mastermind.model._
import scala.util.Random
import scala.Math._
/**
 * @author ti619
 *
 */
class mastercontrol(var maxtry: Int, alphabet: Array [Digit]) {
  var codesize: Int = 3
	var supercode : Code = null//randcode
	var playground: Field = null//new Field(supercode)
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
	
	override def toString: String = 
	{
	  playground.toString
	  	  
	} 
	
}