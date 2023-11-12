/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.rutas;

import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<String, Integer> distances;

    public City(String name) {
        this.name = name;
        this.distances = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addDistance(String city, int distance) {
        distances.put(city, distance);
    }

    public int getDistanceTo(String city) {
        return distances.getOrDefault(city, -1);
    }

	public Map<String, Integer> getDistances() {
		return distances;
	}
    
}
