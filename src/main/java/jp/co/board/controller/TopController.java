package jp.co.board.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.board.dto.CommentsDto;
import jp.co.board.dto.PostsDto;
import jp.co.board.form.DeleteForm;
import jp.co.board.form.PostForm;
import jp.co.board.service.TopService;

@Controller
public class TopController {

	@Autowired
	TopService topService;

	 /* 投稿&コメント全件表示
	  * ・コメントの挙動は省略、DBの内容を表示
	  * */
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

	/* 投稿処理
	 * ・投稿画面に遷移
	 * ・処理はTopServiceにまとめている
	 * */
	@RequestMapping(value="/post",method =RequestMethod.GET)
	public String post(Model model) {
		//タイトルメッセージ
		model.addAttribute("message", "投稿してね！");
		//投稿処理
		PostForm postform = new PostForm();
		model.addAttribute("postform",postform);
		return "post";
	}
	/* 投稿処理更新件数表示 */
	@RequestMapping(value="/post",method =RequestMethod.POST)
	public String post(@ModelAttribute PostForm form,Model model) {
		int count = topService.getInsert(form.getName(),form.getContent());
		Logger.getLogger(TopController.class).log(Level.INFO, "挿入件数は" + count + "件です。");
		return "redirect:/top";
	}

	/*
	 * 削除処理
	 * ・同じURLのときはparamsを使用すること
	 * */
	@RequestMapping(value="/top",params="delete",method =RequestMethod.GET)
	public String delete(Model model) {
		DeleteForm deleteform = new DeleteForm();
		model.addAttribute("deleteform",deleteform);
		return "redirect:/top";
	}
	/* 削除更新件数表示 */
	@RequestMapping(value="/top",params="delete",method =RequestMethod.POST)
	public String post(@ModelAttribute DeleteForm form,Model model) {
		int count = topService.getDelete(form.getId());
		Logger.getLogger(TopController.class).log(Level.INFO, "削除件数は" + count + "件です。");
		return "redirect:/top";
	}
}
