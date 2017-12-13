package com.ncu.sysweb.service;

import com.ncu.sysweb.enums.FileHeaderEnum;
import com.ncu.sysweb.enums.ResultEnum;
import com.ncu.sysweb.exception.GlobalException;
import com.ncu.sysweb.mapper.CurriculumMapper;
import com.ncu.sysweb.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;

    public void upload(MultipartFile file) throws GlobalException {

        if (!(FileHeaderEnum.XLS.getCode().equals(FileUtils.getFileHeader(file)) || FileHeaderEnum.XLSX.getCode().equals(FileUtils.getFileHeader(file)))) {
            throw new GlobalException(ResultEnum.FILE_HEADER_ERROR_FORMAT);
        }

    }
}
