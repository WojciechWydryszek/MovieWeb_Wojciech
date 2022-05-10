package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

public class Films {
    private int id, id_gender;
    private String name, director;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getId_gender() { return id_gender; }

    public void setId_gender(int id_gender) { this.id_gender = id_gender; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }
}
