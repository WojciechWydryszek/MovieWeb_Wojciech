package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Films;
import java.util.List;

public interface FilmsRepository extends MovieWebRep {
    List<Films> getByFilms(Integer id);
}
