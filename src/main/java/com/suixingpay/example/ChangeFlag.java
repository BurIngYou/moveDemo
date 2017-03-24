/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 21:01
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example;

import com.suixingpay.example.Enum.CreateEnum;
import com.suixingpay.example.Utils.Encryption.EncryptorEnum;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description: TODO
 * @author: huyou<yang_huang@suixingpay.com>
 * @date: 2017/3/15 21:01
 * @version: V1.0
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface ChangeFlag {

    /**
     * 来源表的字段名，当字段名称不同时使用
     * @return
     */
    String alise() default "";

    /**
     * 固定值
     * @return
     */
    String defaultValue() default "";

    /**
     * 系统创建，一般是生成主键
     * @return
     */
    CreateEnum systemCreate() default CreateEnum.TYPE_NONE;

    EncryptorEnum encryptType() default EncryptorEnum.TYPE_NONE;
    
    /**
     * date合并 格式:cName1@cName2
     * cName1为日期
     * cName2为时间
     * @return Date格式的日期
     */
    String mergerDate() default "";
    
    String switchType() default "";
   
 

    
    
}
