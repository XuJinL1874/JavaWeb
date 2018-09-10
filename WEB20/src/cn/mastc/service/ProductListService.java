package cn.mastc.service;

import cn.mastc.dao.ProductDao;
import cn.mastc.domain.Product;
import cn.mastc.vo.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 18:49 2018/9/10
 * @Modified By:
 */
public class ProductListService {


    public List<Product> findAllProduct() throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.findAllProduct();
    }

    // 分页操作
    public PageBean findPageBean(int currentPage, int currentCount) throws SQLException {
        ProductDao dao = new ProductDao();
        // 目的:就是想办法封装一个PageBean 并返回
        PageBean pageBean = new PageBean();
        // 当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        // 当前页显示的个数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        // 总个数private int totalCount;
        int totalCount= dao.getTotalCount();
        pageBean.setTotalPage(totalCount);
        // 总页数private int totalPage;
        /*
         * 总条数		当前页显示的条数	总页数
         * 10		4				3
         * 11		4				3
         * 12		4				3
         * 13		4				4
         *
         * 公式：总页数=Math.ceil(总条数/当前显示的条数)
         */
        int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);
        // 每页显示的数据private List<T> productList = new ArrayList<T>();
        /*
         * 页数与limit起始索引的关系
         * 例如 每页显示4条
         * 页数		其实索引		每页显示条数
         * 1		0			4
         * 2		4			4
         * 3		8			4
         * 4		12			4
         *
         * 索引index = (当前页数-1)*每页显示的条数
         *
         */
        int index = (currentPage-1)*currentCount;

        List<Product> productList = dao.findProductListForPageBean(index,currentCount);
        pageBean.setProductList(productList);
        return pageBean;
    }
}
