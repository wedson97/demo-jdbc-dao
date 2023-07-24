package demojdbcdao;
import demojdbcdao.Dao.DaoFactory;
import demojdbcdao.Dao.SellerDao;
import java.util.Date;
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
        System.out.println("-------- teste 3 --------");
        List<Seller> listSellerAll = sellerdao.findAll();
        for(Seller i: listSellerAll){
            System.out.println(i);
        }
        System.out.println("-------- teste 4 --------");
        /*Seller sellerTeste = new Seller(null,"Greg","greg@gmail.com",new Date(), 4000.0, dep);
        sellerdao.Insert(sellerTeste);
        System.out.println(sellerTeste.getId());*/
        System.out.println("-------- teste 5 --------");
        seller = sellerdao.findById(1);
        seller.setName("Martha waine");
        sellerdao.Update(seller);
        listSellerAll = sellerdao.findAll();
        for(Seller i: listSellerAll){
            System.out.println(i);
        }
    }
}
