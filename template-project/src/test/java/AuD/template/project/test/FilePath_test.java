package AuD.template.project.test;

import AuD.template.project.core.constant.ServerResponseStatusCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName FilePath_test
 * @date 2021/2/25 13:43
 * @Version 1.0
 */
public class FilePath_test {

    /**
     * 测试获取文件绝对路径(path)
     */
    @Test
    public void testGetPath(){
        URL resource = this.getClass().getResource("");
        File file = new File(resource.getFile());
        System.out.println("*****************根路径******************");
        System.out.println("url:"+resource+"\n"+"resource.getFile():"+resource.getFile()+"\n"+"file.getPath():"+file.getPath());

        resource = this.getClass().getResource("/test.properties");
        file = new File(resource.getFile());
        System.out.println("*****************文件绝对路径******************");
        System.out.println("url:"+resource+"\n"+"resource.getFile():"+resource.getFile()+"\n"+"file.getPath():"+file.getPath());

        resource = this.getClass().getResource("../../../test.properties");
        file = new File(resource.getFile());
        System.out.println("*****************文件相对路径******************");
        System.out.println("url:"+resource+"\n"+"resource.getFile():"+resource.getFile()+"\n"+"file.getPath():"+file.getPath());
    }



    @Test
    public void testLoadPro() throws IOException {
        final InputStream inputStream = this.getClass().getResourceAsStream("/test.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.keySet().forEach((key)->System.out.println(key));
        System.out.println("*********************");
        properties.keySet().forEach((key)->System.out.println(properties.get(key)));
    }

    @Test
    public void showUsage() {

        if(ServerResponseStatusCode.PARAMETER_ERROR instanceof Enum){
            System.out.println("yes");
        }
        System.out.println(DigestUtils.md5Hex("DA860B55-AE89-4244-B595-2AF67705AF52"));
        long l=Runtime.getRuntime().totalMemory();
        System.out.println(l);
        long f=Runtime.getRuntime().freeMemory();
        System.out.println(f);

    }


}
