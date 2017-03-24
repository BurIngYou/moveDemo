package com.suixingpay.etl.Cams.core.target.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.suixingpay.example.ChangeFlag;
/**
 * Description: 商户基础表 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author huyou
 * Created on: 2017-02-21 15:46:53
 */
@Entity
@Table(name = "ums.T_UMS_MEC")
public class MecPo {
	// 用户编号
	@Id
	@Column(name = "USR_ID")
	private	String	usrId;
	// 商户编号
	@Column(name = "MNO")
	private	String	mno;
	// 内部商编
	@Column(name = "IN_MNO")
	private	String	inMno;
	// 显示名称
	@Column(name = "VIEW_NAME")
	@ChangeFlag(alise ="CPR_REG_NM_CN" )
	private	String	viewName;
	// 商户状态
	@Column(name = "MEC_STS")
	private	String	mecSts;
	// 商户类型(00：普通商户，01：会生活，02：手刷商户，03：线上商户，04：VV商户，05：移动商户,06:钱包商户)
	@Column(name = "MEC_TYP")
	private	String	mecTyp;
	@Column(name="MBL_NO")
	@ChangeFlag(alise ="MEC_ADMIN_TEL" )
	private String mblNo;//联系人手机号
	
	// 创建日期
	@Column(name = "CTE_DT")
	@ChangeFlag(mergerDate ="DT_CTE@TM_CTE" )
	private	java.util.Date	cteDt;
	// 更新日期
	@Column(name = "UTE_DT")
	@ChangeFlag(mergerDate ="DT_UTE@TM_UTE" )
	private	java.util.Date	uteDt;

	
	
	public String getMecTyp() {
		return mecTyp;
	}
	public void setMecTyp(String mecTyp) {
		this.mecTyp = mecTyp;
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

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	/**
	 * 显示名称
	 * @return
	 */
	public String getViewName() {
		return viewName;
	}

	public void setMecSts(String mecSts) {
		this.mecSts = mecSts;
	}
	/**
	 * 商户状态
	 * @return
	 */
	public String getMecSts() {
		return mecSts;
	}

	public void setCteDt(java.util.Date cteDt) {
		this.cteDt = cteDt;
	}
	/**
	 * 创建日期
	 * @return
	 */
	public java.util.Date getCteDt() {
		return cteDt;
	}

	public void setUteDt(java.util.Date uteDt) {
		this.uteDt = uteDt;
	}
	/**
	 * 更新日期
	 * @return
	 */
	public java.util.Date getUteDt() {
		return uteDt;
	}
	public String getMblNo() {
		return mblNo;
	}
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	@Override
	public String toString() {
		return "MecPo [usrId=" + usrId + ", mno=" + mno + ", inMno=" + inMno + ", viewName=" + viewName + ", mecSts=" + mecSts + ", mecTyp=" + mecTyp + ", mblNo=" + mblNo
				+ ", cteDt=" + cteDt + ", uteDt=" + uteDt + "]";
	}
	
	
}
