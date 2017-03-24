/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 9:31
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils.Encryption;


import com.suixingpay.common.encryption.EncryptionType;
import com.suixingpay.common.encryption.EncryptionUtil;
import com.suixingpay.example.Utils.SpringContextUtil;

import java.util.Map;

/**
 * @Description: 加解密抽象类
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 9:31
 * @version: V1.0
 */
public abstract class AbstractEncrypt implements Encrypt {

    private static Map<String, Object> getCommonDataMap() {
        return SpringContextUtil.getBean("commonData");
    }
    public static String mosaicPhone(String phoneNo){
        return EncryptionUtil.mosaic(phoneNo, EncryptionType.PHONE);
    }

    public static String mosaicID(String id){
        return EncryptionUtil.mosaic(id,EncryptionType.ID);
    }

    public static String mosaicCard(String cardId){
        return EncryptionUtil.mosaic(cardId,EncryptionType.CARD);
    }

    public static String  mosaicName(String name){
        return EncryptionUtil.mosaic(name,EncryptionType.NAME);
    }

    protected String getKey(String keyName){
        return  (String) getCommonDataMap().get(keyName);
    }

}
