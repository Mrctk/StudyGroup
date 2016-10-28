package com.cs2013.service;

/**
 * 
 *����service �ӿ�
 * @param <T>
 */
public interface BaseSerivce<T> {
	
	/**
	 * ����һ����Ϣ
	 * @param t
	 * @throws Exception
	 */
	public void add(T t) throws Exception;
	
	/**
	 * ��ѯһ����Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T find(String id) throws Exception;
	
	/**
	 * ɾ��һ����¼
	 * @param t
	 * @throws Exception
	 */
	public void delete(T t) throws Exception;
	
	/**
	 * �޸�һ����¼
	 * @param t
	 * @throws Exception
	 */
	public void update(T t)throws Exception;
}
