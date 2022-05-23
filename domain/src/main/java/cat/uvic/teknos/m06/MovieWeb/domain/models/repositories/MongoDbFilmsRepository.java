package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Films;

import java.sql.Connection;
import java.util.List;

public class MongoDbFilmsRepository implements FilmsRepository {
    @Override
    public void Save() {

    }

    @Override
    public List<Films> Update(Connection conn, Integer id) {

        return null;
    }

    @Override
    public void Delete(Connection conn, Integer id) {

    }

    @Override
    public String GetById(Connection conn, Integer id) {
        return null;
    }


    @Override
    public String GetAll(Connection conn) {
        return null;
    }

    @Override
    public List<Films> getByFilms(Integer id) {
        return null;
    }
}
