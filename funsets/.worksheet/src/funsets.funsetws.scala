package funsets
import FunSets._

object funsetws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 

  println("Welcome to the Scala worksheet");$skip(31); 
  

  val s1 = singletonSet(2);System.out.println("""s1  : Int => Boolean = """ + $show(s1 ));$skip(27); 
  val s2 = singletonSet(3);System.out.println("""s2  : Int => Boolean = """ + $show(s2 ));$skip(28); 
  val s3 = singletonSet(10);System.out.println("""s3  : Int => Boolean = """ + $show(s3 ));$skip(27); 
  
  val s4 = union(s1,s2);System.out.println("""s4  : Int => Boolean = """ + $show(s4 ));$skip(24); 
  val s5 = union(s3,s4);System.out.println("""s5  : Int => Boolean = """ + $show(s5 ));$skip(18); 
  
  printSet(s5);$skip(63); 
  
  def evennumber(x: Int) : Boolean = {
      (x%2 == 0)
  };System.out.println("""evennumber: (x: Int)Boolean""");$skip(164); 
  
  def creaset(): Set = {
  
    def myiter(a: Int): Set = {
      if(a>50) a => false
      else union(singletonSet(a),myiter(a+1))
    }
    
    myiter(1)
  };System.out.println("""creaset: ()Int => Boolean""");$skip(25); 
 	 
  val s6 = creaset();System.out.println("""s6  : Int => Boolean = """ + $show(s6 ));$skip(15); 
  printSet(s6);$skip(52); 
                  
  val s7 = filter(s6,evennumber);System.out.println("""s7  : Int => Boolean = """ + $show(s7 ));$skip(15); 
  printSet(s7);$skip(24); val res$0 = 
  forall(s7,evennumber);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(61); 
 
  def specificnumber(x: Int): Boolean = {
     (x==16)
  };System.out.println("""specificnumber: (x: Int)Boolean""");$skip(31); val res$1 = 
  
  forall(s7,specificnumber);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(28); val res$2 = 
  exists(s7,specificnumber);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(64); 
   
  def specificnumber2(x: Int): Boolean = {
     (x==17)
  };System.out.println("""specificnumber2: (x: Int)Boolean""");$skip(29); val res$3 = 
  forall(s7,specificnumber2);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(29); val res$4 = 
  exists(s7,specificnumber2);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(48); 
  
  def divideme(x: Int): Int = {
     x/2
  };System.out.println("""divideme: (x: Int)Int""");$skip(29); 
  val s8 = map(s7, divideme);System.out.println("""s8  : Int => Boolean = """ + $show(s8 ));$skip(15); 
  printSet(s8)}
  
}
