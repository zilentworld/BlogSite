CREATE DATABASE `blog_site`;

CREATE TABLE `blog_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reply_to` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `comment_content` varchar(500) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blog_post_id` mediumtext,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

CREATE TABLE `blog_post` (
  `blog_post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog_url` varchar(50) DEFAULT NULL,
  `poster_user_id` bigint(20) DEFAULT NULL,
  `blog_title` varchar(50) DEFAULT NULL,
  `post_content` varchar(50000) DEFAULT NULL,
  `post_preview` varchar(1000) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`blog_post_id`),
  UNIQUE KEY `blog_url` (`blog_url`),
  UNIQUE KEY `blog_title` (`blog_title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

CREATE TABLE `blog_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `last_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `first_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `blog_username` (`username`),
  UNIQUE KEY `blog_email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
