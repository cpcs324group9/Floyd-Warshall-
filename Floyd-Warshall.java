/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class AllPairShortestPath {

    static int INF = 99999, V = 10;//in INF initialize a large value to infinity.//in Vinitialize total vertices

    public static void main(String[] args) {
        int graph[][] = {{0, 10, INF, INF, INF, 5, INF, INF, INF, INF},//0, 10, 0, 0, 0, 5, 0, 0, 0, 0, 
        {INF, 0, 3, INF, 3, INF, INF, INF, INF, INF},//0, 0, 3, 0, 3, 0, 0, 0, 0, 0,
        {INF, INF, 0, 4, INF, INF, INF, 5, INF, INF},//0, 0, 0, 4, 0, 0, 0, 5, 0, 0, 
        {INF, INF, INF, 0, INF, INF, INF, INF, 4, INF},//0, 0, 0, 0, 0, 0, 0, 0, 4, 0,
        {INF, INF, 4, INF, 0, INF, 2, INF, INF, INF},//0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 
        {INF, 3, INF, INF, INF, 0, INF, INF, INF, 2},//0, 3, 0, 0, 0, 0, 0, 0, 0, 2,
        {INF, INF, INF, 7, INF, INF, 0, INF, INF, INF},//0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 
        {INF, INF, INF, 4, INF, INF, INF, 0, 3, INF},//0, 0, 0, 4, 0, 0, 0, 0, 3, 0, 
        {INF, INF, INF, INF, INF, INF, INF, INF, 0, INF},//0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        {INF, 6, INF, INF, INF, INF, 8, INF, INF, 0}//0, 6, 0, 0, 0, 0, 8, 0, 0, 0, 
        };

        int dist[][] = new int[V][V]; //initialize distances matrix
        int i, j, k;

//initialize distance matrix
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        //finding shortest paths
        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the
// above picked source
                for (j = 0; j < V; j++) {
                    // If vertex k is on the shortest path from
// i to j, then update the value of dist[i][j]    
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }

            printDistances(dist);
        }

        // Print the shortest distance matrix
        printDistances(dist);

    }
// Method to Print the shortest distance matrix
    static public void printDistances(int dist[][]) {
        System.out.println("\n\n\t----------------------------shortest distances matrix----------------------------\n");
        for (int i = 0; i < V; i++) {
            System.out.print("\t"+(char) ('A' + i));
        }
        System.out.println();
        for (int i = 0; i < V; ++i) {
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("∞\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
