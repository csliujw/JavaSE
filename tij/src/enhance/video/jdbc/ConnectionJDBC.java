package video.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ConnectionJDBC {
    static class Role {
        private Integer id;
        private String roleName;
        private String roleDesc;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleDesc() {
            return roleDesc;
        }

        public void setRoleDesc(String roleDesc) {
            this.roleDesc = roleDesc;
        }

        @Override
        public String toString() {
            return "Role{" +
                    "id=" + id +
                    ", roleName='" + roleName + '\'' +
                    ", roleDesc='" + roleDesc + '\'' +
                    '}';
        }
    }

    public static void getConnectionByProperties() throws SQLException, ClassNotFoundException {
        // mysql驱动8.0以上的对应的加载文件与低版本不一样。
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        // 数据库连接的url记不住就去idea mysql连接功能里找它
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis05?serverTimezone=UTC", properties);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from role");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Role> data = new ArrayList<>();
        while (resultSet.next()) {
            Role role = new Role();
            role.setId(resultSet.getInt(1));
            role.setRoleName(resultSet.getString(2));
            role.setRoleName(resultSet.getString(3));
            data.add(role);
        }
        data.forEach(System.out::println);
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionJDBC.getConnectionByProperties();
    }
}
