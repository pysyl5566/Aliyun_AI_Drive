package com.aliyun.carManager.mybatis.provider;

import com.aliyun.carManager.pojo.User;
import org.apache.ibatis.jdbc.SQL;

public class InsertProvider {
    public String addUser(User user) {
        SQL sql = new SQL();
        //	@Insert("<script>INSERT INTO USER(name,sex,tel,email,remark<IF TEST='idCardImg = \"\"’'>,idCardImg</IF>) VALUES(#{name},#{sex},#{tel},#{email},#{remark}<IF TEST='idCardImg = \"\"'>,#{idCardImg}</IF>)</script>")
        //sql.INSERT_INTO("USER").VALUES("name",user.getName()).VALUES("sex",String.valueOf(user.getSex())).VALUES("tel",user.getTel()).VALUES("email",user.getEmail()).VALUES("remark",user.getRemark());
        sql.INSERT_INTO("USER");

        if (!"".equals(user.getName())) {
            sql.VALUES("name","'" + user.getName() + "'");
        }

        if (!"".equals(user.getSex())) {
            sql.VALUES("sex","'" + String.valueOf(user.getSex()) + "'");
        }

        if (!"".equals(user.getTel())) {
            sql.VALUES("tel","'" + user.getTel() + "'");
        }

        if (!"".equals(user.getEmail())) {
            sql.VALUES("email", "'" + user.getEmail() + "'");
        }

        if (!"".equals(user.getRemark())) {
            sql.VALUES("remark","'" + user.getRemark() + "'");
        }

        if (!"".equals(user.getIdCardImg())) {
            sql.VALUES("idCardImg","'" + user.getIdCardImg() + "'");
        }

        if (user.getParent().getUid() != null) {
            sql.VALUES("parent","'" + user.getParent().getUid() + "'");
        }

        return sql.toString();
    }
}
