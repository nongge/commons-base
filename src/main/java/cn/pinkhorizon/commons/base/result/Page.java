package cn.pinkhorizon.commons.base.result;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * @author yuanlei7
 * @date 2021/4/25
 * @apiNote 分页查询返回数据封装格式
 */
@JsonPropertyOrder
public class Page<T> {
    /**
     * SerializerId
     */
    private static final long serialVersionUID = 2205712062317515251L;

    /**
     * 页码
     */
    private Long pageIndex;

    /**
     * 页面内容数量
     */
    private Long pageSize;

    /**
     * 总数量
     */
    private Long totalSize;

    /**
     * 页面数据内容
     */
    private List<T> content;

    private Page() {

    }

    public Page(Long pageIndex, Long pageSize, Long totalSize, List<T> content) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.content = content;
    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public List<T> getContent() {
        return content;
    }
}
