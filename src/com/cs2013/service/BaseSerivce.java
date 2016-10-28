package com.cs2013.service;

/**
 * 
 *基础service 接口
 * @param <T>
 */
public interface BaseSerivce<T> {
	
	/**
	 * 增加一条信息
	 * @param t
	 * @throws Exception
	 */
	public void add(T t) throws Exception;
	
	/**
	 * 查询一条信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T find(String id) throws Exception;
	
	/**
	 * 删除一条记录
	 * @param t
	 * @throws Exception
	 */
	public void delete(T t) throws Exception;
	
	/**
	 * 修改一条记录
	 * @param t
	 * @throws Exception
	 */
	public void update(T t)throws Exception;
}
