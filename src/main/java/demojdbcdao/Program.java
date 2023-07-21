package demojdbcdao;
import java.util.Date;
public class Program {

    public static void main(String[] args) {
        Department department = new Department("Books",1);
        Seller seller = new Seller(2,"wedson","wedson@gmail.com",new Date(),3000.0,department);
        System.out.println(seller);
    }
}
