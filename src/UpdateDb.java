import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDb {
    public static void updateSql(int oldDataId, String newData) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "UPDATE ericssonLinks SET Bağlantı = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, newData);
            statement.setInt(2, oldDataId);
            int result = statement.executeUpdate();
            System.out.println("Kayıt güncellendi.");
        }
        catch (SQLException ex){
            helper.showErrorMessage(ex);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
}
