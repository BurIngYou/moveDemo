/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: huyou<hu_you@suixingpay.com> 
 * @date: 2017年3月16日 下午7:18:25   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams.core.target.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.suixingpay.etl.Cams.core.target.domain.MecOLIfPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;

/**  
 * @Description: 
 * @author: huyou<hu_you@suixingpay.com>
 * @date: 2017年3月16日 下午7:18:25
 * @version: V1.0
 */
public interface UmsMecOlRepository extends BaseRepository<MecOLIfPo,Integer>,JpaSpecificationExecutor<MecOLIfPo> {

}
