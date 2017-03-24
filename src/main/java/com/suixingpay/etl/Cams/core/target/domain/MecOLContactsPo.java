package com.suixingpay.etl.Cams.core.target.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.suixingpay.example.ChangeFlag;
/**
 * Description: 线上商户联系人信息表 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author lilimin
 * Created on: 2017-02-22 19:47:43
 */
@Entity
@Table(name = "UMS.T_UMS_MEC_OL_CONTACTS")
public class MecOLContactsPo {
	private static final long serialVersionUID = -2772861649354436228L;
	// CONTACT_ID
	@Id
	@Column(name = "CONTACT_ID")
	@ChangeFlag(alise = "UUID")
	private	String	contactId;
	// 用户编号
	@Column(name = "USR_ID")
	private	String	usrId;
	// 商户编号
	@Column(name = "MNO")
	private	String	mno;
	// 内部商编
	@Column(name = "IN_MNO")
	private	String	inMno;
	// 联系人名称
	@Column(name = "NAME")
	private	String	name;
	// 职务
	@Column(name = "JOB")
	private	String	job;
	// 电话
	@Column(name = "TEL")
	private	String	tel;
	// 序号
	@Column(name = "SNO")
	private	BigDecimal	sno;
	// 首次创建人编号。操作员编号。
	@Column(name = "CTE_STFF_NO")
	private	String	cteStffNo;
	// 修改人编号
	@Column(name = "UTE_STFF_NO")
	private	String	uteStffNo;
	// 创建日期
	@Column(name = "DT_CTE")
	private	String	dtCte;
	// 创建时间
	@Column(name = "TM_CTE")
	private	String	tmCte;
	// 更新日期
	@Column(name = "DT_UTE")
	private	String	dtUte;
	// 更新时间
	@Column(name = "TM_UTE")
	private	String	tmUte;

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	/**
	 * CONTACT_ID
	 * @return
	 */
	public String getContactId() {
		return contactId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * 用户编号
	 * @return
	 */
	public String getUsrId() {
		return usrId;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}
	/**
	 * 商户编号
	 * @return
	 */
	public String getMno() {
		return mno;
	}

	public void setInMno(String inMno) {
		this.inMno = inMno;
	}
	/**
	 * 内部商编
	 * @return
	 */
	public String getInMno() {
		return inMno;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 联系人名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * 职务
	 * @return
	 */
	public String getJob() {
		return job;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 电话
	 * @return
	 */
	public String getTel() {
		return tel;
	}


    public BigDecimal getSno() {
        return sno;
    }
    public void setSno(BigDecimal sno) {
        this.sno = sno;
    }
    public void setCteStffNo(String cteStffNo) {
		this.cteStffNo = cteStffNo;
	}
	/**
	 * 首次创建人编号。操作员编号。
	 * @return
	 */
	public String getCteStffNo() {
		return cteStffNo;
	}

	public void setUteStffNo(String uteStffNo) {
		this.uteStffNo = uteStffNo;
	}
	/**
	 * 修改人编号
	 * @return
	 */
	public String getUteStffNo() {
		return uteStffNo;
	}

	public void setDtCte(String dtCte) {
		this.dtCte = dtCte;
	}
	/**
	 * 创建日期
	 * @return
	 */
	public String getDtCte() {
		return dtCte;
	}

	public void setTmCte(String tmCte) {
		this.tmCte = tmCte;
	}
	/**
	 * 创建时间
	 * @return
	 */
	public String getTmCte() {
		return tmCte;
	}

	public void setDtUte(String dtUte) {
		this.dtUte = dtUte;
	}
	/**
	 * 更新日期
	 * @return
	 */
	public String getDtUte() {
		return dtUte;
	}

	public void setTmUte(String tmUte) {
		this.tmUte = tmUte;
	}
	/**
	 * 更新时间
	 * @return
	 */
	public String getTmUte() {
		return tmUte;
	}
}