package com.libreria.social.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PersistenciaConexiones {
	private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    
    static {
    config.setJdbcUrl("jdbc:mariadb://localhost:3306/libreria");
    config.setUsername("jgiraldoc");
    config.setPassword("0214");
    config.setMaximumPoolSize(5);
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    ds = new HikariDataSource(config);
	}
    
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public static PreparedStatement getPreparedStatement(Connection conexion, String sql) throws SQLException {
		PreparedStatement ps = conexion.prepareStatement(sql);
		return ps;
    }
}
