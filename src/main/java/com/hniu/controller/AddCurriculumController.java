package com.hniu.controller;

import com.hniu.constan.StateCode;
import com.hniu.entity.AddCurriculum;
import com.hniu.entity.vo.AddCurriculumVo;
import com.hniu.service.AddCurriculumService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 10:58
 * @Description:
 * @Modified By:
 */
@RestController
@RequestMapping("/addCurriculum")
public class AddCurriculumController extends Base{

    @Autowired
    AddCurriculumService addCurriculumService;

    //分页查询加入课程信息
    @GetMapping("/addCurriculumPage")
    public State<Object> addCurriculumPage(Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<AddCurriculumVo> list = addCurriculumService.AddCurriculumPage(currentPage, pageSize);
        if(list.getList().size()>0){
            return  packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //查询单个加入课程信息
    @GetMapping("/{add_id}")
    public State<Object> selectAddCurriculum(@PathVariable("add_id")Integer add_id){
        AddCurriculumVo addCurriculumVo = addCurriculumService.selectAddCurriculum(add_id);
        if(!StringUtils.isEmpty(addCurriculumVo)){
            return packaging(StateCode.SUCCESS,"查询成功",addCurriculumVo);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //根据开课id查询加入课程信息
    @GetMapping("/tutionId")
    public State<Object> tutionId(Integer tution_id,Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<AddCurriculumVo> list = addCurriculumService.tutionId(tution_id, currentPage, pageSize);
        if(list.getList().size()>0){
            return packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //根据用户id查加入课程信息信息
    @GetMapping("/userId")
    public State<Object> userId(Integer user_id,Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<AddCurriculumVo> list = addCurriculumService.userId(user_id, currentPage, pageSize);
        if(list.getList().size()>0){
            return packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }


    //加入课程
    @PostMapping()
    public State<Object> insertAddCurriculum(AddCurriculum addCurriculum){
        if(StringUtils.isEmpty(addCurriculum)){
            return packaging(StateCode.FAIL,"添加失败",null);
        }
        int i = addCurriculumService.insertAddCurriculum(addCurriculum);
        if(i>0){
            return packaging(StateCode.SUCCESS,"添加成功",null);
        }
        return packaging(StateCode.FAIL,"添加失败",null);
    }


    //修改加入课程
    @PutMapping()
    public State<Object> updateAddCurriculum(AddCurriculum addCurriculum){
        if(StringUtils.isEmpty(addCurriculum)){
            return packaging(StateCode.FAIL,"操作失败失败",null);
        }
        if(addCurriculum.getStar()<0||addCurriculum.getStar()>5){
            return packaging(StateCode.FAIL,"星标数范围不对",null);
        }
        int i = addCurriculumService.updateAddCurriculum(addCurriculum);
        if(i>0){
            return packaging(StateCode.SUCCESS,"操作成功",null);
        }
        return packaging(StateCode.FAIL,"操作失败失败",null);
    }


    //删除加入课程
    @DeleteMapping("/{add_id}")
    public State<Object> deleteAddCurriculum(@PathVariable("add_id")Integer add_id){
        int i = addCurriculumService.deleteAddCurriculum(add_id);
        if(i>0){
            return packaging(StateCode.SUCCESS,"删除成功",null);
        }
        return packaging(StateCode.FAIL,"删除失败",null);
    }





}