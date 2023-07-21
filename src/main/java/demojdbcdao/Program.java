package demojdbcdao;
import demojdbcdao.Dao.DaoFactory;
import demojdbcdao.Dao.SellerDao;
public class Program {

    public static void main(String[] args) {
        
        SellerDao sellerdao = DaoFactory.createSellerDao();
        
        Seller seller = sellerdao.findById(3);
        
        System.out.println(seller);
    }
}
