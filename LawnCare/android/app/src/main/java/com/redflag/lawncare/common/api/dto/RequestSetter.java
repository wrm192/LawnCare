package com.redflag.lawncare.common.api.dto;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public interface RequestSetter {
    void setRequestParams(OutputStreamWriter writer) throws Exception;
}
