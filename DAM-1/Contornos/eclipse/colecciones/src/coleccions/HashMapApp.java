package coleccions;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

	public static void main(String[] args) {

		//relacion de vendas por empresa
		//mapa cif -> valor
		Map<String, Integer> vendas = new HashMap<>();
		vendas.put("B123456", 18000);
		vendas.put("M123567", 20000);
		vendas.put("C123097", 31000);
		
		System.out.println("Relacion de empresas (cif)");
		for(String cif : vendas.keySet()) {
			System.out.println(cif);
		}
		
		Integer importeTotal = 0;
		
		System.out.println();
		System.out.println("Relacion vendas por empresa");
		for(String cif : vendas.keySet()) {
			System.out.println(cif + "facturado " + vendas.get(cif));
			importeTotal += vendas.get(cif).intValue();
		}
		
		System.out.println("Importe total : " + importeTotal);
	}

}