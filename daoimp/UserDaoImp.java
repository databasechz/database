package com.example.daoimp;

import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.helper.JdbcDaoHelper;

public class UserDaoImp extends BaseDaoImp<User> implements UserDao {

	private Class<?> EntityClass;

	private String sql;

	public PreparedStatement statement;

	public ResultSet rs;

	private List<User> list;

	public UserDaoImp() {

		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		EntityClass = (Class<?>) type.getActualTypeArguments()[0];
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub EntityClass.getSimpleName()
		StringBuffer b = new StringBuffer();
		list = new ArrayList<User>();
		sql = b.append("USE EVALUATE select * from " + "doubanuser")
				.toString();
		try {
			statement = JdbcDaoHelper.getPreparedStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				User doubanuser = new User();
				doubanuser.setUserid(rs.getString("userid"));
				//System.out.println(" "+doubanuser.getUserid());
				doubanuser.setPassword(rs.getString("password"));
				doubanuser.setEmail(rs.getString("Email"));
				doubanuser.setWeChat(rs.getString("WeChat"));
				doubanuser.setQQ(rs.getString("QQ"));
				doubanuser.setSina(rs.getString("Sina"));
				doubanuser.setPhonenumber(rs.getInt("Phone number"));
				list.add(doubanuser);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
