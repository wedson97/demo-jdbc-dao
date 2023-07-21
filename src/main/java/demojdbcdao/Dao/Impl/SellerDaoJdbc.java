
package demojdbcdao.Dao.Impl;

import demojdbcdao.Dao.SellerDao;
import demojdbcdao.Department;
import demojdbcdao.Seller;
import demojdbcdao.connections.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJdbc implements SellerDao{
    
    private ConnectionPostgreSQL conn;
    
    public SellerDaoJdbc(ConnectionPostgreSQL conn){
        this.conn=conn;
    }
    
    @Override
    public void Insert(Seller seller) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update(Seller Seller) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DeleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conexao = null;
        try{
            conexao = conn.getConection();
            stmt = conexao.prepareStatement("SELECT seller.*,department.Name as DepName "+
                                         "FROM seller INNER JOIN department "+
                                         "ON seller.DepartmentId = department.Id "+
                                         "WHERE seller.Id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Department dep = new Department( rs.getString("DepName"),rs.getInt("DepartmentID"));
                Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"),rs.getString("Email"),rs.getDate("birthdate"),rs.getDouble("baseSalary"),dep);
                return seller;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            conn.close(rs, stmt, conexao);
        }
        return null;
    }
    
    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conexao = null;
        try{
            conexao = conn.getConection();
            stmt = conexao.prepareStatement("SELECT seller.*,department.Name as DepName " +
                                            "FROM seller INNER JOIN department " +
                                            "ON seller.DepartmentId = department.Id " +
                                            "WHERE DepartmentId = ? " +
                                            "ORDER BY Name");   
            stmt.setInt(1, department.getId());
            rs = stmt.executeQuery();
            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();
            while(rs.next()){
                Department dep = map.get(rs.getInt("DepartmentId")); 
                if(dep==null){
                    dep = new Department( rs.getString("DepName"),rs.getInt("DepartmentID"));
                    map.put(rs.getInt("DepartmentId"),dep);
                }
                Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"),rs.getString("Email"),rs.getDate("birthdate"),rs.getDouble("baseSalary"),dep);
                sellers.add(seller);
            }
            return sellers;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            conn.close(rs, stmt, conexao);
        }
        return null;
    }
    
}
