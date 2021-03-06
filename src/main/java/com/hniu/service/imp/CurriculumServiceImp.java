package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.Curriculum;
import com.hniu.entity.CurriculumExample;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.service.CurriculumService;
import com.hniu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CurriculumServiceImp implements CurriculumService {
    @Resource
    CurriculumMapper curriculumMapper;

    @Value("${web.picturePath}")
    private String adCurriculumPicturePath;
    @Value("${web.videoPicturePath}")
    private String adCurriculumVideoPicturePath;
    @Value("${web.videoPath}")
    private String picturePath;
    @Value("${web.videoPath}")
    private String videoPicturePath;

    @Override
    public Page<CurriculumWithBLOBs> selectCurriculumList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        example.setOrderByClause("curriculum_id desc");
        List<CurriculumWithBLOBs> allCurriculum = curriculumMapper.selectByExampleWithBLOBs(example);
        int countNums = curriculumMapper.count();
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurriculum);
        return pageData;
    }

    @Override
    public CurriculumWithBLOBs selectCurriculum(int curriculum_id) {
        CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(curriculum_id);
        return curriculum;
    }

    @Override
    public int inputCurriculum(CurriculumWithBLOBs curriculum) {
        int i = curriculumMapper.insert(curriculum);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public int updateCurriculum(int curriculum_id, CurriculumWithBLOBs curriculum) {
        curriculum.setCurriculumId(curriculum_id);
        int i = curriculumMapper.updateByPrimaryKeySelective(curriculum);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteCurriculum(int curriculum_id) {
        int i = curriculumMapper.deleteByPrimaryKey(curriculum_id);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int updateCurriculumPicture(Integer curriculumId, MultipartFile curriculumPicture) {
        if(curriculumPicture != null && curriculumPicture.getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+curriculumPicture.getOriginalFilename();
            File file = new File(adCurriculumPicturePath+fileName);
            File fileFolder = new File(adCurriculumPicturePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try{
                curriculumPicture.transferTo(file);
                String curriculumPicture1 = picturePath+fileName;
                CurriculumWithBLOBs curriculum = new CurriculumWithBLOBs();
                curriculum.setCurriculumId(curriculumId);
                curriculum.setPicture(curriculumPicture1);
                return curriculumMapper.updateByPrimaryKeySelective(curriculum);
            }catch (IOException e){
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override
    public int updateCurriculumVideoPicture(Integer curriculumId, MultipartFile videoPicture) {
        if(videoPicture != null && videoPicture.getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+videoPicture.getOriginalFilename();
            File file = new File(adCurriculumVideoPicturePath+fileName);
            File fileFolder = new File(adCurriculumVideoPicturePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try{
                videoPicture.transferTo(file);
                String videoPicture1 = videoPicturePath+fileName;
                CurriculumWithBLOBs curriculum = new CurriculumWithBLOBs();
                curriculum.setCurriculumId(curriculumId);
                curriculum.setVideo(videoPicture1);
                return curriculumMapper.updateByPrimaryKeySelective(curriculum);
            }catch (IOException e){
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override
    public Page<CurriculumWithBLOBs> bySchoolId(Integer university_id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        example.createCriteria().andUniversityIdEqualTo(university_id);
        int countNums = curriculumMapper.countByExample(example);
        List<CurriculumWithBLOBs> allCurr = curriculumMapper.selectByExampleWithBLOBs(example);
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurr);
        return pageData;
    }

    @Override
    public Page<CurriculumWithBLOBs> byCtId(Integer ct_id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        example.createCriteria().andCtIdEqualTo(ct_id);
        int countNums = curriculumMapper.countByExample(example);
        List<CurriculumWithBLOBs> allCurr = curriculumMapper.selectByExampleWithBLOBs(example);
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurr);
        return pageData;
    }

    @Override
    public Page<CurriculumWithBLOBs> byName(String name, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        name = "%" + name+"%";
        example.createCriteria().andNameLike(name);
        int countNums = curriculumMapper.countByExample(example);
        List<CurriculumWithBLOBs> allCurr = curriculumMapper.selectByExampleWithBLOBs(example);
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurr);
        return pageData;
    }
}
