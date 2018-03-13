package com.jero.esc.common.po;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public class FastPage <T> {

    public  List<T> list;
    public  Integer  totalSize;
    public  Integer  pageSize;
    public  Integer totalPage;
    public  Integer page;

    public  FastPage(List<T> list,Integer totalSize,Integer page ,Integer pageSize) {
        this.list=list;
        this.totalSize=totalSize;
        this.pageSize= pageSize;
        this.page=page;
        totalPage=(int)Math.ceil((double)this.totalSize/(double)pageSize);
    }

    public  FastPage(List<T> list,Integer totalSize,PageRowBounds rowBounds) throws Exception {
        if (FastValid.isEmp(list,totalSize,rowBounds)) {
            throw new  Exception("分页类创建失败");
        }
        this.list=list;
        this.totalSize=totalSize;
        this.pageSize= rowBounds._limit;
        this.page=(rowBounds._offset+pageSize)/pageSize;
        totalPage=(int)Math.ceil((double)this.totalSize/(double)pageSize);
    }
    
    /**
     * @author sys
     */

    private  FastPage(){}

    public List<T> getList() {
		return list;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPage() {
		return page;
	}


    public void setList(List<T> list) {
        this.list = list;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
