/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minmax;

import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<String, Integer> distances;
    int x;
    int y;

    public City(String name,int x,int y) {
        this.name = name;
        this.distances = new HashMap<>();
        this.x=x;
        this.y=y;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
    
}
