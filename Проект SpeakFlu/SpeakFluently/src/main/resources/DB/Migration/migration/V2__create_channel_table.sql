CREATE TABLE IF NOT EXISTS td_channel (
    channel_id INT PRIMARY KEY AUTO_INCREMENT,
    channel_name NVARCHAR(50),
    channel_owner_username NVARCHAR(50),
    is_active INT DEFAULT 1,
    is_deleted INT DEFAULT 0,  -- Добавена колона за логическо изтриване
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (channel_owner_username) REFERENCES td_users(username)
);
