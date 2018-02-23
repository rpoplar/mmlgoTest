package com.mmlgo.yh.service;

import com.mmlgo.yh.models.ProjectMaster;
import com.mmlgo.yh.dao.ProjectDao;
import com.mmlgo.yh.models.TempRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private ProjectDao projectDA;

    @Override
    public ProjectMaster GetProjectMasterBySysNo(int sysNo) {
        ProjectMaster projectMaster = this.projectDA.getProjectMasterBySysNo(sysNo);
        return projectMaster;
    }

    @Override
    public int InsertTemp_rate(TempRate rate) {
        return this.projectDA.insertTemp_rate(rate);
    }

    @Override
    public int BatchInsertTemp_rate(List<TempRate> list) {
        return this.projectDA.batchInsertTemp_rate(list);
    }
}