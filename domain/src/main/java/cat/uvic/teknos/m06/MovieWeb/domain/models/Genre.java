package cat.uvic.teknos.m06.MovieWeb.domain.models;

import java.util.List;

public class Genre extends Films {
    private static int id_gen;
    private static String name;

    public static int GetId_gen() { return id_gen; }


    public void SetId_gen(int id_gen) { this.id_gen = id_gen; }

    public static String GetNameInsert() { return name; }

    public static String GetNameUpdate() { return name; }

    public void SetDescioption(String name) { this.name = name; }
}
