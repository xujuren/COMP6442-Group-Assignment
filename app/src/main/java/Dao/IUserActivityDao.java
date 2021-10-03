package Dao;

import java.util.List;

public interface IUserActivityDao {
    public UserActivity createPost(String username, String postContent);
    public UserActivity likePost(String username, Integer idPost);
    public List<UserActivity> findAllPosts();
    public String getFilePath();
    public void deleteAll();
}
