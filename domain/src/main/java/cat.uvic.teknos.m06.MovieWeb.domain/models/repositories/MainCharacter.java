package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

public class MainCharacter {
    private int idActor, idFilm;
    private String nameCharacter;

    public int getIdActor() { return idActor; }

    public void setIdActor(int idActor) { this.idActor = idActor; }

    public int getIdFilm() { return idFilm; }

    public void setIdFilm(int idFilm) { this.idFilm = idFilm; }

    public String getNameCharacter() { return nameCharacter; }

    public void setNameCharacter(String nameCharacter) { this.nameCharacter = nameCharacter; }
}
