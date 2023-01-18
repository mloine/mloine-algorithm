package con.mloine.util;

/**
 * @Author: mloine
 * @Date: 2023-01-18-20:09
 * @Description: 计时器
 */
public class StopWatch {
    private final long start;

    public StopWatch() {
        this.start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        return (System.currentTimeMillis() - start) / 1000.0;
    }
}
