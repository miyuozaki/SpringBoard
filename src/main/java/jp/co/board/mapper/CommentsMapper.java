package jp.co.board.mapper;

import java.util.List;

import jp.co.board.entity.CommentsEntity;

public interface CommentsMapper {

	/* コメント全件取得 */
	List<CommentsEntity> getCommentsAll();

}
