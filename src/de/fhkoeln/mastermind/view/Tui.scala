
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
  //begrüßungsbildschirm
    println("==============================================")
    println("       M  A  S  T  E  R     M  I  N  D")
    println("==============================================")
    println()
  //Spielregeln einstellen
    println("Code länge:")
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
    
  //Spielfeld ausgeben
    	println("-------------------------------------------------")

    	println(master.toString)
    	println(" - - - - - - - - - - - - - - - - - - - - - - - - ")
    	println("Zeichen [" + new Code(rule_alphabet).toString + "]");
    	println("Verbeliebende Versuche: " + master.maxtry)
    	println("-------------------------------------------------")
    	println("Ihr Vorschlag ("+master.codesize+" Zeichen) :")
  }
   //User eingabe
  def gameuserinput(input: String) : Unit = {
    var userinput = pars(input.toUpperCase.toList)
    var usertry = new Code(userinput)
    //Eingabe prüfen
    	if(master.codesize != usertry.size) {println("FEHLER Kombination muss " + master.codesize + " Zeichen haben" )}
    
    else
    master.solvetry(usertry)
  
  //Wenn gelöst -> WIN
    if(master.issolved)
      win
    else if(master.gameover == true) //Spiel vorbei? -> LOOSE
      loose
  }
  
  //#WIN#
  def win : Unit = {println("!!!!GEWONNEN!!!!")}
  
  //#LOOSE#
  def loose : Unit = {println("Verloren :(\n\nrichtige Lösung : " + master.supercode)}
  
  //Parser
  def pars(input: List[Char]): Array[Digit] = 
  {
    Tui.pars(input)
  }
  
}
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
      //case _ =>output = null
      
      
      
    }
    //if(output != null)
    output.toArray
    //else null
  }
}