package com.onibmagairlines.classes;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private boolean connected;

    public boolean openConnection(String login, String password) {
        try {
            String connectionURL = "jdbc:oracle:thin:@ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl";
            connection = DriverManager.getConnection(connectionURL, login, password);
            System.out.println("Connection set successfully");
            this.connected = true;
            return true;
        } catch (SQLException e) {
            System.out.println("Could not create a connection: " + e.getMessage());
            this.connected = false;
            return false;
        }
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed successfully");
            this.connected = false;
            return true;
        } catch (SQLException e) {
            System.out.println("Could not close the connection: " + e.getMessage());
            return false;
        }
    }

    public int update(String table, String[] columns, Object[] values, String where_condition) {
        if (columns.length != values.length || columns.length == 0)
            return 0;

        StringBuilder sql = new StringBuilder("UPDATE " + table + " SET ");

        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i]).append(" = ?");
            if (i != columns.length - 1)
                sql.append(", ");
        }

        sql.append(" WHERE ").append(where_condition);

        try {
            PreparedStatement stmt = connection.prepareStatement(sql.toString());
            for (int i = 1; i <= values.length; i++)
                stmt.setObject(i, values[i - 1]);
            int updatedCount = stmt.executeUpdate();
            stmt.close();
            return updatedCount;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return 0;
        }
    }

    public boolean insert(String table, String[] columns, Object[] values) {
        if (columns.length != values.length || columns.length == 0)
            return false;

        StringBuilder sql = new StringBuilder("INSERT INTO " + table + " (");

        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i]);
            if (i != columns.length - 1)
                sql.append(", ");
        }

        sql.append(") VALUES (");

        for (int i = 0; i < values.length; i++) {
            sql.append("?");
            if (i != values.length - 1)
                sql.append(", ");
        }

        sql.append(")");

        System.out.println(sql);

        try {
            PreparedStatement stmt = connection.prepareStatement(sql.toString());
            for (int i = 1; i <= values.length; i++)
                stmt.setObject(i, values[i - 1]);
            int insertedCount = stmt.executeUpdate();
            stmt.close();
            return insertedCount > 0;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(String table, String condition) {
        try {
            Statement statement = connection.createStatement();
            String statement_code = "DELETE FROM " + table + " WHERE " + condition; // cus no user input
            statement.execute(statement_code);
            statement.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<ArrayList<Object>> executeQuery(String query) {
        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)
        ) {
            ArrayList<ArrayList<Object>> result = new ArrayList<>();
            while (resultSet.next()) {
                ArrayList<Object> row = new ArrayList<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
                    row.add(resultSet.getObject(i));
                result.add(row);
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public void executeInsert(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }


    public ArrayList<ArrayList<Object>> select(String[] columns, String table) {
        return select(columns, table, null);
    }

    public ArrayList<ArrayList<Object>> select(String[] columns, String table, String where_condition) {
        StringBuilder query = new StringBuilder("SELECT ");

        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i]);
            if (i != columns.length - 1)
                query.append(", ");
        }

        query.append(" FROM ").append(table);
        if (where_condition != null)
            query.append(" WHERE ").append(where_condition);


        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(query.toString())
        ) {
            ArrayList<ArrayList<Object>> result = new ArrayList<>();
            while (resultSet.next()) {
                ArrayList<Object> row = new ArrayList<>();
                for (int i = 1; i <= columns.length; i++)
                    row.add(resultSet.getObject(i));
                result.add(row);
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }
}
