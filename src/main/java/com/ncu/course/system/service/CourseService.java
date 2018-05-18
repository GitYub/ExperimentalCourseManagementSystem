package com.ncu.course.system.service;

import com.ncu.course.system.domain.Course;
import com.ncu.course.system.domain.User;
import com.ncu.course.system.repository.CourseRepository;
import com.ncu.course.system.repository.UserRepository;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("CourseService")
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationService applicationService;

    public void save(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        final File excelFile;

        try {
            excelFile = File.createTempFile(fileName, prefix);
            file.transferTo(excelFile);
            FileInputStream fileInputStream = new FileInputStream(excelFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            if (".xls".equals(prefix)) {
                doXls(bufferedInputStream);
            } else if (".xlsx".equals(prefix)) {
                doXlsx(bufferedInputStream);
            }

            bufferedInputStream.close();
            excelFile.deleteOnExit();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void doXls(BufferedInputStream bufferedInputStream) {
        POIFSFileSystem fileSystem = null;
        try {
            fileSystem = new POIFSFileSystem(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFWorkbook workbook = null;
        try {
            if (fileSystem != null) {
                workbook = new HSSFWorkbook(fileSystem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = null;
        if (workbook != null) {
            sheet = workbook.getSheet("Sheet1");
        }

        int lastRowIndex = 0;
        if (sheet != null) {
            lastRowIndex = sheet.getLastRowNum();
        }

        List<Course> courses = new ArrayList<>();
        for (int i = 4; i < lastRowIndex; i++) {
            Course course = new Course();
            HSSFRow row;
            row = sheet.getRow(i);
            if (row == null) { break; }

            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                String tmp = row.getCell(j).toString();

                if (j == 2) {
                    course.setName(tmp);
                } else if (j == 6) {
                    User user = userRepository.findUserByUsername(tmp).orElse(null);
                    course.setUser(user.getJobNumber());
                } else if (j == 12) {
                    course.setLocation(tmp);
                } else if (j == 13) {
                    course.setSchoolClass(tmp);
                } else if (j == 15) {
                    course.setWeek((int) Double.parseDouble(tmp));
                } else if (j == 16) {
                    course.setDay((int) Double.parseDouble(tmp));
                } else if (j == 17) {
                    String[] arr = tmp.split("-");
                    if (arr.length == 2) {
                        course.setTimetable((1 << (10 - Integer.valueOf(arr[0]))) + (1 << (10 - Integer.valueOf(arr[1]))));
                    } else if (arr.length == 1) {
                        course.setTimetable(1 << (10 - Integer.valueOf(arr[0])));
                    }

                }
            }
            courses.add(course);
        }
        courseRepository.saveAll(courses);

    }

    private void doXlsx(BufferedInputStream bufferedInputStream) {
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = null;
        if (workbook != null) {
            sheet = workbook.getSheet("Sheet1");
        }
        int lastRowIndex = 0;
        if (sheet != null) {
            lastRowIndex = sheet.getLastRowNum();
        }

        List<Course> courses = new ArrayList<>();

        for (int i = 4; i < lastRowIndex; i++) {

            Course course = new Course();
            XSSFRow row;
            row = sheet.getRow(i);
            if (row == null) { break; }

            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                String tmp = row.getCell(j).toString();
                if (j == 2) {
                    course.setName(tmp);
                } else if (j == 6) {
                    User user = userRepository.findUserByUsername(tmp).orElse(null);
                    course.setUser(user.getJobNumber());
                } else if (j == 12) {
                    course.setLocation(tmp);
                } else if (j == 13) {
                    course.setSchoolClass(tmp);
                } else if (j == 15) {
                    course.setWeek(Integer.valueOf(tmp));
                } else if (j == 16) {
                    course.setDay(Integer.valueOf(tmp));
                } else if (j == 17) {
                    String[] arr = tmp.split("-");
                    course.setTimetable(1 << (10 - Integer.valueOf(arr[0])) + 1 << (10 - Integer.valueOf(arr[1])));
                }
            }
            courses.add(course);
        }
        courseRepository.saveAll(courses);
    }

    Optional<Course> getCourse(int id) { return courseRepository.findById(id); }

    public List<Course> getCourse(long jobNumber) {
        return courseRepository.findCourseByUser(jobNumber);
    }

    public boolean submitApplication(int id, String location, int week, int day, int timetable) {
        long count = courseRepository.countCourseByLocationAndWeekAndDayAndTimetable(location, week, day, timetable);

        if (count > 0) {
            return false;
        } else {
            applicationService.add(id, location, week, day, timetable);
            return true;
        }
    }

    void updateCourse(int id, String location, int week, int day, int timetable) {
        courseRepository.updateCourse(id, location, week, day, timetable);
    }
}
