package minmax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphUtilsImpl implements GraphUtils{
	/*public String[] cities = { "CDMX", "Guadalajara", "Cd Juarez", "Tijuana", "Zapopan", "Monterrey"
			, "Chihuahua","Merida", "San Luis Potosi", "Aguascalientes", "Hermosillo", "Saltillo", "Mexicali",
			"Culiacan","Acapulco" };
	public Coordenada[] coordenadas= {new };*/
	public City[] cities= {new City("CDMX",555,570),new City("Guadalajara",440,520),new City("Cd Juarez",360,215),
			new City("Tijuana",90,180)
			,new City("Zapopan",390,540),new City("Monterrey",525,380),new City("Chihuahua",360,300),
			new City("Merida",830,515)
			,new City("San Luis Potosi",520,475),
			new City("Aguascalientes",400,400),new City("Hermosillo",220,255),new City("Saltillo",440,350),
			new City("Mexicali",110,215),new City("Culiacan",325,425),
			new City("Acapulco",525,600),};
	
	public String rutaCiudadesCsv="C:\\proyectos\\saul\\2023\\ciudadescsv.csv";
	@Override
	public Graph getGraph() {
		Graph graph = new Graph();
		// Agrega todas las ciudades al grafo
		int indCity = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") +
				"\\src\\files\\ciudadescsv.csv"))) {
			for (String line; (line = br.readLine()) != null;) {
				String[] distances = line.split(",");
				City city = cities[indCity];
				graph.addCity(city);
				
				city.setX(cities[indCity].getX());
				city.setY(cities[indCity].getY());
				for (int i = 0; i < cities.length; i++) {
					city.addDistance(cities[i].getName(), Integer.parseInt(distances[i]));
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
