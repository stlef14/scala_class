package patmat

import patmat.Huffman._


object patmatws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(119); 

	val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t1  : patmat.Huffman.Fork = """ + $show(t1 ));$skip(100); 
	val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9);System.out.println("""t2  : patmat.Huffman.Fork = """ + $show(t2 ));$skip(16); val res$0 = 
  
  weight(t1);System.out.println("""res0: Int = """ + $show(res$0));$skip(13); val res$1 = 
  weight(t2);System.out.println("""res1: Int = """ + $show(res$1));$skip(12); val res$2 = 
  chars(t2);System.out.println("""res2: List[Char] = """ + $show(res$2));$skip(55); 
 
  val exTree = makeCodeTree(Leaf('x',1),Leaf('a',2));System.out.println("""exTree  : patmat.Huffman.Fork = """ + $show(exTree ));$skip(19); val res$3 = 
  
  chars(exTree);System.out.println("""res3: List[Char] = """ + $show(res$3));$skip(39); val res$4 = 
  times(List('a','b','a','c','a','b'));System.out.println("""res4: List[(Char, Int)] = """ + $show(res$4));$skip(60); val res$5 = 
  makeOrderedLeafList(times(List('a','b','a','c','a','b')));System.out.println("""res5: List[patmat.Huffman.Leaf] = """ + $show(res$5));$skip(64); 
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4));System.out.println("""leaflist  : List[patmat.Huffman.Leaf] = """ + $show(leaflist ));$skip(65); 
  val leaflist2 = List(Leaf('g', 1), Leaf('h', 3), Leaf('i', 2));System.out.println("""leaflist2  : List[patmat.Huffman.Leaf] = """ + $show(leaflist2 ));$skip(30); 
  val cd1 = combine(leaflist);System.out.println("""cd1  : List[patmat.Huffman.CodeTree] = """ + $show(cd1 ));$skip(31); 
  val cd2 = combine(leaflist2);System.out.println("""cd2  : List[patmat.Huffman.CodeTree] = """ + $show(cd2 ));$skip(24); 
  val cd3 = cd1 ::: cd2;System.out.println("""cd3  : List[patmat.Huffman.CodeTree] = """ + $show(cd3 ));$skip(44); 
  
  val l4 = until(singleton,combine)(cd3);System.out.println("""l4  : List[patmat.Huffman.CodeTree] = """ + $show(l4 ));$skip(68); 
         
  val tr1 = createCodeTree(List('a','b','a','c','a','b'));System.out.println("""tr1  : patmat.Huffman.CodeTree = """ + $show(tr1 ));$skip(16); val res$6 = 
  decodedSecret;System.out.println("""res6: List[Char] = """ + $show(res$6));$skip(59); 
  val l=encode(frenchCode)(string2Chars("huffmanestcool"));System.out.println("""l  : List[patmat.Huffman.Bit] = """ + $show(l ));$skip(19); val res$7 = 
  l.equals(secret);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(34); 
  
  val ct = convert(frenchCode);System.out.println("""ct  : patmat.Huffman.CodeTable = """ + $show(ct ));$skip(32); 
      
  val ct2 = convert(tr1);System.out.println("""ct2  : patmat.Huffman.CodeTable = """ + $show(ct2 ));$skip(50); 
  val tr2 = createCodeTree(List('d','e','d','f'));System.out.println("""tr2  : patmat.Huffman.CodeTree = """ + $show(tr2 ));$skip(25); 
  val ct3 = convert(tr2);System.out.println("""ct3  : patmat.Huffman.CodeTable = """ + $show(ct3 ));$skip(40); 
  
  val mct = mergeCodeTables(ct2,ct3);System.out.println("""mct  : patmat.Huffman.CodeTable = """ + $show(mct ));$skip(64); 
  val m=quickEncode(frenchCode)(string2Chars("huffmanestcool"));System.out.println("""m  : List[patmat.Huffman.Bit] = """ + $show(m ));$skip(20); val res$8 = 
  codeBits(ct)('h');System.out.println("""res8: List[patmat.Huffman.Bit] = """ + $show(res$8));$skip(19); val res$9 = 
  m.equals(secret);System.out.println("""res9: Boolean = """ + $show(res$9))}
  
}
