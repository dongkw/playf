package models.model;

import common.ibatis3.BaseEntity;
import net.sf.oval.constraint.Length;

public class BigdataFromBrightease extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BigdataFromBrightease";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_SOURCE = "来源id";
	public static final String ALIAS_DATA = "数据";
	public static final String ALIAS_CREATETIME = "创建时间";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	public static final String FORMAT_CREATETIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;
	@Length(max=50)
	private String code;
	@Length(max=20)
	private String source;
	@Length(max=65535)
	private String data;
	
	private java.util.Date createtime;
	@Length(max=200)
	private String remark;
	//columns END
	public BigdataFromBrightease(){
	}

	public BigdataFromBrightease(
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
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return this.code;
	}
	public void setSource(String value) {
		this.source = value;
	}
	
	public String getSource() {
		return this.source;
	}
	public void setData(String value) {
		this.data = value;
	}
	
	public String getData() {
		return this.data;
	}
	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}
	
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
	}
}
