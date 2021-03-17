package com.walt.controller;

import com.walt.model.Movie;
import com.walt.repository.MovieRepository;
import com.walt.result.ResponseMessage;
import com.walt.result.ResponseResult;
import com.walt.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    /**
     * 根据电影名查询电影实体
     */
    @RequestMapping("/get")
    public List<Movie> getMovies(@RequestParam(value = "title") String title) {
        return movieRepository.findByTitle(title);
    }

    /**
     * 创建一个电影节点
     */
    @PostMapping("/save")
    public ResponseResult saveMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return new ResponseResult(ResponseMessage.OK);
    }


    @RequestMapping("/query")
    public ResponseResult queryMovieTiles() {
        List<String> movieTiles = movieRepository.getMovieTiles();
        ResultData<String> result = new ResultData<String>(ResponseMessage.OK, movieTiles);
        return new ResponseResult(result);
    }
}
