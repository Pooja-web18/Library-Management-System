package dao;
import bean.Admin;
import exception.AdminException;

public interface AdminDao {

    public Admin loginAdmin(String email,String password)throws AdminException;


    }

