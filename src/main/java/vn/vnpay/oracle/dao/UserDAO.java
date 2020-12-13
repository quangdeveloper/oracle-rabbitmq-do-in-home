package vn.vnpay.oracle.dao;

import java.sql.SQLException;
import java.util.Map;

public interface UserDAO {

    Map getList(Map inParams) throws SQLException, CloneNotSupportedException ;
}
