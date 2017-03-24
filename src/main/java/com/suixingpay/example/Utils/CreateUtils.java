/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 22:06
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.suixingpay.etl.Cams.core.source.dao.BapMecItnAttrIfRepository;
import com.suixingpay.example.ChangeFlag;
import com.suixingpay.example.Enum.CreateEnum;
import com.suixingpay.example.Utils.Encryption.AbstractEncrypt;
import com.suixingpay.example.Utils.Encryption.EncryptFactory;
import com.suixingpay.example.Utils.Encryption.EncryptorEnum;
import com.suixingpay.turbo.framework.core.util.time.DateFormatUtils;
import com.suixingpay.turbo.framework.jpa.annotation.DS;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 22:06
 * @version: V1.0
 */
public class CreateUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(CreateUtils.class);

    private static AbstractEncrypt umsEnc = EncryptFactory.getEncryption(EncryptorEnum.TYPE_UMS);

   

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getStringValue(Object value) throws Exception {
        if (null == value) {
            return null;
        }

        if (value instanceof String) {
            return (String) value;
        }

        if (value instanceof Character) {
            Character cValue = (Character) value;
            return cValue.toString();
        }

        if (value instanceof Date) { // 日期的处理

            return sdf.format(value);
        }

        throw new Exception("类型不匹配");
    }

    
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**
     * @param targetClazz 目标数据表的domain
     * @param tagretResp 目标数据表的do
     * @param sql 源数据库的sql查询语句
     * @param <T> 目标数据表的domain类
     */
    @Transactional
    @DS(name = "write")
    public static <T extends BaseRepository, S> void StoT(Class<S> targetClazz, T tagretResp, String sql) {
        LOGGER.info("-----------开始执行数据转换------------------");
        Map<String, Object> params = new HashMap<String, Object>();
        List<S> saved;

        // // TODO: 2017/3/16 改变源数据时替换该类 UapTClassRepository
        saved = SpringContextUtil
                .getContext()
                .getBean(BapMecItnAttrIfRepository.class)
                .findBySQL(sql, params)
                .stream()
                .map(obj -> {
                    S bapTableClass = null;
                    try {
                        bapTableClass = targetClazz.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    // // 2017/3/15 对象的转换
                    S finalBapTableClass = bapTableClass;
                    // <editor-fold desc="反射操作">
                    Arrays.stream(targetClazz.getDeclaredFields()).forEach(
                            field -> {
                                field.setAccessible(true);
                                try {
                                    ChangeFlag changeType = field.getAnnotation(ChangeFlag.class);
                                    Column column = field.getAnnotation(Column.class);
                                    String columnName;
                                    Object columnValue;

                                    if (null == changeType) {
                                        columnName = column.name();
                                        columnValue = obj.get(columnName);
                                    } else {

                                        columnName = !StringUtils.isEmpty(changeType.alise()) ? changeType.alise()
                                                : column.name();
                                        columnValue = !StringUtils.isEmpty(changeType.defaultValue()) ? changeType
                                                .defaultValue() : obj.get(columnName);

                                        CreateEnum createType = changeType.systemCreate();
                                        if (CreateEnum.TYPE_NONE != createType) {
                                            columnValue = CreateUtils.create(createType);
                                        }

                                        EncryptorEnum encType = changeType.encryptType();
                                        if (EncryptorEnum.TYPE_NONE != encType) {
                                            columnValue = CreateUtils.encryption(encType, columnValue);
                                        }

                                        String merger = changeType.mergerDate();
                                        if (!StringUtils.isEmpty(merger)) {
                                            String[] cNames = merger.split("@");
                                            String dateValue = getStringValue(obj.get(cNames[0]));
                                            String timeValue = getStringValue(obj.get(cNames[1]));
                                            columnValue = mergeDateStr(dateValue, timeValue);
                                        }
                                        
                                        String switchStr = changeType.switchType();
                                        if (!StringUtils.isEmpty(switchStr)){
                                            columnValue = switchState(switchStr,columnValue);
                                        }


                                    }
                                    field.set(finalBapTableClass, columnValue);
                                } catch (Exception e) {
                                    LOGGER.info("发生错误！" + e);
                                }

                            });
                    // </editor-fold>
                    LOGGER.info("转换结果,{}", bapTableClass.toString());
                    return bapTableClass;
                }).collect(Collectors.toList());

        LOGGER.info("数据={}", saved.toString());
        List resList = tagretResp.save(saved);
        LOGGER.info("save结束，影响{}条数据", resList.toString());
    }

    /**
     * 加解密工具
     * 
     * @param sourceEncType
     * @param columnValue
     * @return
     */
    public static Object encryption(EncryptorEnum sourceEncType, Object columnValue) {

        AbstractEncrypt sourceEnc = EncryptFactory.getEncryption(sourceEncType);
        String decryptStr = sourceEnc.decrypt(String.valueOf(columnValue));
        LOGGER.info("原文{}", decryptStr);

        return umsEnc.encrypt(decryptStr);
    }

    /**
     * 将数据表中的 date合并 cName1为日期 varchar类型 cName2为时间 varchar类型
     * 
     * @param obj
     * @param merger 格式:cName1@cName2
     * @throws ParseException
     */
    public static Date mergeDateStr(String dateValue, String timeValue) throws ParseException {
        dateValue = StringUtils.isEmpty(dateValue) ? DateUtils.getDateNoSeparator() : dateValue;
        timeValue = StringUtils.isEmpty(timeValue) ? DateUtils.getTimeNoSeparator() : timeValue;
        String dateStr = dateValue + timeValue;
        Date res = DateFormatUtils.pareDate("yyyyMMddHHmmss", dateStr);
        LOGGER.info("合并后的date={}", res.toString());
        return res;
    }
    
    public static synchronized Object create(CreateEnum type) {
        switch (type){
            case TYPE_UUID:
                return getUUID();
            default:
                return "default";
        }
    }
    
    /**
     * 转换状态，标识字段必须为varchar或char类型,如果字段为空，默认为现标识的正常值
     * 可以与 alise 共存
     * 格式 "源标识-现标识;源标识-现标识"
     * eg "01-00;00-01"
     * 源标识 01正常，00异常
     * 现标识 00正常，01异常
     * @return
     */
    public static String switchState(String switchStr, Object columnValue) {
        String res ;
        Map<String,String> stsMap = new HashMap<>();
        String[] dValue = switchStr.split("%");
        String[] strList = dValue[0].split(";");
        for (String str : strList) {
            String[] oAnList = str.split("-");
            stsMap.put(oAnList[0],oAnList[1]);
        }
        if (StringUtils.isEmpty(columnValue)){
            res = dValue[1];
        }else {
            res =  stsMap.get(columnValue);
        }

        LOGGER.info("转换后的标识{},转换规则{},默认值{}",res,stsMap.toString(),dValue[1]);
        return res;
    }


}
