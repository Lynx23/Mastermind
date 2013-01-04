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
 }
}