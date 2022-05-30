package cat.uvic.teknos.m06.MovieWeb.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static int id;
    private static String name;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Actor.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Actor.name = name;
    }
}
