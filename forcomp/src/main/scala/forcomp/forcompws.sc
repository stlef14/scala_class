package forcomp

import forcomp.Anagrams._

object forcompws {

  val wrd =  "Test"                               //> wrd  : String = Test
  
  wordOccurrences(wrd)                            //> res0: forcomp.Anagrams.Occurrences = List((e,1), (s,1), (t,2))
  
  val s = List("Hello","world")                   //> s  : List[String] = List(Hello, world)
  
  val occ = sentenceOccurrences(s)                //> occ  : forcomp.Anagrams.Occurrences = List((d,1), (e,1), (h,1), (l,3), (o,2)
                                                  //| , (r,1), (w,1))
                    
                                 
      
           
  //dictionary.groupBy(wordOccurrences)
 val test = List(('a', 2), ('c', 2))              //> test  : List[(Char, Int)] = List((a,2), (c,2))
 def combinations(occ: Occurrences) :List[Occurrences] = occ match {
  case Nil => List(List())
  case xs::ys => {
  									val l1 = (1 to xs._2).toList
  									val rec = combinations(ys)
  									rec:::(for {
  									     zs <- l1
  									     ws <- rec
  									} yield (xs._1,zs)::ws)
  							 }
 
 }                                                //> combinations: (occ: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occur
                                                  //| rences]
            
 
// proc_occ(test)
combinations(test)                                //> res1: List[forcomp.Anagrams.Occurrences] = List(List(), List((c,1)), List((c
                                                  //| ,2)), List((a,1)), List((a,1), (c,1)), List((a,1), (c,2)), List((a,2)), List
                                                  //| ((a,2), (c,1)), List((a,2), (c,2)))
                                             


                        
  val test1 = List(('a',3),('b',3),('c',4),('d',5))
                                                  //> test1  : List[(Char, Int)] = List((a,3), (b,3), (c,4), (d,5))

  
  val sent = List("Yes","man")                    //> sent  : List[String] = List(Yes, man)
  
  
  
  // sample code for generate anagrams
  sentenceAnagrams(sent)                          //> res2: List[forcomp.Anagrams.Sentence] = List(List(my, en, as), List(my, as, 
                                                  //| en), List(my, sane), List(my, Sean), List(yes, man), List(en, my, as), List(
                                                  //| en, as, my), List(men, say), List(as, my, en), List(as, en, my), List(say, m
                                                  //| en), List(man, yes), List(sane, my), List(Sean, my))
  
  
  
}