package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Actor;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Film;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Film;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.MainCharacter;

import java.security.Key;
import java.util.List;

public interface FilmsRepository extends MovieWebRep {
    void Delete(Key id);

    void Save(Film film);
    List<Genre> GetFilmsByIdGen(Genre genre);
    List<Actor> GetFilmsByIdGen(Actor actor);
    List<Film> GetFilmsByIdGen(Film film);
    List<MainCharacter> GetFilmsByIdGen(MainCharacter mainCharacter);
}
