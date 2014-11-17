
public class DirectedGraphCycle {

  private boolean[]    mMarked;
  private boolean[]    mOnStack;
  private boolean    mHasCycle;
  
  public DirectedGraphCycle( Digraph graph ) {
    mMarked = new boolean[graph.V()];
    mOnStack = new boolean[graph.V()];
    mHasCycle = false;

    // initialize all nodes to false
    for(int index=0;index<graph.V();index++) {
      mMarked[index] = mOnStack[index] = false;
    }
    for(int index=0;index<graph.V();index++) {
      if(!mMarked[index]) {
        dfs(graph,index);
      }
    }
  }

	private void dfs(Digraph graph, int v) {

        if (mHasCycle) {
			return;
		}
		
		mMarked[v] = mOnStack[v] = true;
		
		// go through all vertices
		for(Integer integ:graph.adj(v)) {
			if(mOnStack[integ]) {
				mHasCycle = true;
				return;
			}
			if(mMarked[integ]) {
				mOnStack[v]=false;
				return;
			} else {
				dfs(graph,integ);
			}
		}
		
		mOnStack[v]=false;
	}
	
	public boolean hasCycle() {
		return mHasCycle;
	}
	
	public static void main(String[] args) {

	}

}
