package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DAO<PreparedStatement> {
    /**
     * login(Connection con,User user) 登录验证
     * (Connection con,User user)注册功能
     
     */

    
    //注册功能
    public boolean register(Connection conn,User user) throws Exception{
        boolean flag=false;
        PreparedStatement ps = null;
        String sql="INSERT INTO t_user(userName,password)VALUES(?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassword());
        if (ps.executeUpdate() > 0) {
            flag = true;
        }
        return flag ;}
    }

}
