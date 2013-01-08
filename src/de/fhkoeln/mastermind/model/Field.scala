package de.fhkoeln.mastermind.model

/**
 * creates a textual playground for Mastermind
 * 
 * 
 * */
class Field(val mastercode: Code)
{
 var trys: List[Code] = List()		//includes all code-trys
 var resps: List[Response] = List() //includes all responses of the code-trys
 
 /**
  * adds a try with a response to the Field
  * 
  */
 def addtry (newcode: Code, newrespons: Response) = {
   trys = newcode::trys
   resps = newrespons::resps
   }
 /**
  * returns the amount of trys on the field
  */
 def getsize : Int = trys.size
 
 /**
  * textual return of the playground
  */
 override def toString : String = {
   var returnstring = ""
   for(i <- 0 until getsize){
   
     returnstring = returnstring +trys(i).toString + " | "  + resps(i).toString +"\n" 
   }
   returnstring
 }
 
}