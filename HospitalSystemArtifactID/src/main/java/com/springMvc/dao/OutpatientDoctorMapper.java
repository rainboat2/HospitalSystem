package com.springMvc.dao;

import com.springMvc.entity.po.OutpatientDoctor;
import com.springMvc.entity.vo.RegistrationDoctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutpatientDoctorMapper {
    int deleteByPrimaryKey(Integer odId);

    int insert(OutpatientDoctor record);

    int insertSelective(OutpatientDoctor record);

    OutpatientDoctor selectByPrimaryKey(Integer odId);

    int updateByPrimaryKeySelective(OutpatientDoctor record);

    int updateByPrimaryKey(OutpatientDoctor record);

    // 选中所有的医生，并将其对应的信息转载到RegistrationDoctor类中
    List<RegistrationDoctor> selectDoctors(@Param("deptId") int deptId, @Param("reglCode") String reglCode);
}