package demojdbcdao.Dao;

import demojdbcdao.Seller;
import java.util.List;

public interface SellerDao {
    void Insert(Seller seller);
    void Update(Seller Seller);
    void DeleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
}
