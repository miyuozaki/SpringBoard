package jp.co.board.mapper;

import java.util.List;

import jp.co.board.entity.PostsEntity;

public interface PostsMapper {

	/* 投稿全件取得 */
	List<PostsEntity> getPostsAll();

}
