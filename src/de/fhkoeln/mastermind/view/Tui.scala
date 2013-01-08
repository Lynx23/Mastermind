
package de.fhkoeln.mastermind.view
import de.fhkoeln.mastermind.controller._
import de.fhkoeln.mastermind.model._

/**
 * Textual User Interface for Mastermind
 * is able to pars user input in Codes
 * @author ti619
 *
 */
class Tui (master: mastercontrol) 
{
  
  val rule_alphabet : Array[Digit] = master.alphabet
  
  //#Prepare#
  def prepare : Unit ={
  //welcome-screen
    println("==============================================")
    println("       M  A  S  T  E  R     M  I  N  D")
    println("==============================================")
    println()
  //user can configure the gamerules
    println("Code länge (0 = default):")
  }
  def userprepare(input:String){
    var size = input.toInt
    if(size<=0)
      size=4	//default value
    master.ini(size)
    master.autodefinemaxtry;
    
  }
  //#Game#
  def game : Unit = {
    
  //show the playground
    	println("-------------------------------------------------")

    	println(master.toString)
    	println(" - - - - - - - - - - - - - - - - - - - - - - - - ")
    	println("Zeichen [" + new Code(rule_alphabet).toString + "]");
    	println("Verbeliebende Versuche: " + master.maxtry)
    	println("-------------------------------------------------")
    	println("Ihr Vorschlag ("+master.codesize+" Zeichen) :")
  }
   //User input
  def gameuserinput(input: String) : Unit = {
    var userinput = pars(input.toUpperCase.toList)
    var usertry = new Code(userinput)
    //Check inputsize
    if(master.codesize != usertry.size) {println("FEHLER Kombination muss " + master.codesize + " Zeichen haben" )}
    
    else
    master.solvetry(usertry)
  
  //check if code solved
    if(master.issolved)
    {
      Tui.space
      win
    }
    else if(master.gameover == true) //gameover? -> LOOSE
    { 
      Tui.space
      loose
    }
  }
  
  //#WIN#
  /**
   * Prints the "winning" screen
   */
  def win : Unit = {
    println("!!!!GEWONNEN!!!!")
    }
  
  //#LOOSE#
  /**
   * Prints the "loosing" screen
   */
  def loose : Unit = {
    println("Verloren :(\n\nrichtige Lösung : " + master.supercode)
    }
  
  //Parser
  /**
   * pars a strings into Arrays of digits
   */
  def pars(input: List[Char]): Array[Digit] = 
  {
    Tui.pars(input)
  }
  
}


  /**
   * Is able to pars strings into Arrays of digits
   */
object Tui{
  def pars(input: List[Char]): Array[Digit] = 
  {
    var output : List[Digit] = List () 
    input match
    {
      case Nil => output = Nil
      case ' ' :: rest => output = pars(rest).toList
      case symbol :: Nil => output = List(new Digit(symbol.toString)) 
      case symbol :: rest => output = new Digit(symbol.toString) :: pars(rest).toList
     
      
      
      
    }
    output.toArray
  
  }
  /**
   * produce a 6 line space on the command window 
   */
  def space: Unit = println("\n\n\n\n\n\n")
}