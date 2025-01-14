/*
 * Copyright 2019 WeBank
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.webank.wedatasphere.dss.appconn.qualitis.project;

import com.webank.wedatasphere.dss.appconn.qualitis.QualitisAppConn;
import com.webank.wedatasphere.dss.standard.app.sso.request.SSORequestOperation;
import com.webank.wedatasphere.dss.standard.app.structure.project.*;
import org.apache.linkis.httpclient.request.HttpAction;
import org.apache.linkis.httpclient.response.HttpResult;

/**
 * @author allenzhou@webank.com
 * @date 2021/6/21 14:40
 */
public class QualitisProjectService extends ProjectService {

    @Override
    public boolean isCooperationSupported() {
        return true;
    }

    @Override
    public boolean isProjectNameUnique() {
        return false;
    }

    @Override
    public QualitisProjectCreationOperation createProjectCreationOperation() {
        SSORequestOperation<HttpAction, HttpResult> ssoRequestOperation = getSSORequestService().createSSORequestOperation(QualitisAppConn.QUALITIS_APPCONN_NAME);
        QualitisProjectCreationOperation qualitisProjectCreationOperation = new QualitisProjectCreationOperation(this, ssoRequestOperation);
        qualitisProjectCreationOperation.setStructureService(this);
        return qualitisProjectCreationOperation;
    }

    @Override
    public ProjectUpdateOperation createProjectUpdateOperation() {
        SSORequestOperation<HttpAction, HttpResult> ssoRequestOperation = getSSORequestService().createSSORequestOperation(QualitisAppConn.QUALITIS_APPCONN_NAME);
        QualitisProjectUpdateOperation qualitisProjectUpdateOperation = new QualitisProjectUpdateOperation(this, ssoRequestOperation);
        qualitisProjectUpdateOperation.setStructureService(this);
        return qualitisProjectUpdateOperation;
    }

    @Override
    public ProjectDeletionOperation createProjectDeletionOperation() {
        return null;
    }

    @Override
    public ProjectUrlOperation createProjectUrlOperation() {
        return null;
    }

}
