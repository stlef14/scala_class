package forcomp

import forcomp.Anagrams._

object forcompws {

  val wrd =  "Test"                               //> wrd  : String = Test
  
  wordOccurrences(wrd)                            //> res0: forcomp.Anagrams.Occurrences = List((e,1), (s,1), (t,2))
  
  val s = List("Hello","world")                   //> s  : List[String] = List(Hello, world)
  
  val occ = sentenceOccurrences(s)                //> occ  : forcomp.Anagrams.Occurrences = List((d,1), (e,1), (h,1), (l,3), (o,2)
                                                  //| , (r,1), (w,1))
      
           
  //dictionary.groupBy(wordOccurrences)
 val test = List(('a', 2), ('b', 2))              //> test  : List[(Char, Int)] = List((a,2), (b,2))
 def proc_occ(occ: Occurrences) :List[Occurrences] = occ match {
  case Nil => List(List())
  case xs::ys => {
  									val l1 = (1 to xs._2).toList
  									val rec = proc_occ(ys)
  									rec:::(for {
  									     zs <- l1
  									     ws <- rec
  									} yield (xs._1,zs)::ws)
  							 }
 
 }                                                //> proc_occ: (occ: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrenc
                                                  //| es]
 
 proc_occ(test)                                   //> res1: List[forcomp.Anagrams.Occurrences] = List(List(), List((b,1)), List((b
                                                  //| ,2)), List((a,1)), List((a,1), (b,1)), List((a,1), (b,2)), List((a,2)), List
                                                  //| ((a,2), (b,1)), List((a,2), (b,2)))
           
}