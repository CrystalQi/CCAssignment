
import java.util.*;
public class Solution01 {
	
	public static void main(String[] args) {
		// The graph is like 1->2->3 4, 1,2,3 are connected, while 4 is isolated
		DirectedGraphNode n1 = new DirectedGraphNode(1,new ArrayList<DirectedGraphNode>());
		DirectedGraphNode n2 = new DirectedGraphNode(2,new ArrayList<DirectedGraphNode>());
		n1.neighbors.add(n2);
		DirectedGraphNode n3 = new DirectedGraphNode(3,new ArrayList<DirectedGraphNode>());
		n2.neighbors.add(n3);
		DirectedGraphNode n4 = new DirectedGraphNode(4,new ArrayList<DirectedGraphNode>());
		
		System.out.println("Test if there's route between n1 and n3:"+check(n1, n3));
		System.out.println("Test if there's route between n1 and n4:"+check(n1, n4));
	}

	public static class DirectedGraphNode{
		int value;
		List<DirectedGraphNode> neighbors;
		public DirectedGraphNode(int value, List<DirectedGraphNode> neighbors) {
			this.value = value;
			this.neighbors = neighbors;
		}
	}
	
	public static Set<DirectedGraphNode> visited;
	public static boolean check(DirectedGraphNode n1, DirectedGraphNode n2){
		visited = new HashSet<DirectedGraphNode>();
		return isRouteExist(n1, n2);
	}
	public static boolean isRouteExist(DirectedGraphNode n1, DirectedGraphNode n2){
		for(int i=0; i<n1.neighbors.size(); i++){
			DirectedGraphNode node = n1.neighbors.get(i);
			if(visited.contains(node)){
				continue;
			}
			
			visited.add(node);
			if(node==n2){
				return true;
			}
			else if(isRouteExist(node, n2)){
				return true;
			}
		}
		
		return false;
	}
}
