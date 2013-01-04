package de.fhkoeln.mastermind.model


import org.specs2.mutable._


class ResponseTest extends SpecificationWithJUnit {
  
  "A new Response with nothing in" should {
    //Testinitiallisierungen

    
    //Tests
    "have nothing" in {
       val resp0 = new Response()
    	resp0.FullFit must be_==(0)
    	resp0.ColorFit === 0
    }
    
    "can count" in {
       val resp0 = new Response()
      resp0.inc_Full
      resp0.FullFit === 1
      resp0.inc_Full
      resp0.FullFit === 2
      
      resp0.inc_Color
      resp0.ColorFit === 1
      resp0.inc_Color
      resp0.ColorFit === 2
    }
    
    "produce a string" in {
     val resp0 = new Response()
      resp0.inc_Full
      resp0.inc_Color
      resp0.inc_Color
      resp0.toString === "#1 +2"
     
    }  
  }  
}