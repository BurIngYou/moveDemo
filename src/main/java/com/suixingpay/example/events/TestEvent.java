/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/16 11:34
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.events;

import com.suixingpay.example.Enum.DbType;
import org.springframework.context.ApplicationEvent;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/16 11:34
 * @version: V1.0
 */
public class TestEvent extends ApplicationEvent  {
    DbType id;

    public TestEvent(Object source,DbType id) {
        super(source);
        this.id = id;
    }

    public DbType getId() {
        return id;
    }
}
