package demojdbcdao;
import demojdbcdao.Dao.DaoFactory;
import demojdbcdao.Dao.Impl.SellerDaoJdbc;
import demojdbcdao.Dao.SellerDao;
import java.util.List;
public class Program {

    public static void main(String[] args) {
        
        SellerDao sellerdao = DaoFactory.createSellerDao();
        
        Seller seller = sellerdao.findById(3);
        System.out.println("-------- teste 1 --------");
        System.out.println(seller);
        System.out.println("-------- teste 2 --------");
        Department dep = new Department("teste",2);
        List<Seller> listSeller = sellerdao.findByDepartment(dep);
        for(Seller i: listSeller){
            System.out.println(i);
        }
    }
}
