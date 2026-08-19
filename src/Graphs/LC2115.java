package Graphs;

import java.util.*;

public class LC2115 {
    public static void main(String[] args) {
        
    }

    static class Edge{
        String src;
        String dest;
        Edge(String src, String dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {


        Map<String,Integer> inDegree = new HashMap<>();
        for (String recipe : recipes) {
            inDegree.put(recipe, 0);
        }

        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < recipes.length; i++){

            String rece = recipes[i];
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                String ingre = ingredients.get(i).get(j);

                if(!graph.containsKey(ingre)){
                    graph.put(ingre,new ArrayList<>());
                }
                List<String> list = graph.get(ingre);
                list.add(rece);
                graph.put(ingre,list);
                ///  because list is a reference
                // or -> graph.get(ingre).add(rece);

                inDegree.put(rece,inDegree.getOrDefault(rece,0)+1);
            }
        }

        Queue<String> q = new LinkedList<>();


        for(String in : supplies){
            q.add(in);
        }

        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()){

            String curr = q.poll();

            if (!graph.containsKey(curr)) continue;

            for (String recep : graph.get(curr)){
                inDegree.put(recep,inDegree.get(recep)-1);
                if(inDegree.get(recep)==0){
                    q.add(recep);
                    ans.add(recep);
                }
            }


        }




        return ans;


    }
}
