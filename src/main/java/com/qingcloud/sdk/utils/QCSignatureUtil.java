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

package com.qingcloud.sdk.utils;

import com.qingcloud.sdk.constants.QCConstant;
import com.qingcloud.sdk.exception.QCException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QCSignatureUtil {

    private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String computeIaasSignature(String httpMethod, String endPoint, String uri, String accSecret) {
        String strToSign = String.format("%s\n/%s/\n%s", httpMethod, endPoint, uri);
        String signature = "";
        try {
            signature = calculateSignature(accSecret, strToSign);
        } catch (UnsupportedEncodingException | QCException e) {
            e.printStackTrace();
        }

        return signature;
    }

    public static String generateUrl(String httpMethod, String endPoint, Map<String, String> parameters,
                                     String accKey, String accSecret, String apiLang) {
        addCommonParams(parameters, accKey, apiLang, null);
        String uri = generateUri(parameters);

        String signature = computeIaasSignature(httpMethod, endPoint, uri, accSecret);

        return String.format("%s&signature=%s", uri, signature);
    }

    public static String generateUri(Map<String, String> parameters) {
        String[] keys = parameters.keySet().toArray(new String[] {});
        Arrays.sort(keys);

        StringBuilder sbUri = new StringBuilder();
        for (String key : keys) {
            try {
                String encodedKey = QCStringUtil.percentEncode(key, QCConstant.ENCODING_UTF8);
                String encodedVal = QCStringUtil.percentEncode(parameters.get(key), QCConstant.ENCODING_UTF8);
                sbUri.append(encodedKey).append("=").append(encodedVal).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        String uri = sbUri.toString();
        int validLen = uri.length() - 1;

        return uri.substring(0, validLen);
    }

    public static void addCommonParams(Map<String, String> parameters, String accessKey, String apiLang, String signedTime) {
        parameters.put("version", "1");
        parameters.put("signature_version", "1");
        parameters.put("signature_method", "HmacSHA256");
        parameters.put("api_lang", apiLang);
        if (QCStringUtil.isEmpty(signedTime)) {
            parameters.put("time_stamp", formatIso8601Date(new Date()));
        } else {
            parameters.put("time_stamp", signedTime);
        }
        parameters.put("access_key_id", accessKey);
    }

    private static String formatIso8601Date(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(date);
    }

    private static String calculateSignature(String secret, String stringToSign) throws UnsupportedEncodingException, QCException {
        final String ALGORITHM = "HmacSHA256";
        byte[] signData = null;
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            mac.init(new SecretKeySpec(secret.getBytes(QCConstant.ENCODING_UTF8), ALGORITHM));
            signData = mac.doFinal(stringToSign.getBytes(QCConstant.ENCODING_UTF8));
        } catch (InvalidKeyException | IllegalStateException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] base64Encoded = Base64.encodeBase64(signData);
        if (base64Encoded == null) {
            throw new QCException("no signature generated!");
        }

        return URLEncoder.encode(new String(base64Encoded, QCConstant.ENCODING_UTF8), QCConstant.ENCODING_UTF8);
    }
}
