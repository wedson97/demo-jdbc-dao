package demojdbcdao.Dao;

import demojdbcdao.Department;
import java.util.List;

public interface DepartmentDao {
    void Insert(Department department);
    void Update(Department department);
    void DeleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}
