package com.xuy849.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuy849.pojo.Film;
import com.xuy849.pojo.Language;
import com.xuy849.pojo.ResponsePage;
import com.xuy849.util.Util;

@RestController
@RequestMapping(path="/film")
public class FilmController {

	//返回所有的语言
	@RequestMapping(path="/queryLanguage",method=RequestMethod.GET)
	public List<Language> queryLanguage(){
		List<Language> list = null;
		
		try {
			 list = Util.getLanguageService().queryLanguage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//模糊查询Film
		//根据film_id精确查询,title模糊查询,description模糊查询,language_id精确查询
		@RequestMapping(path="/query",method=RequestMethod.GET)
		public ResponsePage<Film> query(
				@RequestParam(name="film_id",required=false,defaultValue="") String film_id,
				@RequestParam(name="title",required=false,defaultValue="") String title,
				@RequestParam(name="description",required=false,defaultValue="") String description,
				@RequestParam(name="language_id",required=false,defaultValue="") String language_id,
				@RequestParam(name="page",required=false,defaultValue="1") int page,
				@RequestParam(name="maxSize",required=false,defaultValue="10")int maxSize
				){
			
			List<Film> list = null;
			ResponsePage<Film> responsePage = new ResponsePage<Film>();
			int total = 0;
			
			//求得list
			try {
				list = Util.getFilmService().query(film_id, title, description, language_id, page, maxSize);		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//求得total
			try {
				total = Util.getFilmService().getCount(film_id, title, description, language_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//
			responsePage.setRows(list);
			responsePage.setTotal(total);
			
			return responsePage;
		}
		
		
		//根据film_id删除film
		//如果删除成功，返回YES
		//如果删除失败，返回NO
		@RequestMapping(path="/deleteFilmById",method=RequestMethod.GET)
		public String deleteFilmById(@RequestParam(name="filmId",required=true) String id){
			
			boolean b = false;
			
			try {
				b = Util.getFilmService().deleteFilmById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("b");
			
			return b?"YES":"NO";
		}
		
		
		//更新
		//更新成功：返回"YES"
		//更新失败：返回"NO"
		@RequestMapping(path="/updateFilm",method=RequestMethod.GET)
		public String updateFilm(@RequestParam(name="filmId",required=true) String filmId,
				@RequestParam(name="title",required=true) String title,
				@RequestParam(name="description",required=true) String description,
				@RequestParam(name="language",required=true) int language_id){
			
			int x=0;
			
			try {
				x = Util.getFilmService().updateFilm(filmId, title, description, language_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return (x>0)?"YES":"NO";
		}
	
		//插入
		@RequestMapping(path="/insertIntoFilm",method=RequestMethod.GET)
		public String insertIntoFilm(@RequestParam(name="title",required=false,defaultValue="") String title,
				@RequestParam(name="description",required=false,defaultValue="") String description,
				@RequestParam(name="language_id",required=true) int language_id){
			int i = 0;
			try {
				i = Util.getFilmService().insertIntoFilm(title, description, language_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return (i>=1)?"YES":"NO";
		}
}
