package models.vo.query;

import common.ibatis3.BaseQuery;

public class BigdataFromBrighteaseQuery extends BaseQuery implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;

	/*id*/
	private Long id;
	/*code*/
	private String code;
	/*来源id*/
	private String source;
	/*数据*/
	private String data;
	/*创建时间*/
	private java.util.Date createtime;
	/*备注*/
	private String remark;


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
