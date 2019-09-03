package com.imooc.oa.dao;

import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
//报销单条目
@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {
    void insert(ClaimVoucherItem claimVoucherItem);
    void update(ClaimVoucherItem claimVoucherItem);
    void delete(int id);
    List<ClaimVoucherItem> selectByClaimVoucher(int cvid);
}
