package com.huiwei.bean;

/**
 * @ClassName User
 * @Description 用户类
 * @Author HuiWei
 * @Date 2019/6/15 15:15
 **/


public class User {
    private String password;
    private String name;
    private int id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   /**
     *@Author HuiWei
     *@Description // 生成用户的匿名信息
     *@Date 15:31 2019/6/15
     *@Param []
     *@return java.lang.String
   **/
    public String getAnonymousName() {
        if (name != null) {
            return null;
        }
        if (name.length() <= 1) {
            return "*";
        }
        if (name.length() == 2) {
            return name.substring(0, 1) + "*";
        }
        char[] cs = name.toCharArray();
        for (int i = 1; i < cs.length - 1; i++) {
            cs[i] = '*';
        }
        return new String(cs);
    }
}

