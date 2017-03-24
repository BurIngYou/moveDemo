/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 9:21
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils.Encryption;

/**
 * @Description: 加密/解密抽象接口
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 9:21
 * @version: V1.0
 */
public interface Encrypt {
    String encrypt(String encryField);
    String encryptIgnoreCase(String encryField);
    String decrypt(String decryField);
}
