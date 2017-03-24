package com.suixingpay.etl.Cams.core.target.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description: 商户内部归属信息表 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author huyou
 * Created on: 2017-02-16 14:49:35
 */
@Entity
@Table(name = "UMS.T_UMS_MEC_ITN_ATTR_IF")
public class MecItnAttrIfPo{
	// UUID
	@Id
	@Column(name = "UUID")
	private	String	uuid;
	// 用户号
	@Column(name = "USR_ID")
	private	String	usrId;
	// 内部商编
	@Column(name = "IN_MNO")
	private	String	inMno;
	// 商户运营归属
	@Column(name = "MEC_OPER_ATTR_NO")
	private	String	mecOperAttrNo;
	// 商户业务归属
	@Column(name = "MEC_BIXZ_ATTR_NO")
	private	String	mecBixzAttrNo;
	// 商户风控归属
	@Column(name = "MEC_RC_ATTR")
	private	String	mecRcAttr;
	// 商户拓展类型
	@Column(name = "MEC_DEV_TYP")
	private	String	mecDevTyp;
	// 意向商户流水号
	@Column(name = "INT_MEC_SEQ_NO")
	private	String	intMecSeqNo;
	// 签约人
	@Column(name = "CONTOR")
	private	String	contor;
	// 签约人编号
	@Column(name = "CONTOR_NO")
	private	String	contorNo;
	// 商户拓展员名称
	@Column(name = "DEV_OFFICER_NM")
	private	String	devOfficerNm;
	// 商户拓展员编号
	@Column(name = "DEV_OFFICER_NO")
	private	String	devOfficerNo;
	// 业务人员
	@Column(name = "EMP_NM")
	private	String	empNm;
	// 业务人员编号
	@Column(name = "EMP_NO")
	private	String	empNo;
	// 运营经理编号
	@Column(name = "MEC_MANAGER_NO")
	private	String	mecManagerNo;
	// 机构编号（归属机构）
	@Column(name = "ORG_NO")
	private	String	orgNo;
	// 系统ID
	@Column(name = "SYS_ID")
	private	String	sysId;
	// 首次创建人编号
	@Column(name = "CTE_STFF_NO")
	private	String	cteStffNo;
	// 最后修改人编号
	@Column(name = "UTE_STFF_NO")
	private	String	uteStffNo;
	// 创建日期
	@Column(name = "DT_CTE")
	private	String	dtCte;
	// 修改日期
	@Column(name = "DT_UTE")
	private	String	dtUte;
	// 创建时间
	@Column(name = "TM_CTE")
	private	String	tmCte;
	// 修改时间
	@Column(name = "TM_UTE")
	private	String	tmUte;

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * UUID
	 * @return
	 */
	public String getUuid() {
		return uuid;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * 用户号
	 * @return
	 */
	public String getUsrId() {
		return usrId;
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

	public void setMecOperAttrNo(String mecOperAttrNo) {
		this.mecOperAttrNo = mecOperAttrNo;
	}
	/**
	 * 商户运营归属
	 * @return
	 */
	public String getMecOperAttrNo() {
		return mecOperAttrNo;
	}

	public void setMecBixzAttrNo(String mecBixzAttrNo) {
		this.mecBixzAttrNo = mecBixzAttrNo;
	}
	/**
	 * 商户业务归属
	 * @return
	 */
	public String getMecBixzAttrNo() {
		return mecBixzAttrNo;
	}

	public void setMecRcAttr(String mecRcAttr) {
		this.mecRcAttr = mecRcAttr;
	}
	/**
	 * 商户风控归属
	 * @return
	 */
	public String getMecRcAttr() {
		return mecRcAttr;
	}

	public void setMecDevTyp(String mecDevTyp) {
		this.mecDevTyp = mecDevTyp;
	}
	/**
	 * 商户拓展类型
	 * @return
	 */
	public String getMecDevTyp() {
		return mecDevTyp;
	}

	public void setIntMecSeqNo(String intMecSeqNo) {
		this.intMecSeqNo = intMecSeqNo;
	}
	/**
	 * 意向商户流水号
	 * @return
	 */
	public String getIntMecSeqNo() {
		return intMecSeqNo;
	}

	public void setContor(String contor) {
		this.contor = contor;
	}
	/**
	 * 签约人
	 * @return
	 */
	public String getContor() {
		return contor;
	}

	public void setContorNo(String contorNo) {
		this.contorNo = contorNo;
	}
	/**
	 * 签约人编号
	 * @return
	 */
	public String getContorNo() {
		return contorNo;
	}

	public void setDevOfficerNm(String devOfficerNm) {
		this.devOfficerNm = devOfficerNm;
	}
	/**
	 * 商户拓展员名称
	 * @return
	 */
	public String getDevOfficerNm() {
		return devOfficerNm;
	}

	public void setDevOfficerNo(String devOfficerNo) {
		this.devOfficerNo = devOfficerNo;
	}
	/**
	 * 商户拓展员编号
	 * @return
	 */
	public String getDevOfficerNo() {
		return devOfficerNo;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	/**
	 * 业务人员
	 * @return
	 */
	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	/**
	 * 业务人员编号
	 * @return
	 */
	public String getEmpNo() {
		return empNo;
	}

	public void setMecManagerNo(String mecManagerNo) {
		this.mecManagerNo = mecManagerNo;
	}
	/**
	 * 运营经理编号
	 * @return
	 */
	public String getMecManagerNo() {
		return mecManagerNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	/**
	 * 机构编号
	 * @return
	 */
	public String getOrgNo() {
		return orgNo;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	/**
	 * 系统ID
	 * @return
	 */
	public String getSysId() {
		return sysId;
	}

	public void setCteStffNo(String cteStffNo) {
		this.cteStffNo = cteStffNo;
	}
	/**
	 * 首次创建人编号
	 * @return
	 */
	public String getCteStffNo() {
		return cteStffNo;
	}

	public void setUteStffNo(String uteStffNo) {
		this.uteStffNo = uteStffNo;
	}
	/**
	 * 最后修改人编号
	 * @return
	 */
	public String getUteStffNo() {
		return uteStffNo;
	}
	public String getDtCte() {
		return dtCte;
	}
	public void setDtCte(String dtCte) {
		this.dtCte = dtCte;
	}
	public String getDtUte() {
		return dtUte;
	}
	public void setDtUte(String dtUte) {
		this.dtUte = dtUte;
	}
	public String getTmCte() {
		return tmCte;
	}
	public void setTmCte(String tmCte) {
		this.tmCte = tmCte;
	}
	public String getTmUte() {
		return tmUte;
	}
	public void setTmUte(String tmUte) {
		this.tmUte = tmUte;
	}
	@Override
	public String toString() {
		return "MecItnAttrIfPo [uuid=" + uuid + ", usrId=" + usrId + ", inMno=" + inMno + ", mecOperAttrNo=" + mecOperAttrNo + ", mecBixzAttrNo=" + mecBixzAttrNo + ", mecRcAttr="
				+ mecRcAttr + ", mecDevTyp=" + mecDevTyp + ", intMecSeqNo=" + intMecSeqNo + ", contor=" + contor + ", contorNo=" + contorNo + ", devOfficerNm=" + devOfficerNm
				+ ", devOfficerNo=" + devOfficerNo + ", empNm=" + empNm + ", empNo=" + empNo + ", mecManagerNo=" + mecManagerNo + ", orgNo=" + orgNo + ", sysId=" + sysId
				+ ", cteStffNo=" + cteStffNo + ", uteStffNo=" + uteStffNo + ", dtCte=" + dtCte + ", dtUte=" + dtUte + ", tmCte=" + tmCte + ", tmUte=" + tmUte + "]";
	}


	
}