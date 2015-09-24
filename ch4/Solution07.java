package ch4;

/**
 * Build Order
 * @author qxia
 *
 */
import java.util.*;
public class Solution07 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<Project> lists = new ArrayList();
    Project a = new Project("a");
    lists.add(a);
    Project b = new Project("b");
    lists.add(b);
    Project c = new Project("c");
    lists.add(c);
    Project d = new Project("d");
    lists.add(d);
    Project e = new Project("e");
    lists.add(e);
    Project f = new Project("f");
    lists.add(f);
    List<Dependency> dependencies = new ArrayList<Dependency>();
    dependencies.add(new Dependency(d,a));
    dependencies.add(new Dependency(b,f));
    dependencies.add(new Dependency(d,b));
    dependencies.add(new Dependency(a,f));
    dependencies.add(new Dependency(c,d));
  
    Solution07 sol = new Solution07();
    Project[] sequence = sol.findOrder(lists, dependencies);
    System.out.println("A possible sequence is:");
    for(Project p: sequence){
      System.out.print(p.name);
      System.out.print(" ");
    }
  }
  public Project[] findOrder(List<Project> lists, List<Dependency> dependencies) {
    int numCourses = lists.size();
        Map<Project, Integer> indegree = new HashMap<Project, Integer>();
        Map<Project, ArrayList<Project>> nextMap = new HashMap<Project, ArrayList<Project>>();
        for(int i=0; i<numCourses; i++){
          indegree.put(lists.get(i), 0);
            nextMap.put(lists.get(i), new ArrayList<Project>());
        }
        
        for(int i=0; i<dependencies.size(); i++){
            Dependency d = dependencies.get(i);
            indegree.put(d.p1, indegree.get(d.p1)+1);
            nextMap.get(d.p2).add(d.p1);
        }
        
        Queue<Project> queue = new LinkedList<Project>();
        for(int i=0; i<numCourses; i++){
            if(indegree.get(lists.get(i))==0){
                queue.add(lists.get(i));
            }
        }
        
        int count = 0;
        Project[] res = new Project[numCourses];
        
        while(!queue.isEmpty()){
            Project currProj = queue.poll();
            res[count] = currProj;
            count++;
            
            
            ArrayList<Project> nextPossibles = nextMap.get(currProj);
            for(int i=0; i<nextPossibles.size(); i++){
                Project nextProj = nextPossibles.get(i);
                indegree.put(nextProj, indegree.get(nextProj)-1);
                if(indegree.get(nextProj)==0){
                    queue.add(nextProj);
                }
            }
        }
        
        return count==numCourses? res:null;        
    }
  
  public static class Project {
    String name;

    public Project(String name) {
      this.name = name;
    }
    
  }
  
  public static class Dependency {
    Project p1;
    Project p2;
    public Dependency(Project p1, Project p2) {
      this.p1 = p1;
      this.p2 = p2;
    }
    
  }
}
