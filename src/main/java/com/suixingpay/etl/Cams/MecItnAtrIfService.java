/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.suixingpay.etl.Cams.core.source.dao.BapMecItnAttrIfRepository;
import com.suixingpay.etl.Cams.core.target.dao.UmsMecItnAttrIfRepository;
import com.suixingpay.etl.Cams.core.target.dao.UmsMecOlContactsRepository;
import com.suixingpay.etl.Cams.core.target.dao.UmsMecOlRepository;
import com.suixingpay.etl.Cams.core.target.dao.UmsMecRepository;
import com.suixingpay.etl.Cams.core.target.dao.UmsUsrCrpRepository;
import com.suixingpay.etl.Cams.core.target.dao.UmsUsrProdBindRepository;
import com.suixingpay.etl.Cams.core.target.dao.UmsUsrRepository;
import com.suixingpay.etl.Cams.core.target.domain.MecItnAttrIfPo;
import com.suixingpay.etl.Cams.core.target.domain.MecOLContactsPo;
import com.suixingpay.etl.Cams.core.target.domain.MecOLIfPo;
import com.suixingpay.etl.Cams.core.target.domain.MecPo;
import com.suixingpay.etl.Cams.core.target.domain.UsrCrpPo;
import com.suixingpay.etl.Cams.core.target.domain.UsrPo;
import com.suixingpay.etl.Cams.core.target.domain.UsrProdBindPo;
import com.suixingpay.example.Enum.DbType;
import com.suixingpay.example.Utils.CreateUtils;
import com.suixingpay.example.events.TestEvent;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @version: V1.0
 */
@Service
public class MecItnAtrIfService {

    private static Logger LOGGER = LoggerFactory.getLogger(MecItnAtrIfService.class);

    @Autowired
    private BapMecItnAttrIfRepository bapMecItnAttrIfRepository; // 目的，domain

    @Autowired
    private UmsMecItnAttrIfRepository umsMecItnAttrIfRepository;// 只需要一写
    @Autowired
    private UmsMecOlRepository umsMecOlRepository;

    @Autowired
    private UmsMecOlContactsRepository umsMecOlContactsRepository;

    @Autowired
    private UmsUsrCrpRepository umsUsrCrpRepository;

    @Autowired
    private UmsMecRepository umsMecRepository;
    @Autowired
    private UmsUsrRepository umsUsrRepository;

    @Autowired
    private UmsUsrProdBindRepository umsUsrProdBindRepository;

