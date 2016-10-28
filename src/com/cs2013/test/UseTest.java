package com.cs2013.test;

import org.junit.Test;

import com.cs2013.utils.DBUtils;

/**
 * 用户测试类
 *
 */
public class UseTest {

	@Test
	public void testAddUser(){
		DBUtils.getInsatnce().getConnection();
	}
	
}
