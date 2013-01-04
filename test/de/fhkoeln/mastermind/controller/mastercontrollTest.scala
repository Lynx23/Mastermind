/**
 *
 */
package de.fhkoeln.mastermind.controller
import de.fhkoeln.mastermind.model._
import org.specs2.mutable.SpecificationWithJUnit

/**
 * @author ti619
 *
 */
class mastercontrollTest extends SpecificationWithJUnit 
{
  
	 "A new mastercontrol with proper values" should {
		 "be Unsolved and the game is not over" in {         
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(6,alphabet)
		   
		   gamemaster.ini(3)
		   gamemaster.issolved ===false
		   gamemaster.gameover ===false
		   
    }
  
		 "decrement maxtry by 1 for every try"in {		            
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(6,alphabet)
		   
		   gamemaster.ini(3)
		   gamemaster.solvetry(new Code(Array(new Digit("A"), new Digit("A"), new Digit("A"))))
		   gamemaster.maxtry === 5
    }
		 "be gameover if maxtry under zero"in {		            
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(2,alphabet)
		   
		   gamemaster.ini(3)
		   gamemaster.solvetry(new Code(Array(new Digit("A"), new Digit("A"), new Digit("A"))))
		   gamemaster.solvetry(new Code(Array(new Digit("A"), new Digit("A"), new Digit("C"))))
		   gamemaster.maxtry === 0 
		   gamemaster.gameover === true
		  	   
		   
    }
		 
		 "be solved if the right code is written before maxtry is reached"in {		         
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(2,alphabet)
		   
		   gamemaster.ini(5)
		   gamemaster.solvetry(gamemaster.supercode)
		   gamemaster.gameover === true
		   gamemaster.issolved === true	   
		   
		 }
  }
}