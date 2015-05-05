/**
* @author liwang
* @date 2015年4月2日 上午11:59:00 
*/
package cn.com.sh.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 通用的操作接口
 * @author liwang
 * @date 2015年4月2日 上午11:59:00
 * 
 */
public interface IOperations<T extends Serializable> {

	T queryOne(final int id);

	List<T> queryAll();

	void add(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final int id);

}
