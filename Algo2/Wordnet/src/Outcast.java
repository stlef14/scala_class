
public class Outcast {

	private WordNet mW = null;
	
	public Outcast(WordNet wordnet) {
		mW = wordnet;
	}
	public String outcast(String[] nouns) {
		BST<Integer,String> bst = new BST<Integer,String>();
		// go through each noun, skipping test to itself

		for(String noun:nouns) {
			int	   dist=0;
			for(String othernoun:nouns) {
				if(!noun.equalsIgnoreCase(othernoun)) {
					int dist1=mW.distance(noun,othernoun);
					dist += dist1;
				}
			}
			bst.put(dist, noun);
		}
		return bst.get(bst.max());
	}
	
	public static void main(String[] args) {
		WordNet wordnet = new WordNet(args[0], args[1]);
		Outcast outcast = new Outcast(wordnet);
		for (int t = 2; t < args.length; t++) {
			In in = new In(args[t]);
			String[] nouns = in.readAllStrings();
			StdOut.println(args[t] + ": " + outcast.outcast(nouns));
		}			   
	}

}
