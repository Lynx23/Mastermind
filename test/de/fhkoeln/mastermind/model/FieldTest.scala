package de.fhkoeln.mastermind.model

import org.specs2.mutable.SpecificationWithJUnit

class FieldTest extends SpecificationWithJUnit 
{
 //Tests
	
  "A new Field with nothing in" should {
	"have a size of zero" in {
      var emptyfield = new Field(new Code(Array(new Digit("A"), new Digit("B"))))
       emptyfield.getsize===0       
    }
	
	
	"can be filled" in {
       var emptyfield = new Field(new Code(Array(new Digit("A"), new Digit("B"))))
       var mytry = new Code(Array(new Digit("A"), new Digit("B")))
       emptyfield.addtry(mytry, mytry.cmp(emptyfield.mastercode))
       emptyfield.getsize===1  
    }
    }
  
  "A Field with one try in" should{
    "give a String with the try and the response" in {
      var myfield = new Field(new Code(Array(new Digit("A"), new Digit("B"))))
      var mytry = new Code(Array(new Digit("A"), new Digit("B")))
      myfield.addtry(mytry, mytry.cmp(myfield.mastercode))
      myfield.toString must be_==("A B | #2 +0\n")
    }
  }
	
  "A Field with two try in" should{
    "give a String with two trys and two responses" in {
      var myfield = new Field(new Code(Array(new Digit("A"), new Digit("B"))))
      var mytry = new Code(Array(new Digit("A"), new Digit("B")))
      myfield.addtry(mytry, mytry.cmp(myfield.mastercode))
      var mytry1 = new Code(Array(new Digit("B"), new Digit("B")))
      myfield.addtry(mytry1, mytry1.cmp(myfield.mastercode))
      myfield.toString must be_==("B B | #1 +1\nA B | #2 +0\n")
     }
  }
}