package com.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.article.dao.ArticleDao;
import com.article.dto.Article;
import com.article.dto.ResultData;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;

	public List<Article> showList() {
		return articleDao.articles;
	}

	public ResultData modifyArticle(Integer id, String title, String body) {
		Article article = getArticleById(id);

		if (article == null) {
			return new ResultData("F-1", id + "번은 존재하지 않습니다.", "id", id);
		}
		articleDao.modifyArticle(id, title, body);

		return new ResultData("S-1", id + "번 글을 수정화였습니다..", "article", getArticleById(id));
	}

	public ResultData deleteArticle(Integer id) {
		Article article = getArticleById(id);

		if (article == null) {
			return new ResultData("F-1", id + "번은 존재하지 않습니다.", "id", id);
		}
		articleDao.deleteArticle(id);
		return new ResultData("F-1", id + "번을 삭제했습니다.", "id", id);
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public ResultData addArticle(String title, String body) {
		int id = articleDao.addArticle(title, body);

		Article article = getArticleById(id);

		return new ResultData("S-1", id + "번 글이 등록되었습니다.", "article", article);
	}

	public void TestArticle() {
		for (int i = 0; i < 2; i++) {
			addArticle("제목", "내용");
		}
	}
}
