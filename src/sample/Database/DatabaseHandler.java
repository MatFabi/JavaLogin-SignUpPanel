package sample.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" +dbHost+":"+dbPort+"/"+dbName;
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);

        return dbConnection;
    }
    public void signUpUser(String firstName, String lastName, String userName, String password, String location, String gender){
        String inserts = "INSERT INTO " + Const.USERS_TABLE +"("+Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME +","+Const.USERS_USERNAME+","
                +Const.USERS_PASSWORD+","+Const.USERS_LOCATION+","
               + Const.USERS_GENDER+ ")"+" VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(inserts);

            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,userName);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,location);
            preparedStatement.setString(6,gender);

            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
