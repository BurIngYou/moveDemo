package com.suixingpay.etl.Cams.core.target.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Description: 线上商户信息表 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author limin
 * Created on: 2017-03-04 16:25:11
 */
@Entity
@Table(name = "ums.T_UMS_MEC_OL_IF")
public class MecOLIfPo {
	// UUID
	@Id
	@Column(name = "UUID")
	private	String	uuid;
	// 用户编号
	@Column(name = "USR_ID")
	private	String	usrId;
	// 商户编号
	@Column(name = "MNO")
	private	String	mno;
	// 内部商编
	@Column(name = "IN_MNO")
	private	String	inMno;
	// 商户类型,00－普通商户 01:会生活，02：手刷商户,03在线支付商户
	@Column(name = "MEC_TYP")
	private	String	mecTyp;
	// 商户总分店标识：00-普通商户，01-连锁总店，02-连锁分店，03-1+N总店，04-1+N分店
	@Column(name = "MEC_TYPE_FLAG")
	private	String	mecTypeFlag;
	// 商户性质:01 国有02 股份制03 集体04 中外合资（合作）05 外商独资06 私营合伙07 私营独资08 个体09 其他10公司11个人独资
	@Column(name = "CPR_TYP")
	private	String	cprTyp;
	// 商户状态，01-正常，02-注销，03-冻结，00-异常
	@Column(name = "MEC_STS")
	private	String	mecSts;
	// 企业注册名称
	@Column(name = "CPR_REG_NM_CN")
	private	String	cprRegNmCn;
	// 经营名称（中文）
	@Column(name = "CPR_OPER_NM_CN")
	private	String	cprOperNmCn;
	// 签购单名称
	@Column(name = "MEC_DIS_NM")
	private	String	mecDisNm;
	// 银联归属地区码
	@Column(name = "CUP_CODE")
	private	String	cupCode;
	// 银联商户费率类型,01-县乡优惠，02-普通商户，03-三农商户
	@Column(name = "MEC_FEE_TYP")
	private	String	mecFeeTyp;
	// 法人名称
	@Column(name = "LEG_PER_NM")
	private	String	legPerNm;
	// 法人证件号码
	@Column(name = "LEG_PER_CRD_NO")
	private	String	legPerCrdNo;
	// 注册地址
	@Column(name = "CPR_REG_ADDR")
	private	String	cprRegAddr;
	// 手机号
	@Column(name = "CONT_TEL_NO")
	private	String	contTelNo;
	// 商户管理员手机号
	@Column(name = "MEC_ADMIN_TEL")
	private	String	mecAdminTel;
	// 所属国家
	@Column(name = "COUNTRY_CD")
	private	String	countryCd;
	// 所属行业
	@Column(name = "INDUSTRY")
	private	String	industry;
	// IP地址
	@Column(name = "IP_ADDRS")
	private	String	ipAddrs;
	// 网站地址
	@Column(name = "WEB_SITS")
	private	String	webSits;
	// 备案编号
	@Column(name = "RECORD_NUMBER")
	private	String	recordNumber;
	// 注册地址省编码
	@Column(name = "REG_ADDR_PROV")
	private	String	regAddrProv;
	// 注册地址市编码
	@Column(name = "REG_ADDR_CITY")
	private	String	regAddrCity;
	// 注册地址县编码
	@Column(name = "REG_ADDR_DIST")
	private	String	regAddrDist;
	// 注册地址街道信息
	@Column(name = "REG_ADDR_DESC")
	private	String	regAddrDesc;
	// 是否删除标识位
	@Column(name = "ATV_FLG")
	private	String	atvFlg;
	// 商户系统来源
	@Column(name = "SYS_ID")
	private	String	sysId;
	// 首次创建人编号。操作员编号。
	@Column(name = "CTE_STFF_NO")
	private	String	cteStffNo;
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
	// 注册邮箱
	@Column(name = "REG_MAIL")
	private	String	regMail;

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

	public void setMecTyp(String mecTyp) {
		this.mecTyp = mecTyp;
	}
	/**
	 * 商户类型,00－普通商户 01:会生活，02：手刷商户,03在线支付商户
	 * @return
	 */
	public String getMecTyp() {
		return mecTyp;
	}

	public void setMecTypeFlag(String mecTypeFlag) {
		this.mecTypeFlag = mecTypeFlag;
	}
	/**
	 * 商户总分店标识：00-普通商户，01-连锁总店，02-连锁分店，03-1+N总店，04-1+N分店
	 * @return
	 */
	public String getMecTypeFlag() {
		return mecTypeFlag;
	}

	public void setCprTyp(String cprTyp) {
		this.cprTyp = cprTyp;
	}
	/**
	 * 商户性质:01 国有02 股份制03 集体04 中外合资（合作）05 外商独资06 私营合伙07 私营独资08 个体09 其他10公司11个人独资
	 * @return
	 */
	public String getCprTyp() {
		return cprTyp;
	}

