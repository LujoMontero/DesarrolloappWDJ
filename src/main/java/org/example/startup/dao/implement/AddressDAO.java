package org.example.startup.dao.implement;

import org.example.startup.connection.MysqlConnection;
import org.example.startup.dao.IAddressDAO;
import org.example.startup.entity.AddressDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO implements IAddressDAO {
    private Connection connection;

    public AddressDAO() {
        try {
            this.connection = MysqlConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AddressDTO add(AddressDTO addressDTO) {
        String INSERT = "INSERT INTO direcciones (nombre, numero, id_usuario) VALUES (?, ?, ?);";
        try (PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, addressDTO.getName());
            ps.setInt(2, addressDTO.getNumber());
            ps.setInt(3, addressDTO.getIdUser());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        addressDTO.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressDTO;
    }
}
