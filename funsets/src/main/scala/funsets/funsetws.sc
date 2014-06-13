package funsets
import FunSets._

object funsetws {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  

  val s1 = singletonSet(2)                        //> s1  : Int => Boolean = <function1>
  val s2 = singletonSet(3)                        //> s2  : Int => Boolean = <function1>
  val s3 = singletonSet(10)                       //> s3  : Int => Boolean = <function1>
  
  val s4 = union(s1,s2)                           //> s4  : Int => Boolean = <function1>
  val s5 = union(s3,s4)                           //> s5  : Int => Boolean = <function1>
  
  printSet(s5)                                    //> {2,3,10}
  
  def evennumber(x: Int) : Boolean = {
      (x%2 == 0)
  }                                               //> evennumber: (x: Int)Boolean
  
  def creaset(): Set = {
  
    def myiter(a: Int): Set = {
      if(a>50) a => false
      else union(singletonSet(a),myiter(a+1))
    }
    
    myiter(1)
  }                                               //> creaset: ()Int => Boolean
 	 
  val s6 = creaset()                              //> s6  : Int => Boolean = <function1>
  printSet(s6)                                    //> {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,
                                                  //| 29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50}
                  
  val s7 = filter(s6,evennumber)                  //> s7  : Int => Boolean = <function1>
  printSet(s7)                                    //> {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50}
  forall(s7,evennumber)                           //> res0: Boolean = true
 
  def specificnumber(x: Int): Boolean = {
     (x==16)
  }                                               //> specificnumber: (x: Int)Boolean
  
  forall(s7,specificnumber)                       //> res1: Boolean = false
  exists(s7,specificnumber)                       //> res2: Boolean = true
   
  def specificnumber2(x: Int): Boolean = {
     (x==17)
  }                                               //> specificnumber2: (x: Int)Boolean
  forall(s7,specificnumber2)                      //> res3: Boolean = false
  exists(s7,specificnumber2)                      //> res4: Boolean = false
  
  def divideme(x: Int): Int = {
     x/2
  }                                               //> divideme: (x: Int)Int
  val s8 = map(s7, divideme)                      //> s8  : Int => Boolean = <function1>
  printSet(s8)                                    //> {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}
  
}