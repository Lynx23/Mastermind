/**
 *
 */
package de.fhkoeln.mastermind.view
import de.fhkoeln.mastermind.controller._
import de.fhkoeln.mastermind.model._

/**
 * @author ti619
 *
 */
class Tui (master: mastercontrol) 
{
  var rule_codesize : Int = 3
  val rule_alphabet : Array[Digit] = Array(new Digit("A"))
  //#Prepare#
  def prepare : Unit ={
  //begrüßungsbildschirm
    println("==============================================")
    println("       M  A  S  T  E  R     M  I  N  D")
    println("==============================================")
    println()
  //Spielregeln einstellen
    println("Code länge:")
    rule_codesize = readLine.toInt
    master.codesize=rule_codesize
    
  }
  //#Game#
  def game : Unit = {
  //Spielfeld ausgeben
    println("-------------------------------------------------")
    println(master.toString)
    println("-------------------------------------------------")
    
  //User eingabe
    println("Ihr Vorschlag ("+rule_codesize+" Zeichen) :")
    
  //Spielfeld ausgeben
  //Wenn gelöst -> WIN
  //Wenn nicht gelöst & maxtry >0 -> Game
  //sonst -> LOOSE
  }
  
  //#WIN#
  def win : Unit = {}
  
  //#LOOSE#
  def loose : Unit = {}
  
  //Parser
  def pars(input: List[Char]): Array[Digit] = 
  {
    var output : List[Digit] = List () 
    input match
    {
      case null => output = null
      case ' ' :: rest => output = pars(rest).toList
      case symbol :: Nil => output = List(new Digit(symbol.toString)) 
      case symbol :: rest => output = new Digit(symbol.toString) :: pars(rest).toList
      case _ =>output = null
      
      
      
    }
    if(output != null)
    output.toArray
    else null
  }
  
}