
package demojdbcdao.Dao;

import demojdbcdao.Dao.Impl.SellerDaoJdbc;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJdbc(); 
    }
}
