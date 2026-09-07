import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ThroneInheritance {
    private String kingName;
    private Map<String, List<String>> familyTree;
    private Set<String> deadPeople;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        this.familyTree = new HashMap<>();
        this.familyTree.put(kingName, new ArrayList<>());
        this.deadPeople = new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        familyTree.putIfAbsent(parentName, new ArrayList<>());
        familyTree.get(parentName).add(childName);
        familyTree.putIfAbsent(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        deadPeople.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(kingName, order);
        return order;
    }
    
    private void dfs(String current, List<String> order) {
        if (!deadPeople.contains(current)) {
            order.add(current);
        }
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}