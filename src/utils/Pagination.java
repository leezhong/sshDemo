package utils;

import com.sun.javafx.css.StyleableIntegerProperty;
import com.sun.javafx.css.StyleableProperty;
import com.sun.javafx.css.Stylesheet;
import com.sun.javafx.css.converters.SizeConverter;
import javafx.beans.DefaultProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.WritableValue;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lz on 2016/11/18.
 */
@DefaultProperty("pages")
public class Pagination extends Control {
    private static final int DEFAULT_MAX_PAGE_INDICATOR_COUNT = 10;
    public static final String STYLE_CLASS_BULLET = "bullet";
    public static final int INDETERMINATE = 2147483647;
    private int oldMaxPageIndicatorCount;
    private IntegerProperty maxPageIndicatorCount;
    private int oldPageCount;
    private IntegerProperty pageCount;
    private final IntegerProperty currentPageIndex;
    private ObjectProperty<Callback<Integer, Node>> pageFactory;
    private static final String DEFAULT_STYLE_CLASS = "pagination";

    public Pagination(int var1, int var2) {
        this.oldMaxPageIndicatorCount = 10;
        this.oldPageCount = 2147483647;
        this.pageCount = new SimpleIntegerProperty(this, "pageCount", 2147483647) {
            protected void invalidated() {
                if(!Pagination.this.pageCount.isBound()) {
                    if(Pagination.this.getPageCount() < 1) {
                        Pagination.this.setPageCount(Pagination.this.oldPageCount);
                    }

                    Pagination.this.oldPageCount = Pagination.this.getPageCount();
                }

            }
        };
        this.currentPageIndex = new SimpleIntegerProperty(this, "currentPageIndex", 0) {
            protected void invalidated() {
                if(!Pagination.this.currentPageIndex.isBound()) {
                    if(Pagination.this.getCurrentPageIndex() < 0) {
                        Pagination.this.setCurrentPageIndex(0);
                    } else if(Pagination.this.getCurrentPageIndex() > Pagination.this.getPageCount() - 1) {
                        Pagination.this.setCurrentPageIndex(Pagination.this.getPageCount() - 1);
                    }
                }

            }
        };
        this.pageFactory = new SimpleObjectProperty(this, "pageFactory");
        this.getStyleClass().setAll(new String[]{"pagination"});
        this.setPageCount(var1);
        this.setCurrentPageIndex(var2);
    }

    public Pagination(int var1) {
        this(var1, 0);
    }

    public Pagination() {
        this(2147483647, 0);
    }

    public final void setMaxPageIndicatorCount(int var1) {
        this.maxPageIndicatorCountProperty().set(var1);
    }

    public final int getMaxPageIndicatorCount() {
        return this.maxPageIndicatorCount == null?10:this.maxPageIndicatorCount.get();
    }

    public final IntegerProperty maxPageIndicatorCountProperty() {
        if(this.maxPageIndicatorCount == null) {
            this.maxPageIndicatorCount = new StyleableIntegerProperty(10) {
                protected void invalidated() {
                    if(!Pagination.this.maxPageIndicatorCount.isBound()) {
                        if(Pagination.this.getMaxPageIndicatorCount() < 1 || Pagination.this.getMaxPageIndicatorCount() > Pagination.this.getPageCount()) {
                            Pagination.this.setMaxPageIndicatorCount(Pagination.this.oldMaxPageIndicatorCount);
                        }

                        Pagination.this.oldMaxPageIndicatorCount = Pagination.this.getMaxPageIndicatorCount();
                    }

                }

                public StyleableProperty getStyleableProperty() {
                    return Pagination.StyleableProperties.MAX_PAGE_INDICATOR_COUNT;
                }

                public Object getBean() {
                    return Pagination.this;
                }

                public String getName() {
                    return "maxPageIndicatorCount";
                }
            };
        }

        return this.maxPageIndicatorCount;
    }

    public final void setPageCount(int var1) {
        this.pageCount.set(var1);
    }

    public final int getPageCount() {
        return this.pageCount.get();
    }

    public final IntegerProperty pageCountProperty() {
        return this.pageCount;
    }

    public final void setCurrentPageIndex(int var1) {
        this.currentPageIndex.set(var1);
    }

    public final int getCurrentPageIndex() {
        return this.currentPageIndex.get();
    }

    public final IntegerProperty currentPageIndexProperty() {
        return this.currentPageIndex;
    }

    public final void setPageFactory(Callback<Integer, Node> var1) {
        this.pageFactory.set(var1);
    }

    public final Callback<Integer, Node> getPageFactory() {
        return (Callback)this.pageFactory.get();
    }

    public final ObjectProperty<Callback<Integer, Node>> pageFactoryProperty() {
        return this.pageFactory;
    }

    /** @deprecated */
    @Deprecated
    public static List<StyleableProperty> impl_CSS_STYLEABLES() {
        return Pagination.StyleableProperties.STYLEABLES;
    }

    /** @deprecated */
    @Deprecated
    public List<StyleableProperty> impl_getStyleableProperties() {
        return impl_CSS_STYLEABLES();
    }

    private static class StyleableProperties {
        private static final StyleableProperty<Pagination, Number> MAX_PAGE_INDICATOR_COUNT = new StyleableProperty("-fx-max-page-indicator-count", SizeConverter.getInstance(), Integer.valueOf(10)) {
            @Override
            public boolean isSettable(Node node) {
                return false;
            }

            @Override
            public WritableValue getWritableValue(Node node) {
                return null;
            }

            public void set(Pagination var1, Number var2, Stylesheet.Origin var3) {
                super.set(var1, Integer.valueOf(var2.intValue()), var3);
            }

            public boolean isSettable(Pagination var1) {
                return var1.maxPageIndicatorCount == null || !var1.maxPageIndicatorCount.isBound();
            }

            public WritableValue<Number> getWritableValue(Pagination var1) {
                return var1.maxPageIndicatorCountProperty();
            }
        };
        private static final List<StyleableProperty> STYLEABLES;

        private StyleableProperties() {
        }

        static {
            ArrayList var0 = new ArrayList(Control.impl_CSS_STYLEABLES());
            Collections.addAll(var0, new StyleableProperty[]{MAX_PAGE_INDICATOR_COUNT});
            STYLEABLES = Collections.unmodifiableList(var0);
        }
    }
}