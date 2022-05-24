package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Actor;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Films;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.MainCharacter;

import java.util.List;

public interface FilmsRepository extends MovieWebRep {
    List<Genre> GetFilmsByIdGen(Genre genre);
    List<Actor> GetFilmsByIdGen(Actor actor);
    List<Films> GetFilmsByIdGen(Films films);
    List<MainCharacter> GetFilmsByIdGen(MainCharacter mainCharacter);
}
