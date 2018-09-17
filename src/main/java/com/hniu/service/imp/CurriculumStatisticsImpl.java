package com.hniu.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.entity.AddCurriculum;
import com.hniu.entity.Comment;
import com.hniu.entity.CouresDetails;
import com.hniu.entity.CourseType;
import com.hniu.mapper.AddCurriculumMapper;
import com.hniu.mapper.CommentMapper;
import com.hniu.mapper.CourseTypeMapper;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.mapper.TutionMapper;
import com.hniu.mapper.VideoMapper;
import com.hniu.service.CurriculumStatisticsService;
/*
 * 课程统计Service
 */

@Service
public class CurriculumStatisticsImpl implements CurriculumStatisticsService {

	@Autowired
	private CurriculumMapper curriculumMapper;
	
	@Autowired
	private TutionMapper tutionMapper;
	
	@Autowired
	private CourseTypeMapper courseTypeMapper;
	
	@Autowired
	private CommentMapper CommentMapper;
	
	@Autowired
	private VideoMapper videoMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private AddCurriculumMapper addCurriculumMapper;
	
	@Override
	public Object getCurriculumStudyNum(Integer id) {
		
		return tutionMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer getCurrentStudyNum(Integer id) {
		
		return curriculumMapper.getCurrentStudyNum(id);
	}

	@Override
	public Object  getCurriculumEvaluation(Integer id) {
		
		return curriculumMapper.getCurriculumEvaluation(id);
	}

	@Override
	public Object insertcurriculum(CourseType courseType) {
	
		return courseTypeMapper.insert(courseType);
	}

	@Override
	public Object getcurriculum(Integer id) {
		
		return courseTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public Object updatecurriculum(CourseType courseType) {
		// TODO Auto-generated method stub
		return courseTypeMapper.updateByPrimaryKey(courseType);
	}

	@Override
	public Object deletecurriculum(Integer id) {
	
		return courseTypeMapper.deleteByPrimaryKey(id);
	}

	
	/*
	 * (non-Javadoc)
	 * (auonth)DZY
	 * @see com.hniu.service.CurriculumStatisticsService#getCouresDetails()
	 * 2.课程名称，学校名称，教师名，课程介绍、课程寄语、预备知识、。。。
	 * 评分标准，已参与人数（开课表中该课程ID对应的参与人数之和）等。
	 */
	@Override
	public Object getCouresDetails(Integer id) {
		return curriculumMapper.getCouresDetails(id);
	}

	
	/*显示列出课程名称，评价内容，评价时间，及评价标星*/
	@Override
	public Object getCommentInformation(Integer id) {
		
		return CommentMapper.getCommentInformation(id);
	}
    
	
	/*2.显示课程总的评价数和课程得分*/
	@Override
	public Object getEvaluateNum(Integer id) {
		
		return CommentMapper.getEvaluateNum(id);
	}

	/*1.课程封面视频*/
	@Override
	public Object getVideo(Integer id) {
		
		return videoMapper.selectByPrimaryKey(id);
	}

	
	/*1.针对课程发表评价，点赞，标星（5颗星）*/
	@Override
	public Object insertComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.insert(comment);
	}

	
	/*单击立即加入，用户可以学习课程*/
	@Override
	public Object JoinTheCourseByid(Integer id) {
		//根据课程di查询需要加入课程的信息
		CouresDetails couresDetails = curriculumMapper.JoinTheCourseByid(id);
		//创建一个需要添加课程的对象 将根据课程id查询出来的信息添加到开课表中
		AddCurriculum addCurriculum=new AddCurriculum();
		addCurriculum.setTutionId(couresDetails.getTution_id());
		addCurriculum.setUserId(couresDetails.getUser_id());
		addCurriculum.setCourseGrade(couresDetails.getScore());
		addCurriculum.setIsQualified(couresDetails.getRequire());
		int i=addCurriculumMapper.insert(addCurriculum);
		if (i == 1) {
			return "加入课程成功";
		}
		return "加入课程失败";
	}

	
	
}
