package cn.itmastc.jdbc.test;

import cn.itmastc.jdbc.utils.DBCPUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 13:26 2018/8/23
 * @Modified By:
 */
public class TestDBCP {

    @Test
    public void testUpdateUserById() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBCPUtils.getConnection();
            String sql = "update tbl_user set upassword=? where uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "娱乐");
            pstmt.setInt(2, 7);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("更新成功!");
            } else {
                System.out.println("更新失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
