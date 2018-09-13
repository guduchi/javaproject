package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class SalesmanVersion  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String version;

    private String appdownloadurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getAppdownloadurl() {
        return appdownloadurl;
    }

    public void setAppdownloadurl(String appdownloadurl) {
        this.appdownloadurl = appdownloadurl == null ? null : appdownloadurl.trim();
    }
}