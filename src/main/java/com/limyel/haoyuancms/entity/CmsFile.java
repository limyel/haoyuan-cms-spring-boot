package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * cms文件
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@TableName("cms_file")
public class CmsFile extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 路径
     */
    private String path;

    /**
     * 文件存储类型, 1: 本地, 2: 远程
     */
    private Integer type;

    /**
     * 文件名
     */
    private String name;

    /**
     * 扩展名
     */
    private String extension;

    /**
     * 文件大小
     */
    private Integer size;

    /**
     * md5值
     */
    private String md5;

}
