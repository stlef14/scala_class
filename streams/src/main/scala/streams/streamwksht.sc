package streams

import streams._
//import streams.StringParserTerrain

object streamwksht {

val testvec = Vector(Vector('a','b'),Vector('c','d'),Vector('e','f'))


class spterrain extends StringParserTerrain {}

val terr = new spterrain()

terr.findChar('c',testvec)

}