package cat.uvic.teknos.m06.MovieWeb.domain.models;

public class MainCharacter {
    private static int id_actor, id_film;
    private static String name_ch;

    public static int GetId_actor() { return id_actor; }

    public void SetId_actor(int id_actor) { this.id_actor = id_actor; }

    public int GetId_film() { return id_film; }

    public void SetId_film(int id_film) { this.id_film = id_film; }

    public static String GetName_ch() { return name_ch; }

    public void SetName_ch(String name_ch) { this.name_ch = name_ch; }
}
