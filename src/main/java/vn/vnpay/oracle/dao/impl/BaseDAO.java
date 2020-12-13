package vn.vnpay.oracle.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Map;

public class BaseDAO {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected DataSource dataSource;

    protected final String PK_USER = "PK_USER";


    protected void callProcedure(String pack, String func, Map map){}

    protected void callFunction(String pack, String func, Map map){}

}
