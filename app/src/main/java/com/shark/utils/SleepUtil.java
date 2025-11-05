package com.shark.utils;

import java.util.concurrent.ThreadLocalRandom;

public class SleepUtil {
    /**
     * 随机休眠指定范围的时间
     *
     * @param minMillis 最小休眠时间（毫秒）
     * @param maxMillis 最大休眠时间（毫秒）
     * @throws IllegalArgumentException 如果最小值大于最大值
     */
    public static void randomSleep(int minMillis, int maxMillis) {
        if (minMillis > maxMillis) {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }

        // 生成随机休眠时间
        int sleepTime = ThreadLocalRandom.current().nextInt(minMillis, maxMillis + 1);

        try {
            // 休眠指定的时间
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            // 捕获中断异常并恢复中断状态
            Thread.currentThread().interrupt();
        }
    }
}
