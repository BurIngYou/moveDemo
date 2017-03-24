/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 13:45
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils.Encryption;

import com.suixingpay.common.encryption.EncryptionUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 钱包md5加密/解密方式
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 13:45
 * @version: V1.0
 */
public class WalletEncryption extends AbstractEncrypt {

    private static final String KEY_NAME = "walletKey";

    private static WalletEncryption instance;

    private WalletEncryption() {
    }

    public static WalletEncryption getInstance() {
        if (null == instance) {
            instance = new WalletEncryption();
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
