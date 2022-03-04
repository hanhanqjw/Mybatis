package com.lj.mybatis.dao;

import com.lj.mybatis.vo.Province;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/2/21 20/30
 */
public interface ProvinceDao {

    List<Province> selectProvinceList(Integer provinceId);
}
