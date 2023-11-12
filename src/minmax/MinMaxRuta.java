package minmax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mapa.rutas.Graph;

public class MinMaxRuta {
	int distancia;
	int distIni;
	List<String> currents;
	List<String> ruta;
	private RutaUtils utils;
	
	public MinMaxRuta(String tipoRuta) {
		currents=new ArrayList<>();
		ruta=new ArrayList<>();
		if(tipoRuta.equals("short")) {
			distIni=Integer.MAX_VALUE;
			utils=new RutaUtilsShortestImpl();
		}else {
			distIni=0;
			utils=new RutaUtilsLongestImpl();
		}
	}
	public List<String> findtPath(Graph graph, String start, String end) {
		String current = "";

		boolean visitStart=true;
		while (!current.equals(end)) {
			if(visitStart) {
				current=start;
			}
			int distancia = distIni;
			for (Map.Entry<String, Integer> neighbor : graph.getCity(current).getDistances().entrySet()) {
				int currentDist=neighbor.getValue();
				if(neighbor.getKey().equals(end)) {
					currentDist=distIni;
				}
				if (utils.validaDistancia(distancia, currentDist, currents, neighbor.getKey())) {	

					current = neighbor.getKey();
					distancia = neighbor.getValue();
				}
			}
			if (distancia > 0) {
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
	
	

}
