package com.suixingpay.etl.Cams.core.source.dao;

import com.suixingpay.etl.Cams.core.source.domain.MecPo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;

public interface BapMecItnAttrIfRepository extends BaseRepository<MecPo,Integer>,JpaSpecificationExecutor<MecPo>{

}
