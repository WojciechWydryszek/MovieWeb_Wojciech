package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import java.util.List;

public interface MovieWebRep<Tmodel,Key>{
    void Delete(int id);
    void Save(Tmodel films);
    List<Tmodel> GetAll();
    Tmodel GetById(Integer id);
}
