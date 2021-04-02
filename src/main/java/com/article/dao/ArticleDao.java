package com.article.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.article.dto.Article;
import com.article.util.Util;

@Component
public class ArticleDao {
	public List<Article> articles;
	private int articleLastId;
	
	public ArticleDao() {
		articles = new ArrayList<>();
		articleLastId = 0;
		TestArticle();
	}
	
	public boolean modifyArticle(Integer id, String title, String body) {
		Article article = getArticleById(id);
		
		if(article == null) {
			return false;
		}
		
		article.setUpdateDate(Util.getNowDateStr());
		article.setTitle(title);
		article.setBody(body);
		
		return true;
	}
	
	
	public void deleteArticle(Integer id) {
		Article article = getArticleById(id);
		articles.remove(article);
	}
	
	public Article getArticleById(int id) {
		for(Article article : articles) {
			if(article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	
	public int addArticle(String title, String body) {
		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = regDate;
		
		Article article = new Article(id,regDate,updateDate,title,body);
		articles.add(article);
		
		articleLastId = id;
		return id;
	}
	
	
	public void TestArticle() {
		for(int i = 0; i < 2; i++) {
			addArticle("제목","내용");
		}
	}
}
