package com.mycompany.bfss;
import java.util.*;

public class BFSS {

    private static int[][] adjacencyMatrix;
    private static List<String> cities;
    private static List<String> visitedCities;
    private static Map<String, String> parentMap;

    public static void main(String[] args) {
  
        createGraph();

        
        String sourceCity = "1";
        String destinationCity = "5";

        
        System.out.println("BFS Traversal Order:");
        bfs(sourceCity);

        
        List<String> shortestPath = getShortestPath(sourceCity, destinationCity);
        System.out.println("\nShortest Path from " + sourceCity + " to " + destinationCity + ":");
        System.out.println(shortestPath);
    }

    private static void createGraph() {
        
        cities = Arrays.asList("0", "1", "2", "3", "4", "5");
        int numCities = cities.size();

        
        adjacencyMatrix = new int[numCities][numCities];

        
        addEdge("0", "1");
        addEdge("0", "2");
        addEdge("0", "3");
        addEdge("0", "4");
        addEdge("1", "2");
        addEdge("2", "3");
        addEdge("2", "5");
        addEdge("3", "4");
        addEdge("3", "5");
        addEdge("4", "5");
    }

    private static void addEdge(String city1, String city2) {
        int index1 = cities.indexOf(city1);
        int index2 = cities.indexOf(city2);

        adjacencyMatrix[index1][index2] = 1;
        adjacencyMatrix[index2][index1] = 1;
    }

    private static void bfs(String sourceCity) {
        visitedCities = new ArrayList<>();
        parentMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(sourceCity);
        visitedCities.add(sourceCity);

        while (!queue.isEmpty()) {
            String currentCity = queue.poll();
            System.out.print(currentCity + " ");

            List<String> neighbors = getNeighbors(currentCity);
            for (String neighbor : neighbors) {
                if (!visitedCities.contains(neighbor)) {
                    visitedCities.add(neighbor);
                    queue.add(neighbor);
                    parentMap.put(neighbor, currentCity);
                }
            }
        }
    }

    private static List<String> getNeighbors(String city) {
        List<String> neighbors = new ArrayList<>();
        int cityIndex = cities.indexOf(city);

        for (int i = 0; i < adjacencyMatrix[cityIndex].length; i++) {
            if (adjacencyMatrix[cityIndex][i] == 1) {
                neighbors.add(cities.get(i));
            }
        }

        return neighbors;
    }

    private static List<String> getShortestPath(String sourceCity, String destinationCity) {
        List<String> path = new ArrayList<>();

        if (!visitedCities.contains(destinationCity)) {
            System.out.println("No path found from " + sourceCity + " to " + destinationCity);
            return path;
        }

        String currentCity = destinationCity;
        while (!currentCity.equals(sourceCity)) {
            path.add(currentCity);
            currentCity = parentMap.get(currentCity);
        }
        path.add(sourceCity);

        Collections.reverse(path);
        return path;
    }
}

