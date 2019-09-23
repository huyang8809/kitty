package com.hu.kittycommon.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭对象，连接
 * @Author: hy
 * @Date: 2019/8/29
 */
public class IOUtils {
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
