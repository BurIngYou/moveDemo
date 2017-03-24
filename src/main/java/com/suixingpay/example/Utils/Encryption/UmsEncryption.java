/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 9:50
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils.Encryption;

import com.suixingpay.common.encryption.EncryptionUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: ums的加/解密工具
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 9:50
 * @version: V1.0
 */
public class UmsEncryption extends AbstractEncrypt {

    private static final String KEY_NAME = "encryptKey";

    private static UmsEncryption instance;

    private UmsEncryption() {
    }

    public static UmsEncryption getInstance() {
        if (null == instance) {
            instance = new UmsEncryption();
        }
        return instance;
    }

    @Override public String encrypt(String encryField) {
        return EncryptionUtil.encrypt(encryField, getKey(KEY_NAME));
    }

    @Override public String encryptIgnoreCase(String encryField) {
        return EncryptionUtil.encrypt(encryField.toUpperCase(), getKey(KEY_NAME));
    }

    @Override public String decrypt(String decryField) {
        if (StringUtils.isBlank(decryField)) {
            return StringUtils.EMPTY;
        }
        return EncryptionUtil.decrypt(decryField, getKey(KEY_NAME));
    }
}
