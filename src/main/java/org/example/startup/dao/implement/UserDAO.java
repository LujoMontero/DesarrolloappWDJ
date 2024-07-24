package org.example.startup.dao.implement;

import org.example.startup.connection.MysqlConnection;
import org.example.startup.dao.IUserDAO;
import org.example.startup.entity.UserDTO;
import org.example.startup.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private Connection connection = MysqlConnection.getInstance().getConnection();

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> list = new ArrayList<>();

        try {
            String GET_ALL = "SELECT id, email, nombre, nick, id_auto, id_rol, id_direccion, peso FROM usuarios;";

            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserDTO dto = new UserDTO();
                dto.setId(rs.getInt(1));
                dto.setEmail(rs.getString(2));
                dto.setName(rs.getString(3));
                dto.setNick(rs.getString(4));
                dto.setIdCar(rs.getInt(5));
                dto.setIdRol(rs.getInt(6));
                dto.setIdAddress(rs.getInt(7));
                dto.setWeight(rs.getInt(8));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public UserDTO add(UserDTO dto) {
        try {
            String INSERT = "INSERT INTO usuarios (email, password, nombre, nick, id_auto, id_rol, id_direccion, peso) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, dto.getEmail());
            ps.setString(2, PasswordUtil.hashPassword(dto.getPassword()));
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getNick());
            ps.setInt(5, dto.getCar().getId());
            ps.setInt(6, dto.getRol().getId());
            ps.setInt(7, dto.getAddress().getId());
            ps.setInt(8, dto.getWeight());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    dto.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    @Override
    public boolean emailExists(String email) {
        try {
            String CHECK_EMAIL = "SELECT id FROM usuarios WHERE email = ?;";

            PreparedStatement ps = connection.prepareStatement(CHECK_EMAIL);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public UserDTO userLogin(String email, String password) {
        UserDTO dto = null;

        try {
            String LOGIN = "SELECT id, email, nombre, nick, id_auto, id_rol, id_direccion, peso FROM usuarios WHERE email = ? AND password = ?;";

            PreparedStatement ps = connection.prepareStatement(LOGIN);
            ps.setString(1, email);
            ps.setString(2, PasswordUtil.hashPassword(password));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new UserDTO();
                dto.setId(rs.getInt(1));
                dto.setEmail(rs.getString(2));
                dto.setName(rs.getString(3));
                dto.setNick(rs.getString(4));
                dto.setIdCar(rs.getInt(5));
                dto.setIdRol(rs.getInt(6));
                dto.setIdAddress(rs.getInt(7));
                dto.setWeight(rs.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }
}
