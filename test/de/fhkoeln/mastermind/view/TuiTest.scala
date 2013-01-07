/**
 *
 */
package de.fhkoeln.mastermind.view

import org.specs2.mutable.SpecificationWithJUnit
import de.fhkoeln.mastermind.model._
import de.fhkoeln.mastermind.controller._

/**
 * @author ti619
 *
 */
class TuiTest extends SpecificationWithJUnit 
{
	"A new tui with a generated code"should {
		 "give back a Array of Digits" in {         
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(6, alphabet)
		   var testtui: Tui = new Tui(gamemaster)
		   gamemaster.ini(3)
		   new Code(testtui.pars("A B B".toList)).cmp(new Code(Array(new Digit("A"),new Digit("B"),new Digit("C")))).FullFit===2
		   new Code(testtui.pars("A B B".toList)).cmp(new Code(Array(new Digit("A"),new Digit("B"),new Digit("C")))).ColorFit===1
		   
    }  
		 "can be solved" in {         
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(6, alphabet)
		   var testtui: Tui = new Tui(gamemaster)
		   gamemaster.ini(3)
		   testtui.gameuserinput(gamemaster.supercode.toString)
		   gamemaster.issolved === true
		   
		   
		   
    }  
		"can be lost" in {         
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(6, alphabet)
		   var testtui: Tui = new Tui(gamemaster)
		   gamemaster.ini(3)
		   while(gamemaster.maxtry>0)
		   testtui.gameuserinput("F F F")
		   gamemaster.issolved === false
		   gamemaster.gameover === true
		   
		   
		   
    }  
		"handle code with wrong size" in {         
		   val alphabet: Array [Digit] = Array(new Digit("A"),new Digit("B"),new Digit("C"),new Digit("D"),new Digit("E"))
		   var gamemaster = new mastercontrol(6, alphabet)
		   var testtui: Tui = new Tui(gamemaster)
		   gamemaster.ini(3)
		   var tmp = gamemaster.maxtry
		   testtui.gameuserinput("F F")
		   tmp === gamemaster.maxtry
		   gamemaster.issolved === false
		   gamemaster.gameover === false
		   
		   
		   
    }  
 }
}