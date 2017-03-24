package com.suixingpay;

import com.suixingpay.example.Enum.DbType;
import com.suixingpay.example.Utils.CreateUtils;
import com.suixingpay.example.Utils.Encryption.EncryptFactory;
import com.suixingpay.example.Utils.Encryption.EncryptorEnum;
import com.suixingpay.example.Utils.SpringContextUtil;
import com.suixingpay.example.events.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configurable(autowire = Autowire.BY_NAME)
@ImportResource(value={"classpath:application-context.xml"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MyEtlApplication {

	private  static Logger LOGGER = LoggerFactory.getLogger(MyEtlApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyEtlApplication.class, args);
        LOGGER.info("---------spring boot执行完毕-----------");
        TestEvent event = new TestEvent(TestEvent.class, DbType.CAMS);
        SpringContextUtil.getContext().publishEvent(event);

    /*    String enStr = "710DC5D79B681B21FE701F18B172A94B";
        CreateUtils.encryption(EncryptorEnum.TYPE_WALLET, enStr);*/
	}
}
