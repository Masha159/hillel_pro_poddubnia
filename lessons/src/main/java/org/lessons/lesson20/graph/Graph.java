package org.lessons.lesson20.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + graph +
                '}';
    }

    public void addVertex(int vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        if (graph.get(source) == null) {
            addVertex(source);
        }
        graph.get(source).add(destination);
    }

    public void removeVertex(int vertex) {
        graph.remove(vertex);
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().contains(vertex)) {
                entry.getValue().remove((Integer) vertex);
            }
        }
    }

    public void removeEdge(int source, int destination) {
        graph.get(source).remove((Integer) destination);
    }

    public boolean hasVertex(int vertex) {
        return (!(graph.get(vertex) == null));
    }

    public boolean hasEdge(int source, int destination) {
        return graph.get(source).contains(destination);
        }
    }

