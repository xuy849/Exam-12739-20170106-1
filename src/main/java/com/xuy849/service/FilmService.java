package com.xuy849.service;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.xuy849.pojo.Film;

public interface FilmService {
////向film表中插入(title,description,language_id)
	//返回插入的记录数目
	
	public int insertIntoFilm(String title,String description,int language_id) throws Exception;
	
	//模糊查询Film
	//根据film_id,title,description,language_id
	public List<Film> query(String film_id,String title,String description,String language_id) throws Exception;

	public int getCount(String film_id,String title,String description,String language_id) throws Exception;
	
	//模糊查询Film
	//根据film_id,title,description,language_id
	//分页
	public List<Film> query(String film_id, String title, String description, String language_id,int page,int maxSize) throws Exception;

	//根据id删除film
	public boolean deleteFilmById(String id) throws MySQLIntegrityConstraintViolationException;
	
	//更新film
	//返回更新行数
	public int updateFilm(String id,String title,String description,int language) throws Exception;
}
