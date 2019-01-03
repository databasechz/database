package com.example.jdbc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.daoimp.BaseDaoImp;
import com.example.daoimp.UserDaoImp;
import com.example.helper.JdbcDaoHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class dsjc extends BaseDaoImp<User> implements UserDao {
	private Class<?> EntityClass;
	private String sql;
	private PreparedStatement statement;
	private ResultSet rs;
	private List<User> list;
	public void insert(String a,String i,double b,String c,String d){
		sql="insert into evaluate values "+"('"+a+"','"+i+"',"+b+",'"+c+"','"+d+"')";
		try {
			statement = JdbcDaoHelper.getPreparedStatement(sql);
	        statement.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public void search(String s,String a) {
		sql="SELECT "+s+" "+" FROM "+" " +a;
		System.out.println(sql);
		try {
			statement = JdbcDaoHelper.getPreparedStatement(sql);
	        rs=statement.executeQuery();
	        while (rs.next()) {
	        	System.out.println(rs.getString(s));
	        }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void search1(String sql) {
		// TODO Auto-generated method stub
		
	}

	public String Search(String s)
	{
		   //System.out.println(s);
		   
		    String sql,c = null;
		    sql = "SELECT *\r\n" + 
		    		"FROM career,country,cs,language,mc,ml,movie,mr,mt,reward,sf,staff,type\r\n" + 
		    		"WHERE(movie.movieid=mr.movieid) and (mr.[rewardid]=reward.[rewardid])and(movie.movieid=ml.movieid) and(ml.[language id]=language.[language id])and(movie.movieid=mc.movieid) and(mc.[country id]=country.[country id])and(movie.movieid=mt.movieid)and(type.[type id]=mt.[type id])and(movie.movieid=sf.movieid)and(sf.staffid=staff.staffid)and(staff.staffid=cs.staffid)and(cs.[career id]=career.[career id])\r\n" + 
		    		"and moviename+[country name]+nickname +[reward name]+staffname like'"+s+"%'";
		    /*sql="SELECT "+"movieid"+" "+" FROM "+"movie" ;*/
		        System.out.println(s);
		        JFrame a=new JFrame();
		    	a.setTitle("²éÑ¯½á¹û");
		    	a.setLocation(160,160);
				a.setSize(120,120);
            	JTextArea ja = new JTextArea();
            	a.add(ja);
            	a.setVisible(true);
     			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	try{
            		//System.out.println("hhh");
     			    statement = JdbcDaoHelper.getPreparedStatement(sql);
                    rs=statement.executeQuery(); 
                    while (rs.next()) {
                    // System.out.println("hhh");
     				 c = rs.getString("movieid");
     				ja.append(rs.getString("moviename")+"   "+rs.getString("language name")+"   "+rs.getString("show time")+"   "+rs.getString("lasting time")+"   "+rs.getString("nickname")+"   "+rs.getString("IMDb link")+"   "+rs.getString("introduction")+"   "+rs.getString("final score")+"   "+rs.getString("reward name")+"   "+"\r\n");
     				 //System.out.println(c);
                  }
                  }catch (Exception e1){
     		// TODO Auto-generated catch block
     	    e1.printStackTrace();
     		}
		   
			
		    return c;
		   }
	      public void delete(String s) 
	      {
		   // TODO Auto-generated method stub
		   sql = "Delete \r\n" + 
		   		"from evaluate\r\n" + 
		   		"where userid='"+s+"'\r\n" + 
		   		"Delete \r\n" + 
		   		"from doubanuser\r\n" + 
		   		"where userid='"+s+"'"   ;
		    try {
			    
			    statement = JdbcDaoHelper.getPreparedStatement(sql);
			    statement.executeUpdate();
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } finally {
			JdbcDaoHelper.release(statement, null);
		   }
	}
}
