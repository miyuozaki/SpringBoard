package jp.co.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.board.dto.CommentsDto;
import jp.co.board.dto.PostsDto;
import jp.co.board.service.TopService;

@Controller
public class TopController {

	@Autowired
	TopService topService;

	@RequestMapping(value = "/top",method = RequestMethod.GET)
	public String top(Model model) {
		//タイトルメッセージ
		model.addAttribute("message", "ようこそyesyes");

		//投稿取得
		List<PostsDto>posts = topService.getPostsAll();
		model.addAttribute("posts",posts);
		//コメント取得
		List<CommentsDto>comments = topService.getCommentsAll();
		model.addAttribute("comments",comments);

		return "top";
	}
}
