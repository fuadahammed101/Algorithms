# BFS (Breadth-First Search) Java Project

This project implements the Breadth-First Search (BFS) algorithm on a graph represented by an adjacency matrix. The graph models cities as nodes, and edges represent connections between cities.

## Description

The program performs a BFS traversal starting from a specified source city and prints the order of traversal. It also finds and prints the shortest path from the source city to a destination city using BFS.

## Project Structure

- `BFSS.java` - Main Java file containing the BFS implementation and example usage.

## Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher recommended)
- Command line or terminal access

## How to Compile and Run

1. Navigate to the directory containing `BFSS.java`:

```bash
cd path/to/com/mycompany/bfss
```

2. Compile the Java file:

```bash
javac BFSS.java
```

3. Run the compiled program:

```bash
java com.mycompany.bfss.BFSS
```

## Example Output

```
BFS Traversal Order:
1 0 2 3 4 5 

Shortest Path from 1 to 5:
[1, 2, 5]
```

## How It Works

- The graph is represented as an adjacency matrix.
- The `createGraph` method initializes the graph with cities and edges.
- The `bfs` method performs a breadth-first traversal starting from the source city.
- The `getShortestPath` method reconstructs the shortest path from the source to the destination city using the parent map built during BFS.

## License

This project is for educational purposes.
