package jp.co.board.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.board.dto.CommentsDto;
import jp.co.board.dto.PostsDto;
import jp.co.board.entity.CommentsEntity;
import jp.co.board.entity.PostsEntity;
import jp.co.board.mapper.CommentsMapper;
import jp.co.board.mapper.PostsMapper;

@Service
public class TopService {
	@Autowired
	PostsMapper postsMapper;
	@Autowired
	CommentsMapper commentsMapper;

	/* 投稿全件取得 */
	public List<PostsDto> getPostsAll(){
		List<PostsEntity>postsList = postsMapper.getPostsAll();
		List<PostsDto>resultList = convertToPostsDto(postsList);
		return resultList;
	}
	/* 変換処理 */
	private List<PostsDto> convertToPostsDto(List<PostsEntity> postsList){
		List<PostsDto> resultList = new LinkedList<PostsDto>();
		//エンティティからDtoへListを分解して詰め直し
		for(PostsEntity entity :postsList) {
			PostsDto dto = new PostsDto();
			BeanUtils.copyProperties(entity,dto);
			resultList.add(dto);
		}
		return resultList;
	}

	/* コメント全件取得 */
	public List<CommentsDto> getCommentsAll(){
		List<CommentsEntity>commentsList = commentsMapper.getCommentsAll();
		List<CommentsDto>resultList = convertToCommentDto(commentsList);
		return resultList;
	}
	/* 変換処理 */
	private List<CommentsDto> convertToCommentDto(List<CommentsEntity> commentsList){
		List<CommentsDto> resultList = new LinkedList<CommentsDto>();
		//エンティティからDtoへListを分解して詰め直し
		for(CommentsEntity entity :commentsList) {
			CommentsDto dto = new CommentsDto();
			BeanUtils.copyProperties(entity,dto);
			resultList.add(dto);
		}
		return resultList;
	}

	/*  投稿件数計上 */
	public int getInsert(String name,String content) {
		int count = postsMapper.getInsert(name,content);
		return count;
	}

	/*  削除件数計上 */
	public int getDelete(Integer id) {
		int count = postsMapper.getDelete(id);
		return count;
	}
}
