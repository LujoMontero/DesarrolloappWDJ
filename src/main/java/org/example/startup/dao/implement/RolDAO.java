package org.example.startup.dao.implement;

import com.sun.jdi.connect.spi.Connection;
import org.example.startup.connection.MysqlConnection;
import org.example.startup.dao.IRolDAO;
import org.example.startup.entity.RolDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements IRolDAO {
    private Connection connection = MysqlConnection.getInstance().getConnection();

    @Override
    public List<RolDTO> getAll() {
        List<RolDTO> list = new ArrayList<>();

        try {
            String GET_ALL = "SELECT id, nombre FROM roles;";

            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RolDTO dto = new RolDTO();
                dto.setId(rs.getInt(1));
                dto.setName(rs.getString(2));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}