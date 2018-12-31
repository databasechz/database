package com.example.dao;

import java.util.List;

import com.example.bean.User;



public interface UserDao extends BaseDao<User> {

	//∞¥’’––≤È—Ø
	List<User>findAll();
	
}
