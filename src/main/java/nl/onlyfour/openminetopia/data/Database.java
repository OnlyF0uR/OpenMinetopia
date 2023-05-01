package nl.onlyfour.openminetopia.data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private final HikariDataSource source;

    public Database(String url, String username, String password) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        source = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    public void closeSource() throws SQLException {
        source.close();
    }
}
