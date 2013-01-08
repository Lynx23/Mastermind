package de.fhkoeln.mastermind
import de.fhkoeln.mastermind.controller._
import de.fhkoeln.mastermind.view._

object Mastermind {

  def main(args: Array[String]): Unit = 
  {
    //first ini
    var gamecontrol = new mastercontrol(3,Tui.pars("ABCDEF".toList))
    var textinterface = new Tui(gamecontrol)
    
    //configuration
    textinterface.prepare
    textinterface.userprepare(readLine)
    
    //game
    while(!gamecontrol.gameover){
    	textinterface.game
    	textinterface.gameuserinput(readLine)
    }
    
  }

}