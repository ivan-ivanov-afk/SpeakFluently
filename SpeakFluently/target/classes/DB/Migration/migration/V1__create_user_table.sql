CREATE TABLE IF NOT EXISTS td_users(
username NVARCHAR(50) PRIMARY KEY,
password NVARCHAR(256),
fullname NVARCHAR(50),
is_active INT DEFAULT 1
)