	public void setMecSts(String mecSts) {
		this.mecSts = mecSts;
	}
	/**
	 * 商户状态，01-正常，02-注销，03-冻结，00-异常
	 * @return
	 */
	public String getMecSts() {
		return mecSts;
	}

	public void setCprRegNmCn(String cprRegNmCn) {
		this.cprRegNmCn = cprRegNmCn;
	}
	/**
	 * 企业注册名称
	 * @return
	 */
	public String getCprRegNmCn() {
		return cprRegNmCn;
	}

	public void setCprOperNmCn(String cprOperNmCn) {
		this.cprOperNmCn = cprOperNmCn;
	}
	/**
	 * 经营名称（中文）
	 * @return
	 */
	public String getCprOperNmCn() {
		return cprOperNmCn;
	}

	public void setMecDisNm(String mecDisNm) {
		this.mecDisNm = mecDisNm;
	}
	/**
	 * 签购单名称
	 * @return
	 */
	public String getMecDisNm() {
		return mecDisNm;
	}

	public void setCupCode(String cupCode) {
		this.cupCode = cupCode;
	}
	/**
	 * 银联归属地区码
	 * @return
	 */
	public String getCupCode() {
		return cupCode;
	}

	public void setMecFeeTyp(String mecFeeTyp) {
		this.mecFeeTyp = mecFeeTyp;
	}
	/**
	 * 银联商户费率类型,01-县乡优惠，02-普通商户，03-三农商户
	 * @return
	 */
	public String getMecFeeTyp() {
		return mecFeeTyp;
	}

	public void setLegPerNm(String legPerNm) {
		this.legPerNm = legPerNm;
	}
	/**
	 * 法人名称
	 * @return
	 */
	public String getLegPerNm() {
		return legPerNm;
	}

	public void setLegPerCrdNo(String legPerCrdNo) {
		this.legPerCrdNo = legPerCrdNo;
	}
	/**
	 * 法人证件号码
	 * @return
	 */
	public String getLegPerCrdNo() {
		return legPerCrdNo;
	}

	public void setCprRegAddr(String cprRegAddr) {
		this.cprRegAddr = cprRegAddr;
	}
	/**
	 * 注册地址
	 * @return
	 */
	public String getCprRegAddr() {
		return cprRegAddr;
	}

	public void setContTelNo(String contTelNo) {
		this.contTelNo = contTelNo;
	}
	/**
	 * 手机号
	 * @return
	 */
	public String getContTelNo() {
		return contTelNo;
	}

	public void setMecAdminTel(String mecAdminTel) {
		this.mecAdminTel = mecAdminTel;
	}
	/**
	 * 商户管理员手机号
	 * @return
	 */
	public String getMecAdminTel() {
		return mecAdminTel;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}
	/**
	 * 所属国家
	 * @return
	 */
	public String getCountryCd() {
		return countryCd;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * 所属行业
	 * @return
	 */
	public String getIndustry() {
		return industry;
	}

	public void setIpAddrs(String ipAddrs) {
		this.ipAddrs = ipAddrs;
	}
	/**
	 * IP地址
	 * @return
	 */
	public String getIpAddrs() {
		return ipAddrs;
	}

	public void setWebSits(String webSits) {
		this.webSits = webSits;
	}
	/**
	 * 网站地址
	 * @return
	 */
	public String getWebSits() {
		return webSits;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	/**
	 * 备案编号
	 * @return
	 */
	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRegAddrProv(String regAddrProv) {
		this.regAddrProv = regAddrProv;
	}
	/**
	 * 注册地址省编码
	 * @return
	 */
	public String getRegAddrProv() {
		return regAddrProv;
	}

	public void setRegAddrCity(String regAddrCity) {
		this.regAddrCity = regAddrCity;
	}
	/**
	 * 注册地址市编码
	 * @return
	 */
	public String getRegAddrCity() {
		return regAddrCity;
	}

	public void setRegAddrDist(String regAddrDist) {
		this.regAddrDist = regAddrDist;
	}
	/**
	 * 注册地址县编码
	 * @return
	 */
	public String getRegAddrDist() {
		return regAddrDist;
	}

	public void setRegAddrDesc(String regAddrDesc) {
		this.regAddrDesc = regAddrDesc;
	}
	/**
	 * 注册地址街道信息
	 * @return
	 */
	public String getRegAddrDesc() {
		return regAddrDesc;
	}

	public void setAtvFlg(String atvFlg) {
		this.atvFlg = atvFlg;
	}
	/**
	 * 是否删除标识位
	 * @return
	 */
	public String getAtvFlg() {
		return atvFlg;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	/**
	 * 商户系统来源
	 * @return
	 */
	public String getSysId() {
		return sysId;
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

	public void setRegMail(String regMail) {
		this.regMail = regMail;
	}
	/**
	 * 注册邮箱
	 * @return
	 */
	public String getRegMail() {
		return regMail;
	}
}