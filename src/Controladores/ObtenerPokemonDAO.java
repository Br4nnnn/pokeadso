package Controladores;

import Modelos.ObtenerPokemon;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class ObtenerPokemonDAO {
    private final Random random = new Random();

    public ObtenerPokemon obtenerPokemonAleatorio() {
        try {
            // Generar ID aleatorio entre 1 y 151 (primera generación)
            int id = random.nextInt(151) + 1;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + id))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject json = new JSONObject(response.body());

                // Obtener datos básicos
                String nombre = json.getString("name");
                String tipo = json.getJSONArray("types").getJSONObject(0)
                        .getJSONObject("type").getString("name");
                String sprite = json.getJSONObject("sprites").getString("front_default");

                // Obtener stats base y añadir variación aleatoria
                JSONObject stats = json.getJSONArray("stats").getJSONObject(0);
                int hp = stats.getInt("base_stat") + random.nextInt(50);
                int ataque = stats.getInt("base_stat") + random.nextInt(30);
                int defensa = stats.getInt("base_stat") + random.nextInt(30);
                int velocidad = stats.getInt("base_stat") + random.nextInt(20);

                return new ObtenerPokemon(nombre, hp, ataque, defensa, velocidad, tipo, sprite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String simularBatalla(ObtenerPokemon pokemon1, ObtenerPokemon pokemon2) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("¡Comienza el combate entre ").append(pokemon1.getNombre())
                .append(" y ").append(pokemon2.getNombre()).append("!\n\n");

        // Determinar quién ataca primero basado en velocidad
        ObtenerPokemon primero = pokemon1.getVelocidad() >= pokemon2.getVelocidad() ? pokemon1 : pokemon2;
        ObtenerPokemon segundo = primero == pokemon1 ? pokemon2 : pokemon1;

        int hp1 = primero.getHp();
        int hp2 = segundo.getHp();

        while (hp1 > 0 && hp2 > 0) {
            // Ataque del primer Pokémon
            int daño1 = Math.max(1, primero.getAtaque() - segundo.getDefensa() / 2);
            hp2 -= daño1;
            resultado.append(primero.getNombre()).append(" ataca y causa ")
                    .append(daño1).append(" de daño!\n");

            if (hp2 <= 0) {
                resultado.append("\n¡").append(primero.getNombre()).append(" es el ganador!");
                break;
            }

            // Ataque del segundo Pokémon
            int daño2 = Math.max(1, segundo.getAtaque() - primero.getDefensa() / 2);
            hp1 -= daño2;
            resultado.append(segundo.getNombre()).append(" ataca y causa ")
                    .append(daño2).append(" de daño!\n");

            if (hp1 <= 0) {
                resultado.append("\n¡").append(segundo.getNombre()).append(" es el ganador!");
                break;
            }
        }

        return resultado.toString();
    }
}