package cat.uvic.teknos.m06.MovieWeb.domain.models.helper;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionControl { Connection getConnection() throws SQLException; }