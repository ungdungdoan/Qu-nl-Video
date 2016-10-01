package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import entity.LoaiSach;

public class TestThu {
	public static void main(String[] args) {
		List<LoaiSach> dsLoaiSach= new ArrayList<LoaiSach>();
		Connection con = Database.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("select * from LoaiSach");
			rs=stmt.executeQuery();
			while(rs.next()){
				dsLoaiSach.add(new LoaiSach(rs.getInt("maLoai"), rs.getString("loai")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			DbUtils.close(rs, stmt);
		}
		for(LoaiSach s : dsLoaiSach){
			System.out.println(s.toString());
		}
	}
}