    @EventListener
    @Async
    public void start(TestEvent readyEvent) {
        if (DbType.CAMS != readyEvent.getId()) {
            return;
        }

        LOGGER.info("====================商户内部归属迁移开始!============================");
        String mecItnAttrSql = "SELECT * FROM  BAP.T_BAP_MEC_ITN_ATTR_IF where IN_MNO in (SElECT IN_MNO FROM BAP.T_BAP_MEC_IF WHERE MEC_TYP = '03') and rownum <=10 ";
        CreateUtils.StoT(MecItnAttrIfPo.class, umsMecItnAttrIfRepository, mecItnAttrSql);
        LOGGER.info("====================商户内部归属迁移完成!============================");

        LOGGER.info("====================Ol商户信息表迁移开始!============================");
        String mecOlSql = "select t1.UUID,t1.USR_ID,t1.MNO,t1.IN_MNO,t1.MEC_TYP,t1.MEC_TYPE_FLAG,t1.CPR_TYP,t1.MEC_STS,t1.CPR_REG_NM_CN,"
                + "t1.CPR_OPER_NM_CN,t1.MEC_DIS_NM,t1.CUP_CODE,t1.MEC_FEE_TYP,t1.ATV_FLG,t1.SYS_ID,t1.CTE_STFF_NO,t1.DT_CTE,t1.TM_CTE,t1.DT_UTE,t1.TM_UTE,"
                + "t2.LEG_PER_NM,t2.LEG_PER_CRD_NO,t2.CPR_REG_ADDR,t2.CONT_TEL_NO,t2.MEC_ADMIN_TEL,"
                + "t3.COUNTRY_CD,t3.INDUSTRY,t3.IP_ADDRS,t3.WEB_SITS,t3.RECORD_NUMBER,t3.REG_ADDR_PROV,t3.REG_ADDR_CITY,t3.REG_ADDR_DIST,t3.REG_ADDR_DESC,t4.REG_MAIL "
                + "from BAP.T_BAP_MEC_IF t1 , BAP.T_BAP_MEC_IF_DETAIL t2,BAP.T_BAP_OL_PAY_MEC_INF t3,OBM.T_OBM_USR_INFO t4 where t1.in_mno = t2.in_mno and t2.in_mno = t3.in_mno and  "
                + "t3.in_mno = t4.in_mno and t1.mec_typ = '03'";
        CreateUtils.StoT(MecOLIfPo.class, umsMecOlRepository, mecOlSql);
        LOGGER.info("====================Ol商户信息表迁移结束!============================");

        LOGGER.info("====================线上商户联系人信息表迁移开始!============================");
        String mecOlContactsSql = "select t1.MNO,t2.UUID,t1.USR_ID,t2.IN_MNO,t2.NAME,t2.JOB,t2.TEL,t2.SNO,t2.CTE_STFF_NO,t2.UTE_STFF_NO,t2.DT_CTE,t2.TM_CTE,t2.DT_UTE,t2.TM_UTE from  BAP.T_BAP_MEC_IF t1 ,"
                + "BAP.T_BAP_OL_PAY_MEC_LINK t2 where t1.in_mno = t2.in_mno and t1.mec_typ = '03'";
        CreateUtils.StoT(MecOLContactsPo.class, umsMecOlContactsRepository, mecOlContactsSql);
        LOGGER.info("====================线上商户联系人信息表迁移结束!============================");

        LOGGER.info("====================商户基础信息表迁移开始!============================");
        String mecOlMecSql = "select t1.USR_ID,t1.MNO,t1.IN_MNO,t1.CPR_REG_NM_CN,t1.MEC_STS,t1.DT_CTE,t1.TM_CTE,t1.DT_UTE,"
                + "t1.TM_UTE,t1.MEC_TYP,t2.MEC_ADMIN_TEL from BAP.T_BAP_MEC_IF t1,BAP.T_BAP_MEC_IF_DETAIL t2 where t1.in_mno = t2.in_mno and t1.mec_typ = '03'";
        CreateUtils.StoT(MecPo.class, umsMecRepository, mecOlMecSql);
        LOGGER.info("====================商户基础信息表迁移结束!============================");

        LOGGER.info("====================企业用户信息表迁移开始!============================");
        String mecOlUsrCrpSql = "select t1.UUID,t1.USR_ID,t1.CPR_REG_NM_CN,t1.CPR_REG_NM_EN,"
                + "t1.CPR_TYP,t2.LEG_PER_NM,t2.LEG_PER_CRD_NO,t1.OPER_ADDR,t1.CONT_NM_CN,"
                + "t1.CONT_NM_EN,t1.CONT_GENDAR,t1.CONT_TEL_NO,t1.CONT_MBL_NO,t1.CONT_MAIL_ADDR,t3.INDUSTRY"
                + " from BAP.T_BAP_USR_IF_CRP t1,BAP.T_BAP_MEC_IF_DETAIL t2,BAP.T_BAP_OL_PAY_MEC_INF t3,BAP.T_BAP_MEC_IF t4 WHERE "
                + "t1.USR_ID = t4.USR_ID AND t2.in_mno = t4.in_mno and t3.in_mno = t4.in_mno and t4.mec_typ = '03'";
        CreateUtils.StoT(UsrCrpPo.class, umsUsrCrpRepository, mecOlUsrCrpSql);
        LOGGER.info("====================企业用户信息表迁移结束!============================");

        LOGGER.info("====================产品绑定表迁移开始!============================");

        String mecOlUsrBindSql = "select t1.USR_ID,t1.IN_MNO,t1.SYS_ID,t1.DT_CTE,"
                + "t1.TM_CTE,t1.DT_UTE,t1.TM_UTE,t1.CTE_STFF_NO from BAP.T_BAP_MEC_IF t1 " + " where t1.mec_typ = '03'";
        CreateUtils.StoT(UsrProdBindPo.class, umsUsrProdBindRepository, mecOlUsrBindSql);

        LOGGER.info("====================产品绑定表迁移结束!============================");

        LOGGER.info("====================基础用户信息表迁移开始!============================");
        String mecOlUsrSql = "select t2.USR_ID,t1.MEC_STS,t2.CPR_REG_NM_CN,"
                + "t2.SYS_ID,t1.DT_CTE,t1.TM_CTE,t1.DT_UTE,t1.TM_UTE,t2.CTE_STFF_NO,"
                + "t2.UTE_STFF_NO,t2.CONT_MBL_NO,t2.CONT_MAIL_ADDR from  "
                + "BAP.T_BAP_MEC_IF t1,BAP.T_BAP_USR_IF_CRP t2 where t1.USR_ID = t2.USR_ID and t1.mec_typ = '03'";
        CreateUtils.StoT(UsrPo.class, umsUsrRepository, mecOlUsrSql);
        LOGGER.info("====================基础用户信息表迁移结束!============================");
    }

}
