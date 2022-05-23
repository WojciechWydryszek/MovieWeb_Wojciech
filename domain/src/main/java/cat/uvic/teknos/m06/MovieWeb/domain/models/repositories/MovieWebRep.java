package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.*;
import java.sql.Connection;
import java.util.*;

public interface MovieWebRep {
    String GetAll(Connection conn);
    String GetById(Connection conn, Integer id);
    List<Films> Update(Connection conn, Integer id);
    void Delete(Connection conn, Integer id);
    void Save();
}
