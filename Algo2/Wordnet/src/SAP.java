

/**
 * @author 
 *
 */
public class SAP {

	   private Digraph	mGraph = null;

	   
	   private static class Tuple {
		   public int  mAncestor;
		   public int  mDistance;
	   }
	   

	   
	   // constructor takes a digraph (not necessarily a DAG)
	   public SAP(Digraph G) throws java.lang.NullPointerException, java.lang.IndexOutOfBoundsException 
	   {
		   if(null==G) throw new java.lang.NullPointerException("Digraph argument to SAP is null");
		   mGraph = G;
		   
	   }
	   

	   // length of shortest ancestral path between v and w; -1 if no such path
	   public int length(int v, int w) throws java.lang.NullPointerException, java.lang.IndexOutOfBoundsException 
	   {
		   if(null==mGraph) throw new java.lang.NullPointerException("Null graph in SAP");
		   if ( (v<0 || v >= mGraph.V()) || (w<0 || w >= mGraph.V()) ) throw new java.lang.IndexOutOfBoundsException("index out of band");
		   
		   Bag<Integer> vBag = new Bag<Integer>();
		   Bag<Integer> wBag = new Bag<Integer>();
		   vBag.add(v);
		   wBag.add(w);
		   return getAncestors(vBag,wBag).mDistance;
	   }
	   


	   // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	   public int ancestor(int v, int w) throws java.lang.NullPointerException, java.lang.IndexOutOfBoundsException 
	   {

		   if(null==mGraph) throw new java.lang.NullPointerException("Null graph in SAP");
		   if ( (v<0 || v >= mGraph.V()) || (w<0 || w >= mGraph.V()) ) throw new java.lang.IndexOutOfBoundsException("index out of band");

		   
		   Bag<Integer> vBag = new Bag<Integer>();
		   Bag<Integer> wBag = new Bag<Integer>();
		   vBag.add(v);
		   wBag.add(w);
		   return getAncestors(vBag,wBag).mAncestor;
		   
	   }

	   // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	   public int length(Iterable<Integer> v, Iterable<Integer> w) throws java.lang.NullPointerException, java.lang.IndexOutOfBoundsException 
	   {
		   if(null==v || null==w) throw new java.lang.NullPointerException("null argument to lenght, v="+v+" w="+w);
		   
		   return getAncestors(v,w).mDistance;
	   }

	   // a common ancestor that participates in shortest ancestral path; -1 if no such path
	   public int ancestor(Iterable<Integer> v, Iterable<Integer> w) throws java.lang.NullPointerException, java.lang.IndexOutOfBoundsException 
	   {
		   if(null==v || null==w) throw new java.lang.NullPointerException("null argument to ancestor, v="+v+" w="+w);
		   
		   return getAncestors(v,w).mAncestor;
		   
	   }
	   
	   
	   
	   private Tuple getAncestors(Iterable<Integer> vSrc,Iterable<Integer> wSrc) {
		   
		   Tuple ancTuple = new Tuple();
		   ancTuple.mAncestor=-1;
		   ancTuple.mDistance=-1;
		   
		   // Use Breadth first
		   BreadthFirstDirectedPaths vBfs = new BreadthFirstDirectedPaths(mGraph,vSrc);
		   BreadthFirstDirectedPaths wBfs = new BreadthFirstDirectedPaths(mGraph,wSrc);
		   
		   // go through each node and check if they overlap
		   for(int index=0;index<mGraph.V();index++) {
			   if( vBfs.hasPathTo(index) && wBfs.hasPathTo(index) ) {
				   int localDist = vBfs.distTo(index)+wBfs.distTo(index);
				   if( localDist < ancTuple.mDistance || ancTuple.mDistance < 0) {
					   ancTuple.mDistance = localDist;
					   ancTuple.mAncestor = index;
				   }
			   }
		   }
		   
		   return ancTuple;
	   }
	   
	   
	   
	   // do unit testing of this class
	   public static void main(String[] args) 
	   {
		   
			   String graphdata = args[0];
	
	
			   Digraph mGraph = new Digraph(new In(graphdata));
			  		   
			   // read in the mapping and create the graphs
			   
			   SAP sap = null;
			   try {
				   sap=new SAP(mGraph);
			   } catch (NullPointerException ex) {}
			     catch (IndexOutOfBoundsException ex) {}
			   
			   
			    while (!StdIn.isEmpty()) {
			        int v = StdIn.readInt();
			        int w = StdIn.readInt();
			        try {
				        int length   = sap.length(v, w);
				        int ancestor = sap.ancestor(v, w);
				        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
			        } catch (NullPointerException ex) {}
				     catch (IndexOutOfBoundsException ex) {}
			    }

		   return;
	   }
	   


}
