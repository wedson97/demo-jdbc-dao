
package demojdbcdao.Dao;

import demojdbcdao.Dao.Impl.SellerDaoJdbc;
import demojdbcdao.connections.ConnectionPostgreSQL;
import java.sql.Connection;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJdbc(new ConnectionPostgreSQL());
    }
}
