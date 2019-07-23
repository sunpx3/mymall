package com.sunpx.mall.model;

import java.io.Serializable;

/**
 * m_users_roles_relations
 * @author 
 */
public class MUsersRolesRelations implements Serializable {
    private Integer mId;

    /**
     * 用户名
     */
    private String mUsername;

    /**
     * 角色表code
     */
    private String mRolesCode;

    private static final long serialVersionUID = 1L;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmRolesCode() {
        return mRolesCode;
    }

    public void setmRolesCode(String mRolesCode) {
        this.mRolesCode = mRolesCode;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MUsersRolesRelations other = (MUsersRolesRelations) that;
        return (this.getmId() == null ? other.getmId() == null : this.getmId().equals(other.getmId()))
            && (this.getmUsername() == null ? other.getmUsername() == null : this.getmUsername().equals(other.getmUsername()))
            && (this.getmRolesCode() == null ? other.getmRolesCode() == null : this.getmRolesCode().equals(other.getmRolesCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getmId() == null) ? 0 : getmId().hashCode());
        result = prime * result + ((getmUsername() == null) ? 0 : getmUsername().hashCode());
        result = prime * result + ((getmRolesCode() == null) ? 0 : getmRolesCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mId=").append(mId);
        sb.append(", mUsername=").append(mUsername);
        sb.append(", mRolesCode=").append(mRolesCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}