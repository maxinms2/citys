/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.rutas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		Graph graph = createGraph();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese la ciudad de partida: ");
		String startCity = scanner.nextLine();
		System.out.print("Ingrese la ciudad de destino: ");
		String endCity = scanner.nextLine();

		startCity = "Cdmx";
		endCity = "Cdmx";

		List<String> shortestPath = findShortestPath(graph, startCity, endCity);
		int shortestDistance = calculateTotalDistance(graph, shortestPath);
		System.out.println("Ruta más corta: " + shortestPath);
		System.out.println("Distancia total: " + shortestDistance + " km");

		List<String> longestPath = findLongestPath(graph, startCity, endCity);
		int longestDistance = calculateTotalDistance(graph, longestPath);
		System.out.println("Ruta más larga: " + longestPath);
		System.out.println("Distancia total: " + longestDistance + " km");
	}

	private static Graph createGraph() {
		Graph graph = new Graph();

		// Agrega todas las ciudades al grafo
		String[] cities = { "Cdmx", "Guadalajara", "Cd Juarez", "Tijuana", "Zapopan", "Monterrey", "Chihuahua",
				"Merida", "San Luis Potosi", "Aguascalientes", "Hermosillo", "Saltillo", "Mexicali", "Culiacan",
				"Acapulco" };

		int indCity = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\proyectos\\saul\\2023\\ciudadescsv.csv"))) {
			for (String line; (line = br.readLine()) != null;) {
				String[] distances = line.split(",");
				graph.addCity(cities[indCity]);
				City city = graph.getCity(cities[indCity]);
				for (int i = 0; i < cities.length; i++) {
					city.addDistance(cities[i], Integer.parseInt(distances[i]));
				}
				indCity++;
			}
			// line is not visible here.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * for (String city : cities) {
		 * 
		 * graph.addCity(city);
		 * 
		 * }
		 */

		// Agrega todas las distancias al grafo
		// (asegúrate de agregar todas las distancias entre ciudades)

		return graph;
	}

//	private static List<String> findShortestPath(Graph graph, String start, String end) {
//		Map<String, Integer> distances = new HashMap<>();
//		Map<String, String> previousNodes = new HashMap<>();
//		PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
//
//		distances.put(start, 0);
//		queue.add(start);
//
//		while (!queue.isEmpty()) {
//			String current = queue.poll();
//
//			if (current.equals(end)) {
//				List<String> path = new ArrayList<>();
//				while (previousNodes.containsKey(current)) {
//					path.add(current);
//					current = previousNodes.get(current);
//				}
//				path.add(start);
//				Collections.reverse(path);
//				return path;
//			}
//
//			for (Map.Entry<String, Integer> neighbor : graph.getCity(current).getDistances().entrySet()) {
//				String next = neighbor.getKey();
//				int weight = neighbor.getValue();
//				int totalDistance = distances.get(current) + weight;
//
//				if (totalDistance < distances.getOrDefault(next, Integer.MAX_VALUE)) {
//					distances.put(next, totalDistance);
//					previousNodes.put(next, current);
//					queue.add(next);
//				}
//			}
//		}
//
//		return Collections.emptyList();
//	}

	private static List<String> findLongestPath(Graph graph, String start, String end) {
		List<String> currents = new ArrayList<>();
		List<String> ruta = new ArrayList();
		String current = "";

		boolean visitStart=true;
		while (!current.equals(end)) {
			if(visitStart) {
				current=start;
			}
			int maxDist = 0;
			for (Map.Entry<String, Integer> neighbor : graph.getCity(current).getDistances().entrySet()) {
				int distEnd=neighbor.getValue();
				if(neighbor.getKey().equals(end)) {
					distEnd=1;
				}
				if ( distEnd>= maxDist && !currents.contains(neighbor.getKey())) {

					current = neighbor.getKey();
					maxDist = neighbor.getValue();
				}
			}
			if (maxDist > 0) {
				if(visitStart) {
					ruta.add(start);
					visitStart=false;
				}
				ruta.add(current);				
				currents.add(current);
			}
		}

		return ruta;

	}

	private static List<String> findShortestPath(Graph graph, String start, String end) {
		List<String> currents = new ArrayList<>();
		List<String> ruta = new ArrayList();
		String current = "";

		boolean visitStart=true;
		while (!current.equals(end)) {
			if(visitStart) {
				current=start;
			}
			int maxDist = 1000;
			for (Map.Entry<String, Integer> neighbor : graph.getCity(current).getDistances().entrySet()) {
				int distEnd=neighbor.getValue();
				if(neighbor.getKey().equals(end)) {
					distEnd=1000;
				}
				if ( distEnd<= maxDist && !currents.contains(neighbor.getKey())) {

					current = neighbor.getKey();
					maxDist = neighbor.getValue();
				}
			}
			if (maxDist > 0) {
				if(visitStart) {
					ruta.add(start);
					visitStart=false;
				}
				ruta.add(current);				
				currents.add(current);
			}
		}

		return ruta;

	}

	private static int calculateTotalDistance(Graph graph, List<String> path) {
		int totalDistance = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			String currentCity = path.get(i);
			String nextCity = path.get(i + 1);
			totalDistance += graph.getCity(currentCity).getDistanceTo(nextCity);
		}
		return totalDistance;
	}
}