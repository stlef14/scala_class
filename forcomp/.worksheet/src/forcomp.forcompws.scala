package forcomp

import forcomp.Anagrams._

object forcompws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 

  val wrd =  "Test";System.out.println("""wrd  : String = """ + $show(wrd ));$skip(27); val res$0 = 
  
  wordOccurrences(wrd);System.out.println("""res0: forcomp.Anagrams.Occurrences = """ + $show(res$0));$skip(36); 
  
  val s = List("Hello","world");System.out.println("""s  : List[String] = """ + $show(s ));$skip(39); 
  
  val occ = sentenceOccurrences(s);System.out.println("""occ  : forcomp.Anagrams.Occurrences = """ + $show(occ ));$skip(155); 
                    
                                 
      
           
  //dictionary.groupBy(wordOccurrences)
 val test = List(('a', 2), ('c', 2));System.out.println("""test  : List[(Char, Int)] = """ + $show(test ));$skip(321); 
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
 
 };System.out.println("""combinations: (occ: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(54); val res$1 = 
            
 
// proc_occ(test)
combinations(test);System.out.println("""res1: List[forcomp.Anagrams.Occurrences] = """ + $show(res$1));$skip(129); 
                                             


                        
  val test1 = List(('a',3),('b',3),('c',4),('d',5));System.out.println("""test1  : List[(Char, Int)] = """ + $show(test1 ));$skip(37); 

  
  val sent = List("Yes","man");System.out.println("""sent  : List[String] = """ + $show(sent ));$skip(76); val res$2 = 
  
  
  
  // sample code for generate anagrams
  sentenceAnagrams(sent);System.out.println("""res2: List[forcomp.Anagrams.Sentence] = """ + $show(res$2))}
  
  
  
}
