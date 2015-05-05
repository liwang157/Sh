/**
* @author liwang
* @date 2015年3月31日 下午5:40:24 
*/
package cn.com.sh.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.sh.dao.IUserDao;
import cn.com.sh.dao.common.impl.OperationsDao;
import cn.com.sh.model.User;

/**
 * @Description: IUserDao中其他接口实现
 * @author liwang
 * @date 2015年3月31日 下午5:40:24
 * 
 */
@Repository
public class UserDao extends OperationsDao<User> implements IUserDao {


	public UserDao() {
		setClassz(User.class);
	}

}
