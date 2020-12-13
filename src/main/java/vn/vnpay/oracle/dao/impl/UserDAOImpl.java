package vn.vnpay.oracle.dao.impl;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import vn.vnpay.oracle.dao.UserDAO;

import java.sql.SQLException;
import java.util.Map;


@Component
public class UserDAOImpl extends BaseDAO implements UserDAO {
    @Override
    public Map getList(Map inParams) throws SQLException, CloneNotSupportedException {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName(PK_USER);
        Map<String, Object> map = simpleJdbcCall.withProcedureName("GET_ALL").execute();
        return map;
    }
}
//    Map<String, Object> out = simpleJdbcCall.execute(
//            new MapSqlParameterSource("order_by", by)
//                    .addValue("direction", direction)
//                    .addValue("limit_", size)
//                    .addValue("offset_", offset));
