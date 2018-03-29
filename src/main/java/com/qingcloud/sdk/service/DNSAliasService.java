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

public class DNSAliasService {

    private EnvContext envContext;

    private String zone;

    public DNSAliasService(EnvContext envContext) {
        this.envContext = envContext;
    }

    public DNSAliasService(EnvContext envContext, String zone) {
        this.envContext = envContext;
        this.zone = zone;
    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/dns_alias/associate_dns_alias.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public AssociateDNSAliasOutput associateDNSAlias(AssociateDNSAliasInput input) throws QCException {
        if (input == null) {
            input = new AssociateDNSAliasInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "AssociateDNSAlias");
        context.put("APIName", "AssociateDNSAlias");
        context.put("ServiceName", "AssociateDNSAlias");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/AssociateDNSAlias");

        input.setAction("AssociateDNSAlias");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,AssociateDNSAliasOutput.class);
        if(backModel != null){
            return (AssociateDNSAliasOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/dns_alias/associate_dns_alias.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void associateDNSAlias(AssociateDNSAliasInput input, ResponseCallBack<AssociateDNSAliasOutput> callback) throws QCException {
        if (input == null) {
            input = new AssociateDNSAliasInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "AssociateDNSAlias");
        context.put("APIName", "AssociateDNSAlias");
        context.put("ServiceName", "AssociateDNSAlias");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/AssociateDNSAlias");

        input.setAction("AssociateDNSAlias");
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

    public static class AssociateDNSAliasInput extends IaasParamBody {
        // Required
        private String prefix;

        @ParamAnnotation(paramType = "query", paramName = "prefix")
        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        @ParamAnnotation(paramType = "query", paramName = "prefix")
        public String getPrefix() {
            return this.prefix;
        }

        // Required
        private String resource;

        @ParamAnnotation(paramType = "query", paramName = "resource")
        public void setResource(String resource) {
            this.resource = resource;
        }

        @ParamAnnotation(paramType = "query", paramName = "resource")
        public String getResource() {
            return this.resource;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getPrefix())) {
                throw new QCException("Prefix is required");
            }
            if (QCStringUtil.isEmpty(this.getResource())) {
                throw new QCException("Resource is required");
            }
            return null;
        }
    }

    public static class AssociateDNSAliasOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String dNSAliasID;

        @ParamAnnotation(paramType = "query", paramName = "dns_alias_id")
        public void setDNSAliasID(String dNSAliasID) {
            this.dNSAliasID = dNSAliasID;
        }

        @ParamAnnotation(paramType = "query", paramName = "dns_alias_id")
        public String getDNSAliasID() {
            return this.dNSAliasID;
        }

        private String domainName;

        @ParamAnnotation(paramType = "query", paramName = "domain_name")
        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        @ParamAnnotation(paramType = "query", paramName = "domain_name")
        public String getDomainName() {
            return this.domainName;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
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

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/dns_alias/describe_dns_aliases.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public DescribeDNSAliasesOutput describeDNSAliases(DescribeDNSAliasesInput input) throws QCException {
        if (input == null) {
            input = new DescribeDNSAliasesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeDNSAliases");
        context.put("APIName", "DescribeDNSAliases");
        context.put("ServiceName", "DescribeDNSAliases");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeDNSAliases");

        input.setAction("DescribeDNSAliases");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,DescribeDNSAliasesOutput.class);
        if(backModel != null){
            return (DescribeDNSAliasesOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/dns_alias/describe_dns_aliases.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void describeDNSAliases(DescribeDNSAliasesInput input, ResponseCallBack<DescribeDNSAliasesOutput> callback) throws QCException {
        if (input == null) {
            input = new DescribeDNSAliasesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeDNSAliases");
        context.put("APIName", "DescribeDNSAliases");
        context.put("ServiceName", "DescribeDNSAliases");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeDNSAliases");

        input.setAction("DescribeDNSAliases");
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

    public static class DescribeDNSAliasesInput extends IaasParamBody {
        private List<String> dNSAliases;

        @ParamAnnotation(paramType = "query", paramName = "dns_aliases")
        public void setDNSAliases(List<String> dNSAliases) {
            this.dNSAliases = dNSAliases;
        }

        @ParamAnnotation(paramType = "query", paramName = "dns_aliases")
        public List<String> getDNSAliases() {
            return this.dNSAliases;
        }

        private Integer limit;

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public Integer getLimit() {
            return this.limit;
        }

        private Integer offset;

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public Integer getOffset() {
            return this.offset;
        }

        private String resourceID;

        @ParamAnnotation(paramType = "query", paramName = "resource_id")
        public void setResourceID(String resourceID) {
            this.resourceID = resourceID;
        }

        @ParamAnnotation(paramType = "query", paramName = "resource_id")
        public String getResourceID() {
            return this.resourceID;
        }

        private String searchWord;

        @ParamAnnotation(paramType = "query", paramName = "search_word")
        public void setSearchWord(String searchWord) {
            this.searchWord = searchWord;
        }

        @ParamAnnotation(paramType = "query", paramName = "search_word")
        public String getSearchWord() {
            return this.searchWord;
        }

        public String validateParam() throws QCException {
            return null;
        }
    }

    public static class DescribeDNSAliasesOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private List<DNSAliasModel> dNSAliasSet;

        @ParamAnnotation(paramType = "query", paramName = "dns_alias_set")
        public void setDNSAliasSet(List<DNSAliasModel> dNSAliasSet) {
            this.dNSAliasSet = dNSAliasSet;
        }

        @ParamAnnotation(paramType = "query", paramName = "dns_alias_set")
        public List<DNSAliasModel> getDNSAliasSet() {
            return this.dNSAliasSet;
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

        private Integer totalCount;

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public Integer getTotalCount() {
            return this.totalCount;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/dns_alias/dissociate_dns_aliases.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public DissociateDNSAliasesOutput dissociateDNSAliases(DissociateDNSAliasesInput input) throws QCException {
        if (input == null) {
            input = new DissociateDNSAliasesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DissociateDNSAliases");
        context.put("APIName", "DissociateDNSAliases");
        context.put("ServiceName", "DissociateDNSAliases");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DissociateDNSAliases");

        input.setAction("DissociateDNSAliases");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,DissociateDNSAliasesOutput.class);
        if(backModel != null){
            return (DissociateDNSAliasesOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/dns_alias/dissociate_dns_aliases.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void dissociateDNSAliases(DissociateDNSAliasesInput input, ResponseCallBack<DissociateDNSAliasesOutput> callback) throws QCException {
        if (input == null) {
            input = new DissociateDNSAliasesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DissociateDNSAliases");
        context.put("APIName", "DissociateDNSAliases");
        context.put("ServiceName", "DissociateDNSAliases");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DissociateDNSAliases");

        input.setAction("DissociateDNSAliases");
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

    public static class DissociateDNSAliasesInput extends IaasParamBody {
        // Required
        private List<String> dNSAliases;

        @ParamAnnotation(paramType = "query", paramName = "dns_aliases")
        public void setDNSAliases(List<String> dNSAliases) {
            this.dNSAliases = dNSAliases;
        }

        @ParamAnnotation(paramType = "query", paramName = "dns_aliases")
        public List<String> getDNSAliases() {
            return this.dNSAliases;
        }

        public String validateParam() throws QCException {
            return null;
        }
    }

    public static class DissociateDNSAliasesOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
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

    }
        
    /**
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/dns_alias/get_dns_label.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public GetDNSLabelOutput getDNSLabel() throws QCException {IaasParamBody input = new IaasParamBody();
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "GetDNSLabel");
        context.put("APIName", "GetDNSLabel");
        context.put("ServiceName", "GetDNSLabel");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/GetDNSLabel");

        input.setAction("GetDNSLabel");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,GetDNSLabelOutput.class);
        if(backModel != null){
            return (GetDNSLabelOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/dns_alias/get_dns_label.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void getDNSLabel( ResponseCallBack<GetDNSLabelOutput> callback) throws QCException {
        IaasParamBody input = new IaasParamBody();
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "GetDNSLabel");
        context.put("APIName", "GetDNSLabel");
        context.put("ServiceName", "GetDNSLabel");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/GetDNSLabel");

        input.setAction("GetDNSLabel");
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

    

    public static class GetDNSLabelOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String dNSLabel;

        @ParamAnnotation(paramType = "query", paramName = "dns_label")
        public void setDNSLabel(String dNSLabel) {
            this.dNSLabel = dNSLabel;
        }

        @ParamAnnotation(paramType = "query", paramName = "dns_label")
        public String getDNSLabel() {
            return this.dNSLabel;
        }

        private String domainName;

        @ParamAnnotation(paramType = "query", paramName = "domain_name")
        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        @ParamAnnotation(paramType = "query", paramName = "domain_name")
        public String getDomainName() {
            return this.domainName;
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



















