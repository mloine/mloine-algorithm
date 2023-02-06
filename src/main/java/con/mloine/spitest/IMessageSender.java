package con.mloine.spitest;

/**
 * @Author Mloine
 * @Description 测试实现类
 * @Date 19:47 2023/2/6
 **/
public class IMessageSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("------------------------");
        System.out.printf("i am spi provider this is receive info :%s%n%n", message);
        System.out.println("------------------------");
    }
}
