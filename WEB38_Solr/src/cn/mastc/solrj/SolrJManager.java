package cn.mastc.solrj;


import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName SolrJManager.java
 * @Description solrJ管理
 *               添加
 *               删除
 *               修改
 *               查询
 * @createTime 2018/12/25 20:48
 */
public class SolrJManager {

    /**
     * 添加
     */
    @Test
    public void testAdd() throws IOException, SolrServerException {

        String baseURL = "http://localhost:8080/solr/";

        // 单机版
        SolrServer solrServer = new HttpSolrServer(baseURL);
        SolrInputDocument doc = new SolrInputDocument();

        doc.setField("id", "hah");
        doc.setField("name", "X_JinL");

        solrServer.add(doc);
        solrServer.commit();

    }

    /**
     * 删除
     */
    @Test
    public void testDelete() throws IOException, SolrServerException {

        String baseURL = "http://localhost:8080/solr/";

        // 单机版
        SolrServer solrServer = new HttpSolrServer(baseURL);
        // 删除全部
        solrServer.deleteByQuery("*:*", 1000);

        //条件删除
        solrServer.deleteById("10");

    }

    /**
     * 更新
     */
    @Test
    public void testUpdate() {

        String baseURL = "http://localhost:8080/solr/";

        // 单机版
        SolrServer solrServer = new HttpSolrServer(baseURL);
        //更新与删除一致,只要ID相同就是更新,ID不痛就是添加

    }

    /**
     * 查询
     */
    @Test
    public void testSearch() throws SolrServerException {

        String baseURL = "http://localhost:8080/solr/";

        // 单机版
        SolrServer solrServer = new HttpSolrServer(baseURL);
        // 查询 关键词:台灯 过滤条件:"product_catalog_name":"幽默杂货",
        // "product_price":18.9 价格排序 分页 开始行 每页数 高亮 默认域 只查询指定域
        SolrQuery solrQuery = new SolrQuery();

        // 关键词
        // solrQuery.set("q", "product_name:台灯");
        solrQuery.setQuery("product_name:台灯");

        // 过滤条件:"product_catalog_name":"幽默杂货"
        solrQuery.set("fq", "product_catalog_name:幽默杂货");
        solrQuery.set("fq", "product_price:[* TO 10]");

        // 价格排序
        solrQuery.addSort("product_price", SolrQuery.ORDER.desc);

        // 分页
        solrQuery.setStart(0);
        solrQuery.setRows(5);

        // 默认域
        solrQuery.set("df", "product_name");

        // 只查询指定域
        solrQuery.set("fl", "id,product_name");

        // 高亮
        // 1.打开开关
        solrQuery.setHighlight(true);
        // 2.指定高亮域
        solrQuery.addHighlightField("product_name");
        // 3.前缀后缀
        solrQuery.setHighlightSimplePre("<span style='color:red'>");
        solrQuery.setHighlightSimplePost("</span>");

        // 执行查询
        QueryResponse response = solrServer.query(solrQuery);
        // 文档结果集
        SolrDocumentList docs = response.getResults();

        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        // Map K id V Map
        // Map K 域名 V List
        // List list.get(0)


        // 总条数
        long numFound = docs.getNumFound();
        /*"docs": [
        {
            "product_catalog_name": "幽默杂货",
                "product_price": 18.9,
                "product_name": "花儿朵朵彩色金属门后挂 8钩免钉门背挂钩2066",
                "id": "1",
                "product_picture": "2014032613103438.png",
                "_version_": 1620903269236736000
        }*/
        System.out.println(numFound);
        for (SolrDocument doc : docs) {
            System.out.println(doc.get("product_catalog_name"));
            System.out.println(doc.get("product_price"));
            System.out.println(doc.get("product_name"));
            System.out.println(doc.get("id"));
            System.out.println(doc.get("product_picture"));

            System.out.println("===================================");
            Map<String, List<String>> map = highlighting.get(doc.get("id"));
            List<String> list = map.get("product_name");
            System.out.println(list.get(0));
        }

    }

}
