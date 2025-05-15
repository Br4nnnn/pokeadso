package Modelo;

public class Pokemon
{
    int id_pokedex;
    String nombre;
    String tipo;
    int peso;
    int altura;
    String descripcion;
    int atk;
    int def;
    String foto;

    public Pokemon(int id_pokedex, String nombre, String tipo, int peso, int altura, String descripcion, int atk, int def, String foto) {
        this.id_pokedex = id_pokedex;
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.altura = altura;
        this.descripcion = descripcion;
        this.atk = atk;
        this.def = def;
        this.foto = foto;
    }

    public int getId_pokedex()
    {
        return id_pokedex;

    }
}
