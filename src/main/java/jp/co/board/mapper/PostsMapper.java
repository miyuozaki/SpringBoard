package jp.co.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.board.entity.PostsEntity;

public interface PostsMapper {

	/* 投稿全件取得 */
	List<PostsEntity> getPostsAll();

	/* 投稿件数計上 */
	int getInsert(@Param("name")String name,@Param("content")String content);

	/* 削除件数計上 */
	int getDelete(Integer id);
}
