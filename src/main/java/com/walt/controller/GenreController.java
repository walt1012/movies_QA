package com.walt.controller;

import com.walt.model.Genre;
import com.walt.repository.GenreRepository;
import com.walt.result.ResponseMessage;
import com.walt.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreRepository genreRepository;

    /**
     * 根据类型名查询Genre实体
     */
    @RequestMapping("/get")
    public List<Genre> getGenres(@RequestParam(value = "name") String name) {
        return genreRepository.findByName(name);
    }

    /**
     * 创建一个电影类型节点
     */
    @PostMapping("/save")
    public ResponseResult saveGenre(@RequestBody Genre genre) {
        genreRepository.save(genre);
        return new ResponseResult(ResponseMessage.OK);
    }
}
