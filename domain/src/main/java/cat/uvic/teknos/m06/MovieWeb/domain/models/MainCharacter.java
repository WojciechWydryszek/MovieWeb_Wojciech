package cat.uvic.teknos.m06.MovieWeb.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MainCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static int id;
    private static Film idFilm;
    private static String name;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MainCharacter.id = id;
    }

    public static Film getIdFilm() {
        return idFilm;
    }

    public static void setIdFilm(Film idFilms) {
        MainCharacter.idFilm = idFilms;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MainCharacter.name = name;
    }
}
