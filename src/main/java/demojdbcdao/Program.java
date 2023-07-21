package demojdbcdao;
import java.util.Date;
import demojdbcdao.Dao.DaoFactory;
import demojdbcdao.Dao.SellerDao;
public class Program {

    public static void main(String[] args) {
        
        Department department = new Department("Books",1);
        
        Seller seller = new Seller(2,"wedson","wedson@gmail.com",new Date(),3000.0,department);
        
        SellerDao sellerdao = DaoFactory.createSellerDao();
        
        System.out.println(seller);
    }
}
