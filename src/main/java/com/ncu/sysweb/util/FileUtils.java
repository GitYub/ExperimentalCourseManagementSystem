package com.ncu.sysweb.util;

import com.ncu.sysweb.enums.ResultEnum;
import com.ncu.sysweb.exception.GlobalException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    public static String getFileHeader( MultipartFile file) throws GlobalException{
        InputStream is = null;
        String value;
        try {
            is = file.getInputStream();
            byte[] b = new byte[4];
            is.read(b, 0, b.length);
            value = bytesToHexString(b);
        } catch (IOException e) {
            throw new GlobalException(ResultEnum.FILE_OPERATION_ERROR);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new GlobalException(ResultEnum.FILE_OPERATION_ERROR);
                }
            }
        }
        return value;
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }

}
