package de.fhkoeln.mastermind.model


import org.specs2.mutable._


class CodeTest extends SpecificationWithJUnit {
  //Initiallisierung
  var onecode : Code = new Code(Array(new Digit("1")))
  var threecode : Code = new Code(Array(new Digit("3")))
  var threecode2 : Code = new Code(Array(new Digit("3")))
  var threecode3 : Code = new Code(Array(new Digit("1"), new Digit("2"), new Digit("3")))
  var codetoshort: Code = null
  def testini(): Unit = 
  {
    onecode = new Code(Array(new Digit("1")))
    threecode = new Code(Array(new Digit("3"), new Digit("2"), new Digit("3")))
    threecode2 = new Code(Array(new Digit("3"), new Digit("2"), new Digit("1")))
    threecode3 = new Code(Array(new Digit("1"), new Digit("2"), new Digit("3")))
    codetoshort = new Code(Array(new Digit("1"), new Digit("2")))
  }
  
  "A one-digit Code" should {
    "have a size of one" in {
      testini
      onecode.size === 1 
    }
  }

   "A three-digit Code" should {
    "have a size of three" in {
      testini
      threecode.size === 3 
    }
  }
   
  "A Comparison of the same onecode" should {
    "have a response of a FullFit = 1" in {
      testini
      var answer = onecode.cmp(onecode)
      answer.IsValid === true
      answer.FullFit === 1
      answer.ColorFit === 0 
    }
  } 
  
  "A Comparison of two different threecodes" should {
    "have a response of a FullFit = 2" in {
      testini
      var answer = threecode2.cmp(threecode)
      answer.IsValid === true
      answer.FullFit === 2
      answer.ColorFit === 0 
    }
  }
    
  "A Comparison of two different threecodes" should {
    "have a response of a FullFit = 1 and ColorFit = 2" in {
      testini
      var answer = threecode2.cmp(threecode3)
      answer.IsValid === true
      answer.FullFit === 1
      answer.ColorFit === 2 
    }
  } 
  
  "A Comparison codes of different length" should {
    "be uncomparable" in {
      testini
      var answer = threecode2.cmp(codetoshort)
      answer.IsValid === false
    }
  } 
}