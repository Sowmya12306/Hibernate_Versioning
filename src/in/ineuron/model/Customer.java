package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


/*
 * 
Versioning/ Object Versioning
===================================
It keeps track of how many time the Object/record is loaded and modified using Hibernate.
It generates a special column of type numeric based, special number property of entity class to keep track of the modification.
This special property/column initial value is 0 and it is incremented by 1 for every modification.
To configure this special property we need to use one annotation called @Version.
*
*/

@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1674880818649543388L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	
	private String cname;
	
	private long mobileNo;

	private String callerTune;
	
	@Version
	private Integer versionCount;
	
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", mobileNo=" + mobileNo + ", callerTune=" + callerTune
				+ "]";
	}



}
