package com.mmlgo.yh.service;

import com.mmlgo.yh.models.ProjectMaster;
import com.mmlgo.yh.models.TempRate;

import java.util.List;

public interface IProjectService {
    ProjectMaster GetProjectMasterBySysNo(int sysNo);

    int InsertTemp_rate(TempRate rate);

    int BatchInsertTemp_rate(List<TempRate> list);
}
