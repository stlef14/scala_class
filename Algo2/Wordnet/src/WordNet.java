import java.util.HashMap;



public class WordNet {
	
	  private Digraph  mGraph = null;
	  private HashMap<String,Bag<Integer>> mNounIdMap = new HashMap<String,Bag<Integer>>();
	  
	
	   // constructor takes the name of the two input files
	   public WordNet(String synsets, String hypernyms) 
	   					throws java.lang.NullPointerException, java.lang.IllegalArgumentException
	   {
		   if(null==synsets || null==hypernyms) throw new java.lang.NullPointerException();
		   
		   
		   String[] lines = (new In(synsets)).readAllLines();	
		   mGraph = new Digraph(lines.length);
		   
		   // Extract nouns
		   for(String aLine:lines) {
			   String[] tokens = aLine.split(",");
			   String[] allNouns = tokens[1].split(" ");
			   for(String oneNoun:allNouns) {
				   addNounMapping(oneNoun,Integer.parseInt(tokens[0]));
			   } 
		   }
		   
		   
		   // read in the mapping and create the graphs
		   lines = (new In(hypernyms)).readAllLines();

		   for(String oneLine:lines) {
			   String[] tokens = oneLine.split(",");
			   for(int index=1;index<tokens.length;index++) {
				   mGraph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[index]));
			   }
		   }
		   
		   // Is it rooted? Only if one element doesn't have edges
		   
		   if(isRooted(mGraph)==0) throw new java.lang.IllegalArgumentException("Digraph not rooted");
		   if(isRooted(mGraph)>1) throw new java.lang.IllegalArgumentException("Digraph has many roots");

		   
		   // is there a cycle
		   DirectedGraphCycle dgc = new DirectedGraphCycle(mGraph);
		   if(dgc.hasCycle()) throw new java.lang.IllegalArgumentException("Graph has cycle");
		   
	   }
	   
	   private void addNounMapping(String aNoun,Integer aId) {
		   Bag<Integer> idMapping = mNounIdMap.get(aNoun);
		   
		   if (null==idMapping) {
			   idMapping = new Bag<Integer>();
			   idMapping.add(aId);
			   mNounIdMap.put(aNoun, idMapping);
		   } else {
			   idMapping.add(aId);
		   }
		   
	   }
	   
	   private int isRooted(Digraph graph) {
		   int numRoot = 0;
		   for(int index=0;index<graph.V();index++) {
			   if(!graph.adj(index).iterator().hasNext()) {
				   numRoot++;
			   }
		   }
		  return numRoot;
	   }

	   // returns all WordNet nouns
	   public Iterable<String> nouns()
	   	   				throws java.lang.NullPointerException
	   {
		   //return mBST.keys();
		   return mNounIdMap.keySet();
	   }

	   // is the word a WordNet noun?
	   public boolean isNoun(String word)
						throws java.lang.NullPointerException
	   {
		   if(null==word) throw new java.lang.NullPointerException();
		   return (mNounIdMap.containsKey(word));
	   }

	   // distance between nounA and nounB (defined below)
	   public int distance(String nounA, String nounB) 
						throws java.lang.NullPointerException, java.lang.IllegalArgumentException
	   {
		   if(null==nounA || null==nounB) throw new java.lang.NullPointerException();
		   
		   SAP sap = new SAP(mGraph);
		   
		   //return sap.length(mBST.get(nounA), mBST.get(nounB));
		   return sap.length(mNounIdMap.get(nounA),mNounIdMap.get(nounB));
		   
	   }

	   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
	   // in a shortest ancestral path (defined below)
	   public String sap(String nounA, String nounB) 
						throws java.lang.NullPointerException, java.lang.IllegalArgumentException
	   {
		   if (null==nounA || null==nounB) throw new java.lang.NullPointerException();
		   
		   return null;
		   
	   }

	   // do unit testing of this class
	   public static void main(String[] args) {
		   
		   try {
			   String syn = args[0];
			   String hym = args[1];
			   
			   System.out.println("Testing wordnet with files: syn="+syn+" hym="+hym);
			   
			   WordNet wn = new WordNet(syn,hym);
			   
			   for(String oneNoun: wn.nouns()) {
				   System.out.println("Noun:"+oneNoun);
			   }
			   
			   System.out.println("group is a noun?"+wn.isNoun("group"));
		   } catch (NullPointerException ex) {}
		   catch (IllegalArgumentException ex) {}
		   
		   return;
		   
	   }
}
