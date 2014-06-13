package patmat

import patmat.Huffman._


object patmatws {

	val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
	val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
                                                  //> t2  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Leaf
                                                  //| (d,4),List(a, b, d),9)
  
  weight(t1)                                      //> res0: Int = 5
  weight(t2)                                      //> res1: Int = 9
  chars(t2)                                       //> res2: List[Char] = List(a, b, d)
 
  val exTree = makeCodeTree(Leaf('x',1),Leaf('a',2))
                                                  //> exTree  : patmat.Huffman.Fork = Fork(Leaf(x,1),Leaf(a,2),List(x, a),3)
  
  chars(exTree)                                   //> res3: List[Char] = List(x, a)
  times(List('a','b','a','c','a','b'))            //> res4: List[(Char, Int)] = List((b,2), (a,3), (c,1))
  makeOrderedLeafList(times(List('a','b','a','c','a','b')))
                                                  //> res5: List[patmat.Huffman.Leaf] = List(Leaf(c,1), Leaf(b,2), Leaf(a,3))
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
                                                  //> leaflist  : List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,4)
                                                  //| )
  val leaflist2 = List(Leaf('g', 1), Leaf('h', 3), Leaf('i', 2))
                                                  //> leaflist2  : List[patmat.Huffman.Leaf] = List(Leaf(g,1), Leaf(h,3), Leaf(i,2
                                                  //| ))
  val cd1 = combine(leaflist)                     //> cd1  : List[patmat.Huffman.CodeTree] = List(Fork(Leaf(e,1),Leaf(t,2),List(e,
                                                  //|  t),3), Leaf(x,4))
  val cd2 = combine(leaflist2)                    //> cd2  : List[patmat.Huffman.CodeTree] = List(Fork(Leaf(g,1),Leaf(h,3),List(g,
                                                  //|  h),4), Leaf(i,2))
  val cd3 = cd1 ::: cd2                           //> cd3  : List[patmat.Huffman.CodeTree] = List(Fork(Leaf(e,1),Leaf(t,2),List(e,
                                                  //|  t),3), Leaf(x,4), Fork(Leaf(g,1),Leaf(h,3),List(g, h),4), Leaf(i,2))
  
  val l4 = until(singleton,combine)(cd3)          //> l4  : List[patmat.Huffman.CodeTree] = List(Fork(Fork(Fork(Fork(Leaf(e,1),Lea
                                                  //| f(t,2),List(e, t),3),Leaf(x,4),List(e, t, x),7),Leaf(i,2),List(e, t, x, i),9
                                                  //| ),Fork(Leaf(g,1),Leaf(h,3),List(g, h),4),List(e, t, x, i, g, h),13))
         
  val tr1 = createCodeTree(List('a','b','a','c','a','b'))
                                                  //> tr1  : patmat.Huffman.CodeTree = Fork(Fork(Leaf(c,1),Leaf(b,2),List(c, b),3)
                                                  //| ,Leaf(a,3),List(c, b, a),6)
  decodedSecret                                   //> res6: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  val l=encode(frenchCode)(string2Chars("huffmanestcool"))
                                                  //> l  : List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 
                                                  //| 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0
                                                  //| , 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1)
  l.equals(secret)                                //> res7: Boolean = true
  
  val ct = convert(frenchCode)                    //> ct  : patmat.Huffman.CodeTable = List((s,List(0, 0, 0)), (d,List(0, 0, 1, 0)
                                                  //| ), (x,List(0, 0, 1, 1, 0, 0, 0)), (j,List(0, 0, 1, 1, 0, 0, 1)), (f,List(0, 
                                                  //| 0, 1, 1, 0, 1)), (z,List(0, 0, 1, 1, 1, 0, 0, 0, 0)), (k,List(0, 0, 1, 1, 1,
                                                  //|  0, 0, 0, 1, 0)), (w,List(0, 0, 1, 1, 1, 0, 0, 0, 1, 1)), (y,List(0, 0, 1, 1
                                                  //| , 1, 0, 0, 1)), (h,List(0, 0, 1, 1, 1, 0, 1)), (q,List(0, 0, 1, 1, 1, 1)), (
                                                  //| o,List(0, 1, 0, 0)), (l,List(0, 1, 0, 1)), (m,List(0, 1, 1, 0, 0)), (p,List(
                                                  //| 0, 1, 1, 0, 1)), (u,List(0, 1, 1, 1)), (r,List(1, 0, 0, 0)), (c,List(1, 0, 0
                                                  //| , 1, 0)), (v,List(1, 0, 0, 1, 1, 0)), (g,List(1, 0, 0, 1, 1, 1, 0)), (b,List
                                                  //| (1, 0, 0, 1, 1, 1, 1)), (n,List(1, 0, 1, 0)), (t,List(1, 0, 1, 1)), (e,List(
                                                  //| 1, 1, 0)), (i,List(1, 1, 1, 0)), (a,List(1, 1, 1, 1)))
      
  val ct2 = convert(tr1)                          //> ct2  : patmat.Huffman.CodeTable = List((c,List(0, 0)), (b,List(0, 1)), (a,Li
                                                  //| st(1)))
  val tr2 = createCodeTree(List('d','e','d','f')) //> tr2  : patmat.Huffman.CodeTree = Fork(Fork(Leaf(f,1),Leaf(e,1),List(f, e),2)
                                                  //| ,Leaf(d,2),List(f, e, d),4)
  val ct3 = convert(tr2)                          //> ct3  : patmat.Huffman.CodeTable = List((f,List(0, 0)), (e,List(0, 1)), (d,Li
                                                  //| st(1)))
  
  val mct = mergeCodeTables(ct2,ct3)              //> mct  : patmat.Huffman.CodeTable = List((c,List(0, 0, 0)), (b,List(0, 0, 1))
                                                  //| , (a,List(0, 1)), (f,List(1, 0, 0)), (e,List(1, 0, 1)), (d,List(1, 1)))
  val m=quickEncode(frenchCode)(string2Chars("huffmanestcool"))
                                                  //> m  : List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0,
                                                  //|  1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1,
                                                  //|  0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1)
                                                  //| 
  codeBits(ct)('h')                               //> res8: List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1)
  m.equals(secret)                                //> res9: Boolean = true
  
}