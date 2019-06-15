package com.huiwei.dao;

import com.huiwei.bean.Category;
import com.huiwei.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CategoryDao
 * @Description 商品分类Dao
 * @Author HuiWei
 * @Date 2019/6/15 18:24
 **/
public class CategoryDao {
    /**
      *@Author HuiWei
      *@Description //获取商品分类的总数量
      *@Date 18:33 2019/6/15
      *@Param []
      *@return int
    **/
    public int getTotal(){
        int total = 0;
        try (Connection conn = DBUtil.getConnection(); Statement s = conn.createStatement();){
            String sql = "select count * from category";
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
      *@Author HuiWei
      *@Description //根据分类实体向数据库插入商品分类
      *@Date 18:42 2019/6/15
      *@Param [c]
      *@return void
    **/
    public void add(Category c){
        String sql = "insert into category values(null,?)";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,c.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                c.setId(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
      *@Author HuiWei
      *@Description //根据id删除分类
      *@Date 20:56 2019/6/15
      *@Param [id]
      *@return void
    **/
    public void delete(int id){
        String sql = "delete from category where id = ?";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
      *@Author HuiWei
      *@Description //更新商品
      *@Date 20:59 2019/6/15
      *@Param [c]
      *@return void
    **/
    public void update(Category c){
        String sql = "update category set name = ? where id = ?";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,c.getName());
            ps.setInt(2,c.getId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
      *@Author HuiWei
      *@Description //根据id查询一个商品分类
      *@Date 21:09 2019/6/15
      *@Param [id]
      *@return com.huiwei.bean.Category
    **/
    public Category get(int id){
        Category c = null;
        String sql = "select * from category where id = "+id;
        try(Connection conn = DBUtil.getConnection(); Statement s = conn.createStatement()){
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                c = new Category();
                c.setName(rs.getString(2));
                c.setId(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
    /**
      *@Author HuiWei
      *@Description //分页查询
      *@Date 21:20 2019/6/15
      *@Param [start, count]
      *@return java.util.List<com.huiwei.bean.Category>
    **/
    public List<Category> listByPage(int start,int count){
        List<Category> list = new ArrayList<>();
        String sql = "select * from category order by id desc limit ?,?";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                list.add(c);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /**
      *@Author HuiWei
      *@Description //查询所有商品分裂
      *@Date 21:37 2019/6/15
      *@Param []
      *@return java.util.List<com.huiwei.bean.Category>
    **/
    public List<Category> listAll(){
        return listByPage(0,Short.MAX_VALUE);
    }
}
