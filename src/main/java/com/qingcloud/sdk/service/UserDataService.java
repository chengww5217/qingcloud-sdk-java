// +-------------------------------------------------------------------------
// | Copyright (C) 2016 Yunify, Inc.
// +-------------------------------------------------------------------------
// | Licensed under the Apache License, Version 2.0 (the "License");
// | you may not use this work except in compliance with the License.
// | You may obtain a copy of the License in the LICENSE file, or at:
// |
// | http://www.apache.org/licenses/LICENSE-2.0
// |
// | Unless required by applicable law or agreed to in writing, software
// | distributed under the License is distributed on an "AS IS" BASIS,
// | WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// | See the License for the specific language governing permissions and
// | limitations under the License.
// +-------------------------------------------------------------------------

package com.qingcloud.sdk.service;

import com.qingcloud.sdk.config.EnvContext;
import com.qingcloud.sdk.constants.QCConstant;
import com.qingcloud.sdk.model.OutputModel;
import com.qingcloud.sdk.request.ResponseCallBack;
import com.qingcloud.sdk.request.ResourceRequestFactory;
import com.qingcloud.sdk.exception.QCException;
import com.qingcloud.sdk.model.IaasParamBody;
import com.qingcloud.sdk.service.Types.*;
import com.qingcloud.sdk.annotation.ParamAnnotation;
import com.qingcloud.sdk.utils.QCStringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDataService {

    private EnvContext envContext;

    private String zone;

    public UserDataService(EnvContext envContext) {
        this.envContext = envContext;
    }

    public UserDataService(EnvContext envContext, String zone) {
        this.envContext = envContext;
        this.zone = zone;
    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/userdata/upload_userdata_attachment.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public UploadUserDataAttachmentOutput uploadUserDataAttachment(UploadUserDataAttachmentInput input) throws QCException {
        if (input == null) {
            input = new UploadUserDataAttachmentInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "UploadUserDataAttachment");
        context.put("APIName", "UploadUserDataAttachment");
        context.put("ServiceName", "UploadUserDataAttachment");
        context.put("RequestMethod", "POST");
        context.put("RequestURI", "/UploadUserDataAttachment");

        input.setAction("UploadUserDataAttachment");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,UploadUserDataAttachmentOutput.class);
        if(backModel != null){
            return (UploadUserDataAttachmentOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/userdata/upload_userdata_attachment.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void uploadUserDataAttachment(UploadUserDataAttachmentInput input, ResponseCallBack<UploadUserDataAttachmentOutput> callback) throws QCException {
        if (input == null) {
            input = new UploadUserDataAttachmentInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "UploadUserDataAttachment");
        context.put("APIName", "UploadUserDataAttachment");
        context.put("ServiceName", "UploadUserDataAttachment");
        context.put("RequestMethod", "POST");
        context.put("RequestURI", "/UploadUserDataAttachment");

        input.setAction("UploadUserDataAttachment");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class UploadUserDataAttachmentInput extends IaasParamBody {
        // Required
        private String attachmentContent;

        @ParamAnnotation(paramType = "query", paramName = "attachment_content")
        public void setAttachmentContent(String attachmentContent) {
            this.attachmentContent = attachmentContent;
        }

        @ParamAnnotation(paramType = "query", paramName = "attachment_content")
        public String getAttachmentContent() {
            return this.attachmentContent;
        }

        private String attachmentName;

        @ParamAnnotation(paramType = "query", paramName = "attachment_name")
        public void setAttachmentName(String attachmentName) {
            this.attachmentName = attachmentName;
        }

        @ParamAnnotation(paramType = "query", paramName = "attachment_name")
        public String getAttachmentName() {
            return this.attachmentName;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getAttachmentContent())) {
                throw new QCException("AttachmentContent is required");
            }
            return null;
        }
    }

    public static class UploadUserDataAttachmentOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String attachmentID;

        @ParamAnnotation(paramType = "query", paramName = "attachment_id")
        public void setAttachmentID(String attachmentID) {
            this.attachmentID = attachmentID;
        }

        @ParamAnnotation(paramType = "query", paramName = "attachment_id")
        public String getAttachmentID() {
            return this.attachmentID;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }}



















