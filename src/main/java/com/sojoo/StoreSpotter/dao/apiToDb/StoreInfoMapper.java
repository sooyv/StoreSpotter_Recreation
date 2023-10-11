package com.sojoo.StoreSpotter.dao.apiToDb;

import com.sojoo.StoreSpotter.dto.apiToDb.StoreInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreInfoMapper {
    void insertStoreInfo(StoreInfo storeInfo);
}
