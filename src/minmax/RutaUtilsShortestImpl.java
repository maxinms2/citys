package minmax;

import java.util.List;

public class RutaUtilsShortestImpl implements RutaUtils {

	@Override
	public boolean validaDistancia(int distancia, int currentDist, List<String> currents,String ciudad) {
		return  currentDist<= distancia && !currents.contains(ciudad);
	}

}
