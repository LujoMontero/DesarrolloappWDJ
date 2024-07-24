package org.example.startup.dao.implement;

import com.sun.jdi.connect.spi.Connection;
import jakarta.resource.cci.ResultSet;

import org.example.startup.connection.MysqlConnection;
import org.example.startup.dao.IAddressDAO;
import org.example.startup.entity.AddressDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddressDAO implements IAddressDAO {
    private Connection connection = MysqlConnection.getInstance().getConnection();

    @Override
    public AddressDTO add(AddressDTO addressDTO) {
        try {
            String INSERT = "INSERT INTO direcciones (nombre, numero, id_usuario) VALUES (?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, addressDTO.getName());
            ps.setInt(2, addressDTO.getNumber());
            ps.setInt(3, addressDTO.getIdUser());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    addressDTO.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addressDTO;
    }
}