import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConversorMonedas {

    // URL de la API de tasas de cambio
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    public static void main(String[] args) {
        try {
            // 1. Consumo de la API
            String jsonResponse = obtenerDatosDesdeApi(API_URL);

            // 2. Análisis de la respuesta JSON
            Gson gson = new Gson();
            Map<String, Object> responseMap = gson.fromJson(jsonResponse, new TypeToken<Map<String, Object>>(){}.getType());
            Map<String, Double> rates = (Map<String, Double>) responseMap.get("rates");

            // 3. Filtro de monedas de interés
            String[] monedasInteres = {"USD", "MXN", "EUR", "COP", "ARS", "BRL"};

            System.out.println("Tasas de cambio respecto al USD:");
            for (String moneda : monedasInteres) {
                if (rates.containsKey(moneda)) {
                    System.out.printf("%s: %.2f\n", moneda, rates.get(moneda));
                }
            }

            // 4. Interacción con el usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIngresa la cantidad en USD que deseas convertir: ");
            double cantidad = scanner.nextDouble();

            System.out.print("Ingresa el código de la moneda destino (por ejemplo: MXN, EUR): ");
            String monedaDestino = scanner.next().toUpperCase();

            if (rates.containsKey(monedaDestino)) {
                double tasa = rates.get(monedaDestino);
                double convertido = cantidad * tasa;
                System.out.printf("%.2f USD equivale a %.2f %s\n", cantidad, convertido, monedaDestino);
            } else {
                System.out.println("Moneda no válida o no soportada.");
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    private static String obtenerDatosDesdeApi(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder response = new StringBuilder();
        String linea;

        while ((linea = reader.readLine()) != null) {
            response.append(linea);
        }

        reader.close();
        return response.toString();
    }
}
