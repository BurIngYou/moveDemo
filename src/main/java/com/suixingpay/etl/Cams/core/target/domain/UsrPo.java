package com.suixingpay.etl.Cams.core.target.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.suixingpay.example.ChangeFlag;

/**
 * 基础用户
 * @author huyou
 *
 */
@Entity
@Table(name="UMS.T_UMS_USR")
@DynamicUpdate(true)
public class UsrPo {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USR_ID")
	private String usrId;//用户号
	
	@Column(name="PSN_CRP_FLG")
	@ChangeFlag(defaultValue ="2" )
	private String psnCrpFlg;//个企标志1:个人,2:企业
	
	@Column(name="USR_STS")
	@ChangeFlag(alise ="MEC_STS" )
	private String usrSts; //用户状态,00:正常 01:注销 02:停用 03:异常
	
	@Column(name="NM_CN")
	@ChangeFlag(alise = "CPR_REG_NM_CN")
	private String nmCn;//用户姓名（中文）
	
	@Column(name="SYS_ID")
	private String sysId;//来源系统ID
	
	@Column(name="CTE_DT")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@ChangeFlag(mergerDate ="DT_CTE@TM_CTE" )
	public Date cteDt; //创建时间
	
	@Column(name="UTE_DT")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@ChangeFlag(mergerDate ="DT_UTE@TM_UTE" )
	public Date uteDt; //修改时间
	
	@Column(name="CTE_OPR")
	@ChangeFlag(alise = "CTE_STFF_NO")
	public String cteOpr; //创建人	
	
	@Column(name="UTE_OPR")
	@ChangeFlag(alise = "UTE_STFF_NO")
	public String uteOpr; //修改人
	
	@Column(name="MBL_NO")
	@ChangeFlag(alise = "CONT_MBL_NO")
	public String mblNo;//手机号
	
	@Column(name="MAIL")
	@ChangeFlag(alise = "CONT_MAIL_ADDR")
	public String mail;//邮箱
	
	@Column(name="LOGIN_ID")
	public String loginId;//一账通
	
	@Column(name="REAL_AUTH_STS")
	public String realAuthSts;//实名认证状态(00:已实名,01:未实名)
	
	@Column(name="REG_SRC")
	public String regSrc;//注册来源
	
	@Column(name="LOCK_EXPIR_DT")//锁定账号失效日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date lockExpireDate;
	
	@Column(name="LOCK_REASON ")//锁定原因
	public String lockReason;
	

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getPsnCrpFlg() {
		return psnCrpFlg;
	}

	public void setPsnCrpFlg(String psnCrpFlg) {
		this.psnCrpFlg = psnCrpFlg;
	}

	public String getUsrSts() {
		return usrSts;
	}

	public void setUsrSts(String usrSts) {
		this.usrSts = usrSts;
	}

	public String getNmCn() {
		return nmCn;
	}

	public void setNmCn(String nmCn) {
		this.nmCn = nmCn;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public Date getCteDt() {
		return cteDt;
	}

	public void setCteDt(Date cteDt) {
		this.cteDt = cteDt;
	}

	public Date getUteDt() {
		return uteDt;
	}

	public void setUteDt(Date uteDt) {
		this.uteDt = uteDt;
	}

	public String getCteOpr() {
		return cteOpr;
	}

	public void setCteOpr(String cteOpr) {
		this.cteOpr = cteOpr;
	}

	public String getUteOpr() {
		return uteOpr;
	}

	public void setUteOpr(String uteOpr) {
		this.uteOpr = uteOpr;
	}

	public String getMblNo() {
		return mblNo;
	}

	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getRealAuthSts() {
		return realAuthSts;
	}

	public void setRealAuthSts(String realAuthSts) {
		this.realAuthSts = realAuthSts;
	}

	public String getRegSrc() {
		return regSrc;
	}

	public void setRegSrc(String regSrc) {
		this.regSrc = regSrc;
	}

	public Date getLockExpireDate() {
		return lockExpireDate;
	}

	public void setLockExpireDate(Date lockExpireDate) {
		this.lockExpireDate = lockExpireDate;
	}

	public String getLockReason() {
		return lockReason;
	}

	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}
	

}
