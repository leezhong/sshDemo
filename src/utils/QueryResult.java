package utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lz on 2016/11/18.
 */
public class QueryResult<T> implements Serializable {
    private Pagination pagination;
    private List<T> items = null;

    public QueryResult() {
    }

    public QueryResult(Pagination var1, List<T> var2) {
        this.pagination = var1;
        this.items = var2;
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> var1) {
        this.items = var1;
    }

    public Pagination getPagination() {
        return this.pagination;
    }
}
