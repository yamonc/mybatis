package com.imooc.oa.dao;

import com.imooc.oa.entity.DealRecord;
import com.imooc.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
//处理记录
@Repository("dealRecordDao")
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    List<DealRecord> selectByClaimVoucher(int cvid);
}
