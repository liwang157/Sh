/**
* @author liwang
* @date 2015年4月2日 下午12:02:17 
*/
package cn.com.sh.dao.common.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sh.dao.common.IOperations;

import com.google.common.base.Preconditions;

/**
 * @Description: 通用接口操作实现
 * @author liwang
 * @date 2015年4月2日 下午12:02:17
 * 
 */
public class OperationsDao<T extends Serializable> implements IOperations<T> {

	private Class<T> classz;

	@Autowired
	private SessionFactory sessionFactory;

	protected final void setClassz(final Class<T> classz) {
		this.classz = classz;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T queryOne(int id) {
		return (T) getCurrentSession().get(classz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll() {
		return getCurrentSession().createQuery("from " + classz.getName()).list();
	}

	@Override
	public void add(T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public T update(T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().delete(entity);
	}

	@Override
	public void deleteById(int id) {
		final T entity = queryOne(id);
		Preconditions.checkNotNull(entity);
		delete(entity);
	}

}
