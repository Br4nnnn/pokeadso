package Modelos;

public class ObtenerPokemon {
    private String nombre;
    private int hp;
    private int ataque;
    private int defensa;
    private int velocidad;
    private String tipo;
    private String sprite;

    public ObtenerPokemon(String nombre, int hp, int ataque, int defensa, int velocidad, String tipo, String sprite) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
        this.sprite = sprite;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public int getVelocidad() { return velocidad; }
    public void setVelocidad(int velocidad) { this.velocidad = velocidad; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getSprite() { return sprite; }
    public void setSprite(String sprite) { this.sprite = sprite; }
}