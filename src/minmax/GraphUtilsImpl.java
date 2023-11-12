package minmax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import mapa.rutas.City;
import mapa.rutas.Graph;

public class GraphUtilsImpl implements GraphUtils{
	public String[] cities = { "CDMX", "Guadalajara", "Cd Juarez", "Tijuana", "Zapopan", "Monterrey"
			, "Chihuahua","Merida", "San Luis Potosi", "Aguascalientes", "Hermosillo", "Saltillo", "Mexicali",
			"Culiacan","Acapulco" };
	public String rutaCiudadesCsv="C:\\proyectos\\saul\\2023\\ciudadescsv.csv";
	@Override
	public Graph getGraph() {
		Graph graph = new Graph();
		// Agrega todas las ciudades al grafo
		int indCity = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(rutaCiudadesCsv))) {
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


		return graph;

	}

}
