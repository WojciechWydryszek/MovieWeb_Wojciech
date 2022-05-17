package cat.uvic.teknos.m06.MovieWeb.domain.models;

import java.util.List;

public class Genre {
    private static int id_gen;
    private static List<String> description;

    public int GetId_gen() { return id_gen; }

    public void SetId_gen(int id_gen) { this.id_gen = id_gen; }

    public List<String> GetDescription() { return description; }

    public void SetDescription(List<String> description) { this.description = description; }
}
