package models.vo.query;

import common.ibatis3.BaseQuery;

public class BigdataSourceQuery extends BaseQuery implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;

	/*id*/
	private Long id;
	/*类型*/
	private String type;
	/*来源*/
	private String name;


	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return this.type;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
}
