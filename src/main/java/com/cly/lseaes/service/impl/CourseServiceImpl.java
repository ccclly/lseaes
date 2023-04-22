package com.cly.lseaes.service.impl;

import com.cly.lseaes.dto.CourseDTO;
import com.cly.lseaes.entity.Chapter;
import com.cly.lseaes.entity.Course;
import com.cly.lseaes.entity.Lesson;
import com.cly.lseaes.mapper.CourseMapper;
import com.cly.lseaes.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-12
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

//    @Override
//    public CourseDTO selectCourseDTOById(Integer id) {
//        return courseMapper.selectCourseDTOById(id);
//    }

    @Override
    public CourseDTO selectCourseDTOById(Integer id) {
        List<Map<String, Object>> resultList = courseMapper.selectCourseDetailsById(id);
        if (resultList.isEmpty()) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        Map<String, Object> resultMap = resultList.get(0);

        courseDTO.setName((String) resultMap.get("name"));
        courseDTO.setDescription((String) resultMap.get("description"));
        courseDTO.setImgName((String) resultMap.get("img_name"));
        courseDTO.setAuthorId((Integer) resultMap.get("author_id"));

        List<Chapter> chapterList = new ArrayList<>();
        Set<Integer> chapterSet = new HashSet<>();
        List<Lesson> lessonList = new ArrayList<>();

        for (Map<String, Object> map : resultList) {
            Integer chapterId = (Integer) map.get("chapter_id");
            if (chapterId != null && !chapterSet.contains(chapterId)) {
                Chapter chapter = new Chapter();
                chapter.setId(chapterId);
                chapter.setName((String) map.get("chapter_name"));
                chapter.setOrderNum((Integer) map.get("chapter_order_num"));
                chapter.setCourseId((Integer) map.get("id"));
                chapterList.add(chapter);
                chapterSet.add(chapterId);
            }

            Integer lessonId = (Integer) map.get("lesson_id");
            if (lessonId != null) {
                Lesson lesson = new Lesson();
                lesson.setId(lessonId);
                lesson.setName((String) map.get("lesson_name"));
                lesson.setOrderNum((Integer) map.get("lesson_order_num"));
                lesson.setVedioName((String) map.get("lesson_vedio_name"));
                lesson.setChapterId((Integer) map.get("chapter_id"));
                lessonList.add(lesson);
            }
        }

        courseDTO.setChapterList(chapterList);
        courseDTO.setLessonList(lessonList);

        return courseDTO;
    }
}
