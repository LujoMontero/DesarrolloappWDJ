package org.example.startup.dao.implement;

import com.sun.jdi.connect.spi.Connection;
import org.example.startup.connection.MysqlConnection;
import org.example.startup.dao.IUserRolDAO;
import org.example.startup.entity.UserRolDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRolDAO implements IUserRolDAO {
    private Connection connection = MysqlConnection.getInstance().getConnection();

    @Override
    public boolean add(UserRolDTO dto) {
        try {
            String INSERT = "INSERT INTO usuarios_roles (id_usuario, id_rol) VALUES (?, ?);";

            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setInt(1, dto.getIdUser());
            ps.setInt(2, dto.getIdRol());

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}