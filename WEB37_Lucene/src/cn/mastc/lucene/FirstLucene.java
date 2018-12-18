package cn.mastc.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName FirstLucene.java
 * @Description 创建索引
 *               查询索引
 * @createTime 2018/12/18 17:52
 */
public class FirstLucene {

    /**
     * 创建索引
     */
    @Test
    public void testIndex() throws IOException {
        // 第一步：创建一个java工程，并导入jar包。
        // 第二步：创建一个indexwriter对象。
        Directory directory = FSDirectory.open(new File("e:\\temp\\index"));
        // Directory directory = new RAMDirectory();//保存索引到内存中 （内存索引库）
//		Analyzer analyzer = new StandardAnalyzer();// 官方推荐
        Analyzer analyzer = new IKAnalyzer();// 官方推荐
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        // 1）指定索引库的存放位置Directory对象
        // 2）指定一个分析器，对文档内容进行分析。
        // 第三步：创建field对象，将field添加到document对象中。
        File f = new File("e:\\Lucene&solr\\searchsource");
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            // 第三步：创建document对象。
            Document document = new Document();
            // 文件名称
            String file_name = file.getName();
            Field fileNameField = new TextField("fileName", file_name, Field.Store.YES);
            // 文件大小
            long file_size = FileUtils.sizeOf(file);
            Field fileSizeField = new LongField("fileSize", file_size, Field.Store.YES);
            // 文件路径
            String file_path = file.getPath();
            Field filePathField = new StoredField("filePath", file_path);
            // 文件内容
            String file_content = FileUtils.readFileToString(file);
            Field fileContentField = new TextField("fileContent", file_content, Field.Store.NO);

            document.add(fileNameField);
            document.add(fileSizeField);
            document.add(filePathField);
            document.add(fileContentField);
            // 第四步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
            indexWriter.addDocument(document);

        }
        // 第五步：关闭IndexWriter对象。
        indexWriter.close();

    }

}
