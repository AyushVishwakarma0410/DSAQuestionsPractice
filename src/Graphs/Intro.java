package Graphs;



// Representation


// 4 types

//1. Adjacency List
//2. Adjacency Matrix
//3. Edge List
//4. 2D matrix(implicit graph)
public class Intro {


    // Adjacency list - 4 ways
    // 1. ArrayList<ArrayList>
    // 2. Array<ArrayList>
    // 3. HashMap<int,Lists>, int -> vertex, lists -> Lists



    // Adjacency Matrix -> takes more space o(v^2) > adjacency matrix
    // make a matrix, put vertices in both rows and columns, store 1 if edge exists between the given row
    // and column i.e. nodes are connected, if not then store zero


    // Edge list
    // Not used mostly but for important algorithms.
    // for questions like sorting edges
    // Also for MST
    // stored using ArrayList<Arraylist> (mostly)  form -> { src, dest, weight}


    // Implicit Graph
    // For questions which are not directly hinting towards graph
    // but can be assumed to be a graph
    // No need to create graph


}
