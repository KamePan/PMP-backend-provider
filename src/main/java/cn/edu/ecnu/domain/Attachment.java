package cn.edu.ecnu.domain;

import java.io.Serializable;

public class Attachment implements Serializable {

    private String aid;

    private String filename;

    private String path;

    private String pid;

    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.aid
     *
     * @return the value of attachment.aid
     *
     * @mbggenerated
     */
    public String getAid() {
        return aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.aid
     *
     * @param aid the value for attachment.aid
     *
     * @mbggenerated
     */
    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.filename
     *
     * @return the value of attachment.filename
     *
     * @mbggenerated
     */
    public String getFilename() {
        return filename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.filename
     *
     * @param filename the value for attachment.filename
     *
     * @mbggenerated
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.path
     *
     * @return the value of attachment.path
     *
     * @mbggenerated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.path
     *
     * @param path the value for attachment.path
     *
     * @mbggenerated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.pid
     *
     * @return the value of attachment.pid
     *
     * @mbggenerated
     */
    public String getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.pid
     *
     * @param pid the value for attachment.pid
     *
     * @mbggenerated
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attachment
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", filename=").append(filename);
        sb.append(", path=").append(path);
        sb.append(", pid=").append(pid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}