package com.hommy.dao;

import com.hommy.connection.ConnectionFactory;
import com.hommy.entity.Member;
import com.hommy.entity.TypeRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TypePostDAO {

    public TypePostDAO() {
    }

    //find all type_request
//    public ArrayList<TypeRequest> findAllTypeRequest() {
//        try (Connection conn = ConnectionFactory.getConnection()) {
//            String sql = "SELECT * FROM type_request";
//            try (PreparedStatement ps = conn.prepareStatement(sql)) {
//                ResultSet rs = ps.executeQuery();
//                ArrayList<TypeRequest> list = new ArrayList<>();
//                while (rs.next()) {
//                    TypeRequest entity = new TypeRequest();
//                    entity.setId(rs.getShort("id"));
//                    entity
//                }
//            }
//        }
//    }

}
