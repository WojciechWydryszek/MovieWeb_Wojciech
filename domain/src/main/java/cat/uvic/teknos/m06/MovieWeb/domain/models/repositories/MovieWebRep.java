package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.*;
import java.util.List;

public interface MovieWebRep<Tmodel,Key>{
    void Delete(Key id);
    void Delete(java.security.Key id);
    void Save(Genre films);
    List<Tmodel> GetAll();
    Tmodel GetById(Integer id);
}
