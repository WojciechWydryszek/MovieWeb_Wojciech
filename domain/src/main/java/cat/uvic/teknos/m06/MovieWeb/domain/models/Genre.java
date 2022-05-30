package cat.uvic.teknos.m06.MovieWeb.domain.models;

import javax.persistence.*;

@Entity
public class Genre extends Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static int id;
    private static String name;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Genre.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Genre.name = name;
    }
}
