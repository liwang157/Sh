/**
* @author liwang
* @date 2015年4月13日 下午3:28:51 
*/
package cn.com.sh.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * @Description:
 * @author liwang
 * @date 2015年4月13日 下午3:28:51 
 *  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mvc-dispatcher-servlet.xml","classpath:spring-hibernate.xml" })
public class JUnitDaoBase extends AbstractTransactionalJUnit4SpringContextTests {

	@Override
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
}
