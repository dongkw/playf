package models.model;

import common.ibatis3.BaseEntity;
import net.sf.oval.constraint.Length;

public class BigdataSource extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BigdataSource";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TYPE = "类型";
	public static final String ALIAS_NAME = "来源";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;
	@Length(max=20)
	private String type;
	@Length(max=50)
	private String name;
	//columns END
	public BigdataSource(){
	}

	public BigdataSource(
		Long id
	){
		this.id = id;
	}

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
