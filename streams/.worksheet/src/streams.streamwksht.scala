package streams

import streams._
//import streams.StringParserTerrain

object streamwksht {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(163); 

val testvec = Vector(Vector('a','b'),Vector('c','d'),Vector('e','f'))


class spterrain extends StringParserTerrain {};System.out.println("""testvec  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(testvec ));$skip(77); 

val terr = new spterrain();System.out.println("""terr  : streams.streamwksht.spterrain = """ + $show(terr ));$skip(28); val res$0 = 

terr.findChar('c',testvec);System.out.println("""res0: streams.streamwksht.terr.Pos = """ + $show(res$0))}

}
