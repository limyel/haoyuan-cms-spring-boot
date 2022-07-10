package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * cms权限
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@TableName("cms_permission")
public class CmsPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限所属模块
     */
    private String module;

    /**
     * 是否挂载, 0:关闭, 1:开启
     */
    private Boolean mount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
    public Boolean getMount() {
        return mount;
    }

    public void setMount(Boolean mount) {
        this.mount = mount;
    }

    @Override
    public String toString() {
        return "CmsPermission{" +
            "id=" + id +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleteTime=" + deleteTime +
            ", name=" + name +
            ", module=" + module +
            ", mount=" + mount +
        "}";
    }
}
