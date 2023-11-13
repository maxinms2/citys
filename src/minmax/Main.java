package minmax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
	private GraphUtils graphUtils;
	private List<String> shortestPath;
	private List<String> longestPath;
	private int shortestDistance;
	private int longestDistance;
	private Graph graph;
	public Main() {
		this.graphUtils = new GraphUtilsImpl();
	}

	public static void main(String[] args) {
		Main main= new Main();
		main.getPhats("Cdmx","Cdmx");
	}
	
	public void getPhats(String startCity,String endCity) {
		graph = graphUtils.getGraph();

		/*Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese la ciudad de partida: ");
		String startCity = scanner.nextLine();
		System.out.print("Ingrese la ciudad de destino: ");
		String endCity = scanner.nextLine();

		startCity = "Cdmx";
		endCity = "Cdmx";*/
		MinMaxRuta minMaxRuta=new MinMaxRuta("short");
		shortestPath = minMaxRuta.findtPath(graph, startCity, endCity);
		shortestDistance = calculateTotalDistance(graph, shortestPath);
		System.out.println("Ruta más corta: " + shortestPath);
		System.out.println("Ciudades recorridasa: " + shortestPath.size());
		System.out.println("Distancia total: " + shortestDistance + " km");

		minMaxRuta=new MinMaxRuta("long");
		longestPath = minMaxRuta.findtPath(graph, startCity, endCity);
		longestDistance = calculateTotalDistance(graph, longestPath);
		System.out.println("Ruta más larga: " + longestPath);
		System.out.println("Ciudades recorridasa: " + longestPath.size());
		System.out.println("Distancia total: " + longestDistance + " km");
		
	}
	
	private int calculateTotalDistance(Graph graph, List<String> path) {
		int totalDistance = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			String currentCity = path.get(i);
			String nextCity = path.get(i + 1);
			totalDistance += graph.getCity(currentCity).getDistanceTo(nextCity);
		}
		return totalDistance;
	}

	public List<String> getShortestPath() {
		return shortestPath;
	}

	public List<String> getLongestPath() {
		return longestPath;
	}

	public int getShortestDistance() {
		return shortestDistance;
	}

	public int getLongestDistance() {
		return longestDistance;
	}

	public Graph getGraph() {
		return graph;
	}
	
	

}
