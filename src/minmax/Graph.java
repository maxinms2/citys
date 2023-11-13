/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minmax;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, City> cities;

    public Graph() {
        this.cities = new HashMap<>();
    }

    public void addCity(String name) {
        cities.put(name, new City(name,0,0));
    }
    
    public void addCity(City city) {
        cities.put(city.getName(), city);
    }

    public void addDistance(String source, String destination, int distance) {
        cities.get(source).addDistance(destination, distance);
        cities.get(destination).addDistance(source, distance);
    }

    public City getCity(String name) {
        return cities.get(name);
    }

	public Map<String, City> getCities() {
		return cities;
	}
    
    
}
