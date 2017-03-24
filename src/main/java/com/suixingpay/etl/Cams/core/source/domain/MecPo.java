package com.suixingpay.etl.Cams.core.source.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Description: 商户基础表 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author huyou
 * Created on: 2017-02-21 15:46:53
 */
@Entity
@Table(name = "bap.T_BAP_MEC_ITN_ATTR_IF")
public class MecPo {
	// 用户编号
	@Id
	@Column(name = "UUID")
	private	String	uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

  
	
	
	
	
}
