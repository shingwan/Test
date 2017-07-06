package com.spring.bbsDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.spring.bbsVO.BVO;

public class BDAO {
	DataSource dataSource;

	public BDAO(){
		try{
			Context ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		}
		catch(NamingException 	e){
			e.printStackTrace();
		}
	}
	public ArrayList<BVO>list(){
		ArrayList<BVO> bvos = new ArrayList<BVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String sql = "select * from mvc_bbs"
			+"order by bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(sql);
			resultset = preparedStatement.executeQuery();

			while(resultset.next()){
				int bNo = resultset.getInt("bNo");
				String bName = resultset.getString("bName");
				String bSubject = resultset.getString("bSubject");
				String bContent = resultset.getString("bContent");
				Date bDate = resultset.getDate("bDate");

				int bHit = resultset.getInt("bHit");
				int bGroup = resultset.getInt("bGroup");
				int bStep = resultset.getInt("bStep");
				int bIndent = resultset.getInt("bIndent");

				BVO bvo = new BVO(bNo, bName,bContent ,bSubject, bDate, bHit, bGroup, bStep, bIndent);
				bvos.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null)connection.close();
			}catch(Exception e2){
					e2.printStackTrace();
			}
		}

		return bvos;

	}//list()

	public  void write(String bName, String bSubject, String bContent){

		Connection connection = null;
		PreparedStatement pstmt = null;

		try{

			connection = dataSource.getConnection();
			System.out.println("connection 확보");

			String sql = "insert into mvc_bbs(bNo,bName,bSubject,bContent,bHit,bGroup,bStep,bIndent"
							+ "values(seq_bbs.nextval,?,?,?,0,seq_bbs.currval,0,0)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, bName);
			pstmt.setString(2, bSubject);
			pstmt.setString(3, bContent);

			int n = pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(connection !=null) connection.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}//write()

}
