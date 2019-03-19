package com.jju.sshweb.model;

public class Categorysecond {
    private Integer csid;

    private String csname;

    private Integer cid;

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    @Override
	public String toString() {
		return "Categorysecond [csid=" + csid + ", csname=" + csname + ", cid=" + cid + "]";
	}

	public void setCsname(String csname) {
        this.csname = csname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}