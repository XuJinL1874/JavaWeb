package cn.itmastc.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 21:53 2018/8/23
 * @Modified By:
 */
public class TestDom4j {
    /**
     * SaxReader对象
     *      read()加载执行xml文档
     * Document对象
     *      getRootElement()获得根元素
     * Element对象
     *      elements()获得指定名称的所有根元素,可以不指定名称
     *      element()获得指定名称的第一个根元素,可以不指定名称
     *      getName()获得当前元素的名称
     *      attributeValue()获得指定属性名称的属性值
     *      elementText()获得指定名称子元素的文本值
     *      getText()获得当前元素的文本内容
     */
    @Test
    public void testReadWebXML() {
        try {
            // 1.获取解析器
            SAXReader saxReader = new SAXReader();
            // 2.获得document文档对象
            Document doc = saxReader.read("src/cn/itmastc/dom4j/web.xml");
            // 3.获取根元素
            Element rootElement = doc.getRootElement();
            // System.out.println(rootElement.getName());获取根元素的名称
            // System.out.println(rootElement.attributeValue("version"));获取根元素中的属性值
            // 4.获取根元素下的子元素
            List<Element> childElement = rootElement.elements();
            // 5.遍历子元素
            for (Element element : childElement) {
                // 6.判断元素名称为servlet的元素
                if ("servlet".equals(element.getName())) {
                    // 7.获取servlet-name元素
                    Element servletName = element.element("servlet-name");
                    // 8.获取servlet-class元素
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletName.getText());
                    System.out.println(servletClass.getText());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
