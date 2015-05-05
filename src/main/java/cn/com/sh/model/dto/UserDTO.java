/**
* @author liwang
* @date 2015年4月3日 下午2:13:51 
*/
package cn.com.sh.model.dto;

import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @Description:
 * @author liwang
 * @date 2015年4月3日 下午2:13:51 
 *  
 */
@XmlRootElement
public class UserDTO {

	private int id;
	private String name;

	private Address citys;

	public Address getCitys() {
		return citys;
	}

	public void setCitys(Address citys) {
		this.citys = citys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
