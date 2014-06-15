package forcomp

import forcomp.Anagrams._

object forcompws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 

  val wrd =  "Test";System.out.println("""wrd  : String = """ + $show(wrd ));$skip(27); val res$0 = 
  
  wordOccurrences(wrd);System.out.println("""res0: forcomp.Anagrams.Occurrences = """ + $show(res$0));$skip(36); 
  
  val s = List("Hello","world");System.out.println("""s  : List[String] = """ + $show(s ));$skip(39); 
  
  val occ = sentenceOccurrences(s);System.out.println("""occ  : forcomp.Anagrams.Occurrences = """ + $show(occ ));$skip(98); 
      
           
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
combinations(test);System.out.println("""res1: List[forcomp.Anagrams.Occurrences] = """ + $show(res$1));$skip(337); 
                                             


                        
 def subtractt(x: Occurrences, y: Occurrences): Occurrences = {
    for {
        xs<-x
        zs=y.find(ws=>ws._1==xs._1) match {  case None => (xs._1,0) case Some(tp) => tp}
        if(zs._2<xs._2)
    } yield (if (zs._2==0) xs else (xs._1,xs._2-zs._2))
  };System.out.println("""subtractt: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)forcomp.Anagrams.Occurrences""");$skip(78); 
                        
  val test1 = List(('a',3),('b',3),('c',4),('d',5));System.out.println("""test1  : List[(Char, Int)] = """ + $show(test1 ));$skip(42); 

  
  
  val v3 = subtractt(test1,test);System.out.println("""v3  : forcomp.Anagrams.Occurrences = """ + $show(v3 ));$skip(34); 
  
  val sent = List("Yes","man");System.out.println("""sent  : List[String] = """ + $show(sent ));$skip(90); 
  
  
  
  // sample code for generate anagrams
  val all_occ = sentenceOccurrences(sent);System.out.println("""all_occ  : forcomp.Anagrams.Occurrences = """ + $show(all_occ ));$skip(414); 
       
       

  def rec_sent_ana(occ: Occurrences): List[Sentence] = occ match {
    case List() => List(List())
		case ys::zs => {
			  for {
			        one_comb<-combinations(ys::zs)
			        words = dictionaryByOccurrences.getOrElse(one_comb, List())
			        one_word <- words
			        loc_sentence <- rec_sent_ana(subtract(occ,wordOccurrences(one_word)))
			  } yield one_word::loc_sentence
		}
  };System.out.println("""rec_sent_ana: (occ: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Sentence]""");$skip(263); 
  
 def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    for {
        xs<-x
        zs=y.find(ws=>ws._1==xs._1) match {  case None => (xs._1,0) case Some(tp) => tp}
        if(zs._2<xs._2)
    } yield (if (zs._2==0) xs else (xs._1,xs._2-zs._2))
  };System.out.println("""subtract: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)forcomp.Anagrams.Occurrences""");$skip(22); val res$2 = 
rec_sent_ana(all_occ);System.out.println("""res2: List[forcomp.Anagrams.Sentence] = """ + $show(res$2))}
  
  
  
}
