package de.fhkoeln.mastermind.model

/**
 * creates a textual playground for Mastermind
 * 
 * 
 * */
class Field(val mastercode: Code)
{
 var trys: List[Code] = List()
 var resps: List[Response] = List()
 
 def addtry (newcode: Code, newrespons: Response) = {trys = newcode::trys; resps = newrespons::resps}
 def getsize : Int = trys.size
 
 override def toString : String = {
   var returnstring = ""
   for(i <- 0 until getsize){
   
     returnstring = returnstring +trys(i).toString + "| "  + resps(i).toString +"\n" 
   }
   returnstring
 }
 
}