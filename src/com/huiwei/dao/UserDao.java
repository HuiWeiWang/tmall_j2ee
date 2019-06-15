package com.huiwei.dao;

import com.huiwei.bean.User;
import com.huiwei.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description 用户Dao
 * @Author HuiWei
 * @Date 2019/6/15 21:39
 **/
public class UserDao {
    /**
     * @return int
     * @Author HuiWei
     * @Description //获取用户的总数量
     * @Date 18:33 2019/6/15
     * @Param []
     **/
    public int getTotal() {
        int total = 0;
        try (Connection conn = DBUtil.getConnection(); Statement s = conn.createStatement();) {
            String sql = "select count * from user";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
     * @return void
     * @Author HuiWei
     * @Description //增加用户
     * @Date 18:42 2019/6/15
     * @Param [c]
     **/
    public void add(User user) {
        String sql = "insert into user values(null,?,?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author HuiWei
     * @Description //根据id删除用户
     * @Date 20:56 2019/6/15
     * @Param [id]
     **/
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author HuiWei
     * @Description //更新用户
     * @Date 20:59 2019/6/15
     * @Param [c]
     **/
    public void update(User user) {
        String sql = "update user set name = ? , password = ? where id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return com.huiwei.bean.Category
     * @Author HuiWei
     * @Description //根据id查询一个用户
     * @Date 21:09 2019/6/15
     * @Param [id]
     **/
    public User get(int id) {
        User user = null;
        String sql = "select * from user where id = " + id;
        try (Connection conn = DBUtil.getConnection(); Statement s = conn.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                user = new User();
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * @return java.util.List<com.huiwei.bean.Category>
     * @Author HuiWei
     * @Description //分页查询
     * @Date 21:20 2019/6/15
     * @Param [start, count]
     **/
    public List<User> listByPage(int start, int count) {
        List<User> list = new ArrayList<>();
        String sql = "select * from user order by id desc limit ?,?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @return java.util.List<com.huiwei.bean.Category>
     * @Author HuiWei
     * @Description //查询所有用户
     * @Date 21:37 2019/6/15
     * @Param []
     **/
    public List<User> listAll() {
        return listByPage(0, Short.MAX_VALUE);
    }

    /**
     * @return com.huiwei.bean.User
     * @Author HuiWei
     * @Description //根据用户名字查询用户，用于判断用户是否存在，用于注册
     * @Date 23:20 2019/6/15
     * @Param [name]
     **/
    public User get(String name) {
        User user = null;

        String sql = "select * from user where name = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                int id = rs.getInt("id");
                user.setName(name);
                String password = rs.getString("password");
                user.setPassword(password);
                user.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return user;
    }
    /**
      *@Author HuiWei
      *@Description //根据用户名字和密码查询用户。用于判断用户账号和密码是否正确，用于登录
      *@Date 23:21 2019/6/15
      *@Param [name, password]
      *@return com.huiwei.bean.User
    **/
    public User get(String name, String password) {
        User user = null;

        String sql = "select * from user where name = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                int id = rs.getInt("id");
                user.setName(name);
                user.setPassword(password);
                user.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return user;
    }
    /**
      *@Author HuiWei
      *@Description //T判断用户是否存在
      *@Date 23:27 2019/6/15
      *@Param [name]
      *@return boolean
    **/
    public boolean isExist(String name){
        return get(name)!=null;
    }
}
