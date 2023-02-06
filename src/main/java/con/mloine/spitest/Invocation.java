package con.mloine.spitest;

import java.util.ServiceLoader;

/**
 * @Author Mloine
 * @Description SPI eg:SQL (MySQL Oracle PostGreSQL) -> com.mysql.cj.jdbc.Driver (create session open tx commit rollback API)
 * 约定: resource/META-INF/services -> interface class 全类名作为文件名 内容是实现类的全类名
 * @Date 19:54 2023/2/6
 **/
public class Invocation {

    public static void main(String[] args) {

        ServiceLoader<MessageSender> load = ServiceLoader.load(MessageSender.class);

        load.findFirst().ifPresentOrElse((x) -> {
            x.send("我是由SPI调用方 传入的信息");
        }, () -> {
            System.out.println("未找到具体SPI的实现类");
        });

    }
}
