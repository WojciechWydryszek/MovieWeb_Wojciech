package cat.uvic.teknos.m06.MovieWeb.domain.models;

public class Actor {
    private static int id_actor;
    private static String name_actor;

    public static int GetId() { return id_actor; }

    public void SetId(int id_actor) { this.id_actor = id_actor; }

    public static String GetName() { return name_actor; }

    public void SetName(String name_actor) { this.name_actor = name_actor; }
}
