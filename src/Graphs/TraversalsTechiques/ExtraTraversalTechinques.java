package Graphs.TraversalsTechiques;

import java.util.*;






public class ExtraTraversalTechinques {


    static class BidirectionalSearch {

        public static List<String> bidirectionalSearch(Map<String, List<String>> graph,
                                                       String start, String goal) {
            if (start.equals(goal)) {
                return Arrays.asList(start);
            }

            Queue<String> queueStart = new LinkedList<>();
            Queue<String> queueGoal = new LinkedList<>();

            Map<String, String> visitedStart = new HashMap<>();
            Map<String, String> visitedGoal = new HashMap<>();

            queueStart.add(start);
            queueGoal.add(goal);

            visitedStart.put(start, null);
            visitedGoal.put(goal, null);

            while (!queueStart.isEmpty() && !queueGoal.isEmpty()) {

                // Expand from start side
                List<String> path = bfsStep(graph, queueStart, visitedStart, visitedGoal);
                if (path != null) return path;

                // Expand from goal side
                path = bfsStep(graph, queueGoal, visitedGoal, visitedStart);
                if (path != null) return path;
            }

            return null; // No path found
        }

        private static List<String> bfsStep(Map<String, List<String>> graph,
                                            Queue<String> queue,
                                            Map<String, String> visitedThisSide,
                                            Map<String, String> visitedOtherSide) {

            String current = queue.poll();

            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {

                if (!visitedThisSide.containsKey(neighbor)) {
                    visitedThisSide.put(neighbor, current);
                    queue.add(neighbor);

                    // Meeting point found
                    if (visitedOtherSide.containsKey(neighbor)) {
                        return constructPath(neighbor, visitedThisSide, visitedOtherSide);
                    }
                }
            }
            return null;
        }

        private static List<String> constructPath(String meetingNode,
                                                  Map<String, String> visitedStart,
                                                  Map<String, String> visitedGoal) {

            List<String> pathStart = new ArrayList<>();
            String node = meetingNode;

            // Build path from start → meeting node
            while (node != null) {
                pathStart.add(node);
                node = visitedStart.get(node);
            }
            Collections.reverse(pathStart);

            // Build path from meeting node → goal
            List<String> pathGoal = new ArrayList<>();
            node = visitedGoal.get(meetingNode);

            while (node != null) {
                pathGoal.add(node);
                node = visitedGoal.get(node);
            }

            pathStart.addAll(pathGoal);
            return pathStart;
        }

        // Driver Code
        public static void main(String[] args) {

            Map<String, List<String>> graph = new HashMap<>();

            graph.put("A", Arrays.asList("B", "D"));
            graph.put("B", Arrays.asList("A", "C", "E"));
            graph.put("C", Arrays.asList("B"));
            graph.put("D", Arrays.asList("A"));
            graph.put("E", Arrays.asList("B"));

            String start = "A";
            String goal = "C";

            List<String> path = bidirectionalSearch(graph, start, goal);

            System.out.println("Path: " + path);
        }
    }
}
