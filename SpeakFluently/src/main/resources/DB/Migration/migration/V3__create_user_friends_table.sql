CREATE TABLE IF NOT EXISTS td_channel_users(
    channel_users_id INT PRIMARY KEY AUTO_INCREMENT,
    channel_id INT ,
    username NVARCHAR(50),
    is_admin TINYINT(1) DEFAULT 0,
    FOREIGN KEY (channel_id) REFERENCES td_channel(channel_id),
    FOREIGN KEY (username) REFERENCES td_users(username)
)