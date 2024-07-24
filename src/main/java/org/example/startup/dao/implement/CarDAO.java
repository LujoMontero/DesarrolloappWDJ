package org.example.startup.dao.implement;

import com.sun.jdi.connect.spi.Connection;
import jakarta.resource.cci.ResultSet;
import org.example.startup.connection.MysqlConnection;
import org.example.startup.dao.ICarDAO;
import org.example.startup.entity.CarDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO {
    private Connection connection = MysqlConnection.getInstance().getConnection();

    @Override
    public List<CarDTO> getAll() {
        List<CarDTO> list = new ArrayList<>();

        try {
            String GET_ALL = "SELECT id, nombre, url, id_proveedor FROM autos;";

            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CarDTO dto = new CarDTO();
                dto.setId(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setUrl(rs.getString(3));
                dto.setIdSuppliers(rs.getInt(4));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}