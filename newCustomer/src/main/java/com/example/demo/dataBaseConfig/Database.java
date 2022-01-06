package com.example.demo.dataBaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Database {

    public static final int CIVS_DATABASE_MAX_ROWS = 1000;
    private static final int DATABASE_CONNECTION_POOL_SIZE = 10;
    private static final int DATABASE_CONNECTION_MAX_USAGE = 100;
    private static final String server = "dbhostname";
    private static final int port = 1521;
    private static final String sid = "orcl";
    private static final String userName = "dbuser";
    private static final String passwd = "dbpass";
    private static final String driverName = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
    private static BlockingQueue<Connection> connectionsPool;
    private static ConcurrentHashMap<Connection, AtomicInteger> usage;

    static {
        Logging.info("Setting UP Database!");
        try {
            Class.forName(driverName);
            connectionsPool = new ArrayBlockingQueue<Connection>(DATABASE_CONNECTION_POOL_SIZE + 10);
            usage = new ConcurrentHashMap<Connection, AtomicInteger>();
            for (int i = 0; connectionsPool.size() < DATABASE_CONNECTION_POOL_SIZE; i++) {
                Connection c = null;
                try {
                    c = DriverManager.getConnection(url, userName, passwd);
                } catch (SQLException e) {
                    Logging.info("Nao consegue criar conn....");
                    e.printStackTrace();
                }
                if (c != null) {
                    try {
                        usage.put(c, new AtomicInteger(0));
                        connectionsPool.put(c);
                    } catch (InterruptedException ie) {
                    }
                }
            }
        } catch (Exception e) {
            Logging.info("Cannot init Database!!!!");
            e.printStackTrace();
        } finally {

        }
        Logging.info("Database UP!");
    }

    public static Connection pickConnection() {
        while (true) {
            try {
                Connection con = connectionsPool.take();
                if (con != null) {
                    if (!con.isClosed()) {
                        return con;
                    } else {
                        usage.remove(con);
                        Connection c = DriverManager.getConnection(url, userName, passwd);
                        usage.put(c, new AtomicInteger(0));
                        return c;
                    }
                }
            } catch (InterruptedException e) {
            } catch (SQLException se) {
            }
        }
    }

    public static void relaseConnection(Connection con) {
        if (con != null) {
            try {
                AtomicInteger get = usage.get(con);
                if (get == null) {
                    get = new AtomicInteger(0);
                }
                if (get.getAndIncrement() < DATABASE_CONNECTION_MAX_USAGE) {

                    try {
                        con.rollback();
                    } catch (SQLException e) {
                        Logging.info("con.rollback()...." + e);
                    }
                    connectionsPool.put(con);
                } else {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    Connection c = null;
                    try {
                        c = DriverManager.getConnection(url, userName, passwd);
                    } catch (SQLException e) {
                        Logging.info("Nao consegue criar conn....");
                        e.printStackTrace();
                    }
                    connectionsPool.put(c);
                    usage.put(c, new AtomicInteger(0));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Statement createStatement(final Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.setMaxRows(CIVS_DATABASE_MAX_ROWS);
        return st;
    }
}