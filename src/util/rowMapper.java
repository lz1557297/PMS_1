package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface rowMapper {
    Object mapRow(ResultSet rs) throws SQLException;
}
