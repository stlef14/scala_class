package objsets

import objsets._

object objsetsws {
  
  
  val ts1 = new NonEmpty(new Tweet("gogol1","check out that scala test",1), new Empty,new Empty)
                                                  //> ts1  : objsets.NonEmpty = {.User: gogol1
                                                  //| Text: check out that scala test [1].}
  
  val tw1 = new Tweet("gogol1","more about that topic",4)
                                                  //> tw1  : objsets.Tweet = User: gogol1
                                                  //| Text: more about that topic [4]
  val ts2 = ts1 incl tw1                          //> ts2  : objsets.TweetSet = {.User: gogol1
                                                  //| Text: check out that scala test [1]{.User: gogol1
                                                  //| Text: more about that topic [4].}}
  val ts3 = ts2 incl new Tweet("gogol2","some more tests to do",10)
                                                  //> ts3  : objsets.TweetSet = {.User: gogol1
                                                  //| Text: check out that scala test [1]{.User: gogol1
                                                  //| Text: more about that topic [4]{.User: gogol2
                                                  //| Text: some more tests to do [10].}}}
   println(ts3)                                   //> {.User: gogol1
                                                  //| Text: check out that scala test [1]{.User: gogol1
                                                  //| Text: more about that topic [4]{.User: gogol2
                                                  //| Text: some more tests to do [10].}}}
  
  val st1 = new NonEmpty(new Tweet("log1","more tests", 3), new Empty, new Empty)
                                                  //> st1  : objsets.NonEmpty = {.User: log1
                                                  //| Text: more tests [3].}
  val st2 = st1 incl new Tweet("log3","more and more tests",15)
                                                  //> st2  : objsets.TweetSet = {{.User: log3
                                                  //| Text: more and more tests [15].}User: log1
                                                  //| Text: more tests [3].}
  val st3 = st2 incl tw1                          //> st3  : objsets.TweetSet = {{{.User: gogol1
                                                  //| Text: more about that topic [4].}User: log3
                                                  //| Text: more and more tests [15].}User: log1
                                                  //| Text: more tests [3].}
  
  println(st3)                                    //> {{{.User: gogol1
                                                  //| Text: more about that topic [4].}User: log3
                                                  //| Text: more and more tests [15].}User: log1
                                                  //| Text: more tests [3].}
  
  val st4 = st3.union(ts3)                        //> st4  : objsets.TweetSet = {.User: gogol1
                                                  //| Text: check out that scala test [1]{.User: gogol1
                                                  //| Text: more about that topic [4]{{{.User: log3
                                                  //| Text: more and more tests [15].}User: log1
                                                  //| Text: more tests [3].}User: gogol2
                                                  //| Text: some more tests to do [10].}}}
  println (st4)                                   //> {.User: gogol1
                                                  //| Text: check out that scala test [1]{.User: gogol1
                                                  //| Text: more about that topic [4]{{{.User: log3
                                                  //| Text: more and more tests [15].}User: log1
                                                  //| Text: more tests [3].}User: gogol2
                                                  //| Text: some more tests to do [10].}}}
   val tw = st4.mostRetweeted                     //> tw  : objsets.Tweet = User: log3
                                                  //| Text: more and more tests [15]
   val ld = st4.descendingByRetweet               //> ld  : objsets.TweetList = objsets.Cons@5214cda3
   
   ld.foreach(tweet => println(tweet))            //> User: log3
                                                  //| Text: more and more tests [15]
                                                  //| User: gogol2
                                                  //| Text: some more tests to do [10]
                                                  //| User: gogol1
                                                  //| Text: more about that topic [4]
                                                  //| User: log1
                                                  //| Text: more tests [3]
                                                  //| User: gogol1
                                                  //| Text: check out that scala test [1]
                              
  GoogleVsApple.trending foreach println          //> User: gizmodo
                                                  //| Text: iPhone 5's brain dissected. Guess what, it's made by Samsung. http://t
                                                  //| .co/wSyjvpDc [321]
                                                  //| User: gizmodo
                                                  //| Text: Warning: Security bug can wipe out your Android phone just by visiting
                                                  //|  a web page-not only limited to Samsung http://t.co/0y6vnOKw [290]
                                                  //| User: mashable
                                                  //| Text: Our iPhones Are Depleting the Earth's Resources [INFOGRAPHIC] http://t
                                                  //| .co/XnTLqe0p [205]
                                                  //| User: gizmodo
                                                  //| Text: The weirdest thing people hate about the iPhone 5: http://t.co/GMwuRp8
                                                  //| D [202]
                                                  //| User: mashable
                                                  //| Text: iPad 4 Has Carbon Fiber Body, Flexible Display [REPORT] http://t.co/Df
                                                  //| t5VoXD via @tabtimes [198]
                                                  //| User: gizmodo
                                                  //| Text: The definitive comparison of iOS 5 Google Maps vs iOS 6 Apple Maps in 
                                                  //| one single image: http://t.co/fTwTfVMy [191]
                                                  //| User: mashable
                                                  //| Text: iOS 6 Users Complain About Wi-Fi, Connectivity Issues - http://t.co/io
                                                  //| gRstNn [180]
                                                  //| User: CNET
                                                  //| Text: RT @CNETNews: Apple "fell short" with iOS 6 ma
                                                  //| Output exceeds cutoff limit.
                              
}