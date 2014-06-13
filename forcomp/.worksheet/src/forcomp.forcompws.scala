package forcomp

import forcomp.Anagrams._

object forcompws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 

  val wrd =  "Test";System.out.println("""wrd  : String = """ + $show(wrd ));$skip(27); val res$0 = 
  
  wordOccurrences(wrd);System.out.println("""res0: forcomp.Anagrams.Occurrences = """ + $show(res$0));$skip(35); 
  
  val s = List("Hello","world");System.out.println("""s  : List[String] = """ + $show(s ));$skip(38); 
  
  val occ = sentenceOccurrences(s);System.out.println("""occ  : forcomp.Anagrams.Occurrences = """ + $show(occ ));$skip(96); 
      
           
  //dictionary.groupBy(wordOccurrences)
 val test = List(('a', 2), ('b', 2));System.out.println("""test  : List[(Char, Int)] = """ + $show(test ));$skip(312); 
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
 
 };System.out.println("""proc_occ: (occ: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(18); val res$1 = 
 
 proc_occ(test);System.out.println("""res1: List[forcomp.Anagrams.Occurrences] = """ + $show(res$1))}
           
}
