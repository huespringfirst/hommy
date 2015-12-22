package com.hommy.dao;

import com.hommy.connection.ConnectionFactory;
import com.hommy.entity.TypeRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypePostDAO {

    public TypePostDAO() {
    }

//    find all type_request
    public ArrayList<TypeRequest> findAllTypeRequest() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM type_request";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<TypeRequest> list = new ArrayList<>();
                while (rs.next()) {
                    TypeRequest entity = new TypeRequest();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

}
