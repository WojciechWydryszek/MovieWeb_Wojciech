package cat.uvic.teknos.m06.MovieWeb.domain.models;

public class Films {
    private static int id_film, id_gen;
    private static String name, director;

    public void SetDirector (String director){ this.director = director; }

    public String GetDirector () { return director; }

    public void SetId(int id) { this.id_film = id; }

    public static int GetId() { return id_film; }

    public void SetIdGen (int id_gen) { this.id_gen = id_gen; }

    public int GetIdGen () { return id_gen; }

    public void SetName(String name) { this.name = name; }

    public static String GetName() { return name; }
}
