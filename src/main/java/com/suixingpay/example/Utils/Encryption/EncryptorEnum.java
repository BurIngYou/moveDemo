/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 13:55
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils.Encryption;

/**
 * @Description: 加解密相关枚举
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 13:55
 * @version: V1.0
 */
public enum EncryptorEnum {

    TYPE_NONE("",""),
    TYPE_UMS("ums","ums"),
    TYPE_WALLET("wallet","钱包"),
    ;

    private String value;
    private String displayName;


    private EncryptorEnum(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }


    public String getValue() {

        return value;
    }


    public String getDisplayName() {

        return displayName;
    }

}
