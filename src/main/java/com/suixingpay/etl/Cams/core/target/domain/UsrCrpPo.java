package com.suixingpay.etl.Cams.core.target.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.suixingpay.example.ChangeFlag;

/**
 * 企业用户信息表
 * @author huyou
 *
 */
@Entity
@Table(name="UMS.T_UMS_USR_CRP")
public class UsrCrpPo {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USR_CRP_ID")
	@ChangeFlag(alise = "UUID")
	private String usrCrpId;//uuid
	
	@Column(name="USR_ID")
	private String usrId;//用户号
	
	@Column(name="NM_CN")
	@ChangeFlag(alise = "CPR_REG_NM_CN")
	private String nmCn;//注册名称(中文)
	
	@Column(name="NM_EN")
	@ChangeFlag(alise = "CPR_REG_NM_EN")
	private String nmEn;//注册名称(英文或拼音)
	
	@Column(name="CPR_TYP")
	private String cprTyp;//企业性质
	
	@Column(name="CPR_RAL")
	private String cprRal;//企业关系
	
	@Column(name="LEGAL_NM")
	@ChangeFlag(alise = "LEG_PER_NM")
	private String legalNm;//法人名称
	
	@Column(name="LEGAL_ID_TYPE")
	private String legalIdType;//法人证件类型
	
	@Column(name="LEGAL_ID_NO")
	@ChangeFlag(alise = "LEG_PER_CRD_NO")
	private String legalIdNo;//法人证件号
	
	@Column(name="LEGAL_ID_EXP")
	private String legalIdExp;//法人证件有效期
	
	@Column(name="OPER_ADDR")
	private String operAddr;//营业地址（省市区街道）
	
	@Column(name="BUSI_LIC_NO")
	private String busiLicNo;//营业执照号码
	
	@Column(name="BUSI_LIC_EXP")
	private String busiLicExp;//营业执照有效期 
	
	@Column(name="CONT_NM_CN")
	private String contNmCn;//联系人姓名（中文）
	
	@Column(name="CONT_NM_EN")
	private String contNmEn;//联系人姓名（英文或拼音）
	
	@Column(name="CONT_GENDAR")
	private String contGendar;//联系人性别
	
	@Column(name="CONT_TEL_NO")
	private String contTelNo;//联系人电话号码（固定电话）
	
	@Column(name="CONT_MBL_NO")
	private String contMblNo;//联系人手机号码
	
	@Column(name="CONT_MAIL_ADDR")
	private String contMailAddr;//联系人邮箱
	
	@Column(name="INDUSTRY_TYPE")
	@ChangeFlag(alise = "INDUSTRY")
	private String industryType;//行业类别

	public String getUsrCrpId() {
		return usrCrpId;
	}

	public void setUsrCrpId(String usrCrpId) {
		this.usrCrpId = usrCrpId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getNmCn() {
		return nmCn;
	}

	public void setNmCn(String nmCn) {
		this.nmCn = nmCn;
	}

	public String getNmEn() {
		return nmEn;
	}

	public void setNmEn(String nmEn) {
		this.nmEn = nmEn;
	}

	public String getCprTyp() {
		return cprTyp;
	}

	public void setCprTyp(String cprTyp) {
		this.cprTyp = cprTyp;
	}

	public String getCprRal() {
		return cprRal;
	}

	public void setCprRal(String cprRal) {
		this.cprRal = cprRal;
	}

	public String getLegalNm() {
		return legalNm;
	}

	public void setLegalNm(String legalNm) {
		this.legalNm = legalNm;
	}

	public String getLegalIdType() {
		return legalIdType;
	}

	public void setLegalIdType(String legalIdType) {
		this.legalIdType = legalIdType;
	}

	public String getLegalIdNo() {
		return legalIdNo;
	}

	public void setLegalIdNo(String legalIdNo) {
		this.legalIdNo = legalIdNo;
	}

	public String getLegalIdExp() {
		return legalIdExp;
	}

	public void setLegalIdExp(String legalIdExp) {
		this.legalIdExp = legalIdExp;
	}

	public String getOperAddr() {
		return operAddr;
	}

	public void setOperAddr(String operAddr) {
		this.operAddr = operAddr;
	}

	public String getBusiLicNo() {
		return busiLicNo;
	}

	public void setBusiLicNo(String busiLicNo) {
		this.busiLicNo = busiLicNo;
	}

	public String getBusiLicExp() {
		return busiLicExp;
	}

	public void setBusiLicExp(String busiLicExp) {
		this.busiLicExp = busiLicExp;
	}

	public String getContNmCn() {
		return contNmCn;
	}

	public void setContNmCn(String contNmCn) {
		this.contNmCn = contNmCn;
	}

	public String getContNmEn() {
		return contNmEn;
	}

	public void setContNmEn(String contNmEn) {
		this.contNmEn = contNmEn;
	}

	public String getContGendar() {
		return contGendar;
	}

	public void setContGendar(String contGendar) {
		this.contGendar = contGendar;
	}

	public String getContTelNo() {
		return contTelNo;
	}

	public void setContTelNo(String contTelNo) {
		this.contTelNo = contTelNo;
	}

	public String getContMblNo() {
		return contMblNo;
	}

	public void setContMblNo(String contMblNo) {
		this.contMblNo = contMblNo;
	}

	public String getContMailAddr() {
		return contMailAddr;
	}

	public void setContMailAddr(String contMailAddr) {
		this.contMailAddr = contMailAddr;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	@Override
	public String toString() {
		return "UsrCrpPo [usrCrpId=" + usrCrpId + ", usrId=" + usrId + ", nmCn=" + nmCn + ", nmEn=" + nmEn + ", cprTyp=" + cprTyp + ", cprRal=" + cprRal + ", legalNm=" + legalNm
				+ ", legalIdType=" + legalIdType + ", legalIdNo=" + legalIdNo + ", legalIdExp=" + legalIdExp + ", operAddr=" + operAddr + ", busiLicNo=" + busiLicNo
				+ ", busiLicExp=" + busiLicExp + ", contNmCn=" + contNmCn + ", contNmEn=" + contNmEn + ", contGendar=" + contGendar + ", contTelNo=" + contTelNo + ", contMblNo="
				+ contMblNo + ", contMailAddr=" + contMailAddr + ", industryType=" + industryType + ", getUsrCrpId()=" + getUsrCrpId() + ", getUsrId()=" + getUsrId()
				+ ", getNmCn()=" + getNmCn() + ", getNmEn()=" + getNmEn() + ", getCprTyp()=" + getCprTyp() + ", getCprRal()=" + getCprRal() + ", getLegalNm()=" + getLegalNm()
				+ ", getLegalIdType()=" + getLegalIdType() + ", getLegalIdNo()=" + getLegalIdNo() + ", getLegalIdExp()=" + getLegalIdExp() + ", getOperAddr()=" + getOperAddr()
				+ ", getBusiLicNo()=" + getBusiLicNo() + ", getBusiLicExp()=" + getBusiLicExp() + ", getContNmCn()=" + getContNmCn() + ", getContNmEn()=" + getContNmEn()
				+ ", getContGendar()=" + getContGendar() + ", getContTelNo()=" + getContTelNo() + ", getContMblNo()=" + getContMblNo() + ", getContMailAddr()=" + getContMailAddr()
				+ ", getIndustryType()=" + getIndustryType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
