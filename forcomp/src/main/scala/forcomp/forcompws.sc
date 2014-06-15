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
                                             


                        
 def subtractt(x: Occurrences, y: Occurrences): Occurrences = {
    for {
        xs<-x
        zs=y.find(ws=>ws._1==xs._1) match {  case None => (xs._1,0) case Some(tp) => tp}
        if(zs._2<xs._2)
    } yield (if (zs._2==0) xs else (xs._1,xs._2-zs._2))
  }                                               //> subtractt: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences
                                                  //| )forcomp.Anagrams.Occurrences
                        
  val test1 = List(('a',3),('b',3),('c',4),('d',5))
                                                  //> test1  : List[(Char, Int)] = List((a,3), (b,3), (c,4), (d,5))

  
  
  val v3 = subtractt(test1,test)                  //> v3  : forcomp.Anagrams.Occurrences = List((a,1), (b,3), (c,2), (d,5))
  
  val sent = List("Yes","man")                    //> sent  : List[String] = List(Yes, man)
  
  
  
  // sample code for generate anagrams
  val all_occ = sentenceOccurrences(sent)         //> all_occ  : forcomp.Anagrams.Occurrences = List((a,1), (e,1), (m,1), (n,1), 
                                                  //| (s,1), (y,1))
       
       

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
  }                                               //> rec_sent_ana: (occ: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Sent
                                                  //| ence]
  
 def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    for {
        xs<-x
        zs=y.find(ws=>ws._1==xs._1) match {  case None => (xs._1,0) case Some(tp) => tp}
        if(zs._2<xs._2)
    } yield (if (zs._2==0) xs else (xs._1,xs._2-zs._2))
  }                                               //> subtract: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences
                                                  //| )forcomp.Anagrams.Occurrences
rec_sent_ana(all_occ)                             //> res2: List[forcomp.Anagrams.Sentence] = List(List(my, en, as), List(my, as,
                                                  //|  en), List(my, sane), List(my, Sean), List(yes, man), List(en, my, as), Lis
                                                  //| t(en, as, my), List(men, say), List(as, my, en), List(as, en, my), List(say
                                                  //| , men), List(man, yes), List(sane, my), List(Sean, my))
  
  
  
}