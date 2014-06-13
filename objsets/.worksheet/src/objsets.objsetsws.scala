package objsets

import objsets._

object objsetsws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(158); 
  
  
  val ts1 = new NonEmpty(new Tweet("gogol1","check out that scala test",1), new Empty,new Empty);System.out.println("""ts1  : objsets.NonEmpty = """ + $show(ts1 ));$skip(61); 
  
  val tw1 = new Tweet("gogol1","more about that topic",4);System.out.println("""tw1  : objsets.Tweet = """ + $show(tw1 ));$skip(25); 
  val ts2 = ts1 incl tw1;System.out.println("""ts2  : objsets.TweetSet = """ + $show(ts2 ));$skip(68); 
  val ts3 = ts2 incl new Tweet("gogol2","some more tests to do",10);System.out.println("""ts3  : objsets.TweetSet = """ + $show(ts3 ));$skip(16); 
   println(ts3);$skip(85); 
  
  val st1 = new NonEmpty(new Tweet("log1","more tests", 3), new Empty, new Empty);System.out.println("""st1  : objsets.NonEmpty = """ + $show(st1 ));$skip(64); 
  val st2 = st1 incl new Tweet("log3","more and more tests",15);System.out.println("""st2  : objsets.TweetSet = """ + $show(st2 ));$skip(25); 
  val st3 = st2 incl tw1;System.out.println("""st3  : objsets.TweetSet = """ + $show(st3 ));$skip(18); 
  
  println(st3);$skip(30); 
  
  val st4 = st3.union(ts3);System.out.println("""st4  : objsets.TweetSet = """ + $show(st4 ));$skip(16); 
  println (st4);$skip(30); 
   val tw = st4.mostRetweeted;System.out.println("""tw  : objsets.Tweet = """ + $show(tw ));$skip(36); 
   val ld = st4.descendingByRetweet;System.out.println("""ld  : objsets.TweetList = """ + $show(ld ));$skip(43); 
   
   ld.foreach(tweet => println(tweet));$skip(72); 
                              
  GoogleVsApple.trending foreach println}
                              
}
