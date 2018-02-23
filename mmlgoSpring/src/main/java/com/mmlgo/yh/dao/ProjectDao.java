package com.mmlgo.yh.dao;

import com.mmlgo.yh.models.ProjectMaster;
import com.mmlgo.yh.models.TempRate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectDao {
    //@Select("select * from ProjectMaster where SysNo = #{sysNo}")
    ProjectMaster getProjectMasterBySysNo(@Param("sysNo") int sysNo);

//    @Insert("insert into users (userId,pwd) values (#{userId},#{pwd})")
//    boolean insertUsers (@Param("userId") String userId, @Param("pwd") String pwd);

    int insertTemp_rate(TempRate rate);

    //批量插入
    int batchInsertTemp_rate(@Param("list") List<TempRate> list);
}