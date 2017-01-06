package com.xuy849.mapper;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.xuy849.pojo.Film;
import com.xuy849.pojo.FilmCustom;
import com.xuy849.pojo.Page;

public interface FilmMapper {

	//向film表中插入(title,description,language_id)
	//返回插入的记录数目
	public int insertIntoFilm(Film film) throws Exception;

	//模糊查询Film
	//根据film_id,title,description,language_id
	public List<Film> query(FilmCustom filmCustom) throws Exception;
	

	//模糊查询Film
	//根据film_id,title,description,language_id
	public int selectCount(FilmCustom filmCustom) throws Exception;
	
	
	//模糊查询Film
	//根据film_id,title,description,language_id
	//分页
	public List<Film> queryPage(Page<FilmCustom> page) throws Exception;

	//根据film_id删除film
	public int deleteById(int film_id) throws MySQLIntegrityConstraintViolationException;
	
	//更新film
	public int updateFilmById(Film film) throws Exception;
	
	
}
