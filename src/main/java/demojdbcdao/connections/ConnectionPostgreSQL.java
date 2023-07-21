package demojdbcdao.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPostgreSQL {

    private String url;
    private String user;
    private String password;
    private String driver;

    public ConnectionPostgreSQL() {
        this.url = "jdbc:postgresql://localhost:5432/coursejdbc";
        this.user = "postgres";
        this.password = "9797";
        this.driver = "org.postgresql.Driver";
    }

    public Connection getConection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void close(ResultSet rs, PreparedStatement stmt, Connection conexao) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(stmt, conexao);
    }

    public void close(PreparedStatement stmt, Connection conexao) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
