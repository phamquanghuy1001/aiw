package com.aiw.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aiw.entities.Comment;
import com.aiw.services.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentApi {
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/getall")
	public List<Comment> getAll() {
		return commentService.getAll();
	}

	@RequestMapping(value = "/getallbyarticle/{id}")
	public List<Comment> getAllByArticleId(@PathVariable long id) {
		return commentService.getAllByArticleId(id);
	}

	@RequestMapping(value = "/add/{commentor}/{message}/{idarticle}", method = RequestMethod.POST)
	public Comment addComment(@PathVariable(name = "commentor") String commentor,
			@PathVariable(name = "message") String message, @PathVariable(name = "idarticle") long idarticle) {
		Comment comment = new Comment(commentor, message, idarticle);
		commentService.saveComment(comment);
		return comment;
	}

}
