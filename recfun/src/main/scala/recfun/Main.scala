package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    
    println("count change")
    println("num ways:"+countChange(6,List(1,2)));
    
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    if ( c == 0 || r == c)
      1
    else 
      pascal(c-1,r-1)+pascal(c,r-1)
  }
    
  
  def testbalance(test:String) = {
    println ("test string=",test)
    println ("balance=",balance(test.toList))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def counted_balance(count: Int,chars: List[Char]): Boolean = {
      /* characters passed by default */
      if(chars.isEmpty)
        if(count!=0)
          false
        else
          true  
      else {
        if(count < 0)
          false
        else {
	        if(chars.head=='(')
	          counted_balance(count+1,chars.tail)
	        else
	          if(chars.head==')')
	            counted_balance(count-1,chars.tail)
	          else
	            counted_balance(count,chars.tail)
        }
      }
    }
    
    counted_balance(0,chars)

  }
  
  

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
     
	  if(coins.isEmpty || money < 0)
	    0
	  else {
	    if(money == 0)
	      1
	    else
	      countChange(money-coins.head,coins)+countChange(money,coins.tail)
	  }
	      
  }
  
  
}
