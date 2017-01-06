package com.xuy849.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.xuy849.mapper.FilmMapper;
import com.xuy849.pojo.Film;
import com.xuy849.pojo.FilmCustom;
import com.xuy849.pojo.Page;
import com.xuy849.service.FilmService;
import com.xuy849.util.Util;


@Service
public class FilmServiceImp implements FilmService{

	//向film表中插入(title,description,language_id)
	//返回插入的记录数目
	public int insertIntoFilm(String title, String description, int language_id) throws Exception {
		// TODO Auto-generated method stub
				
		//
		Film film = new Film();	
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language_id);
		
		//
		FilmMapper filmMapper = Util.getFilmMapper();
		int a = filmMapper.insertIntoFilm(film);
			
		return a;
	}

	//模糊查询Film
	//根据film_id精确查询,title模糊查询,description模糊查询,language_id精确查询
	@Override
	public List<Film> query(String film_id, String title, String description, String language_id) throws Exception {
		// TODO Auto-generated method stub
		
		FilmCustom filmCuston = new FilmCustom();
		
		//判断film_id是否为空
		if(film_id!=null&&!film_id.equals("")){
			filmCuston.setFilm_id(new Integer(Integer.parseInt(film_id)));
		}
		
		//设置title
		if(title==null)
			title="";
		filmCuston.setTitle(title);
		
		
		//设置description
		if(description==null)
			description="";
		filmCuston.setDescription(description);
		
		//判断language_id是否为空
		if(language_id!=null&&!language_id.equals("")){
			filmCuston.setLanguage_id(new Integer(Integer.parseInt(language_id)));
		}
		
		//
		FilmMapper filmMapper = Util.getFilmMapper();
		List<Film> film = filmMapper.query(filmCuston);
		
		return film;
	}
	
	//模糊查询Film
	//根据film_id精确查询,title模糊查询,description模糊查询,language_id精确查询
	//分页查询
	@Override
	public List<Film> query(String film_id, String title, String description, String language_id,int page,int maxSize) throws Exception{
		Page<FilmCustom> obj_Page = new Page<FilmCustom>();
		
		//
		obj_Page.setPage(page);
		obj_Page.setMaxSize(maxSize);
		
		//
		FilmCustom filmCustom = new FilmCustom();
		
		//判断film_id是否为空
		if(film_id!=null&&!film_id.equals("")){
			if(isInt(film_id))
				filmCustom.setFilm_id(new Integer(Integer.parseInt(film_id)));
		}
		
		if(title==null)
			title="";
		filmCustom.setTitle(title);
		
		if(description==null)
			description="";
		filmCustom.setDescription(description);
		
		
		//判断language_id是否为空
		if(language_id!=null&&!language_id.equals("")){
			if(isInt(language_id))
				filmCustom.setLanguage_id(new Integer(Integer.parseInt(language_id)));
		}
		
		//
		obj_Page.setEntity(filmCustom);
		
		//
		FilmMapper filmMapper = Util.getFilmMapper();
		List<Film> list = filmMapper.queryPage(obj_Page);
		
		return list;
	}
	
	//判断str是否可以转换为整数
	private static boolean isInt(String str) {
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
				return false;
		}
		return true;
	}

	@Override
	public int getCount(String film_id, String title, String description, String language_id) throws Exception {
		// TODO Auto-generated method stub
		
		FilmCustom filmCuston = new FilmCustom();
		
		//判断film_id是否为空
		if(film_id!=null&&!film_id.equals("")){
			if(isInt(film_id))
			filmCuston.setFilm_id(new Integer(Integer.parseInt(film_id)));
		}
		
		//设置title
		if(title==null)
			title="";
		filmCuston.setTitle(title);
		
		
		//设置description
		if(description==null)
			description="";
		filmCuston.setDescription(description);
		
		//判断language_id是否为空
		if(language_id!=null&&!language_id.equals("")){
			if(isInt(language_id))
			filmCuston.setLanguage_id(new Integer(Integer.parseInt(language_id)));
		}
		
		//
		FilmMapper filmMapper = Util.getFilmMapper();
		int count = filmMapper.selectCount(filmCuston);
		
		return count;
	}

	@Override
	public boolean deleteFilmById(String id){
		// TODO Auto-generated method stub
		//
		
		int ix = Integer.parseInt(id);
		
		int i;
		try {
			i = Util.getFilmMapper().deleteById(ix);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("外键约束，无法删除");
			return false;
		}
		
		return (i>0)?true:false;
	}

	@Override
	public int updateFilm(String id, String title, String description, int language) throws Exception {
		// TODO Auto-generated method stub
		Film film=new Film();
		
		//
		film.setFilm_id(Integer.parseInt(id));
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language);
		
		
		int x = Util.getFilmMapper().updateFilmById(film);
		
		return x;
	}
		
}
