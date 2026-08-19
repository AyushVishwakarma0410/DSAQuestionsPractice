//package Graphs.MST.DisjointSetUnion;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class LC721 {
//    public static void main(String[] args) {
//
//    }
//
//
//
//
//    List<String> parent;
//    List<String> size;
//
//
//    static class Edge{
//
//        int src;
//        int dest;
//
//        Edge(int src, int dest){
//            this.src = src;
//            this.dest = dest;
//        }
//
//    }
//
//    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
//
//
//        // email to name
//        Map<String,String > map = new HashMap<>();
//
//        // Graph
//        Map<String,List<String>> graph = new HashMap<>();
//
//        boolean foundEarly ;
//
//        for (List<String> account : accounts){
//
//            String owner = account.get(0);
//            graph.put(owner,new ArrayList<>());
//
//            foundEarly = false;
//            for (int i = 1; i < account.size() ; i++) {
//                String email = account.get(i);
//
//                // A check for email to mail
//                if(!map.containsKey(email)){
//                    map.put(email,owner);
//                }
//                else {
//                    foundEarly = true;
//                    String realOwner = map.get(email);
//                    for (String mail : graph.get(owner)){
//                        graph.get(realOwner).add(mail);
//                    }
//                    graph.get(realOwner).add(email);
//                }
//
//                if(!foundEarly)
//                    graph.get(owner).add(email);
//
//
//            }
//
//            if(foundEarly){
//                graph.remove(owner);
//            }
//
//        }
//
//
//
//
//    }
//
//}
