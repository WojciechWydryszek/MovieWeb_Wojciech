package cat.uvic.teknos.m06.MovieWeb.domain.models;


import javax.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static int id;
    private static String name, director;
    @Transient
    private static Genre idGenre;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Film.id = id;
    }

    public static Object getIdGenre() {
        return idGenre;
    }

    public static void setIdGenre(Genre idGenre) {
        Film.idGenre = idGenre;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Film.name = name;
    }

    public static String getDirector() {
        return director;
    }

    public static void setDirector(String director) {
        Film.director = director;
    }
}
