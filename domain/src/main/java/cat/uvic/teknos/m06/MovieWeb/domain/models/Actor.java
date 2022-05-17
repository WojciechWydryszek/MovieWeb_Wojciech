package cat.uvic.teknos.m06.MovieWeb.domain.models;

public class Actor {
    private static int id_actor;
    private static String name_actor;

    public int GetId_actor() { return id_actor; }

    public void SetId_actor(int id_actor) { this.id_actor = id_actor; }

    public String GetName_actor() { return name_actor; }

    public void SetName_actor(String name_actor) { this.name_actor = name_actor; }
}
