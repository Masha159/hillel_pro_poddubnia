package org.lessons.lesson20.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 1);

        System.out.println(graph);
        System.out.println("Чи є вершина 5: " + graph.hasVertex(5));
        System.out.println("Чи є вершина 3: " + graph.hasVertex(3));

        System.out.println("Чи існує ребро 1 -> 2 " + graph.hasEdge(1, 2));
        System.out.println("Чи існує ребро 2 -> 1 " + graph.hasEdge(2, 1));


    }

}
