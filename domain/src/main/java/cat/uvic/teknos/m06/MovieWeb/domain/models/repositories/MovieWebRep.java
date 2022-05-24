package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.*;
import java.security.Key;
import java.util.*;

public interface MovieWebRep {
    void Delete(Key id);
    void Save(Films films);
}
