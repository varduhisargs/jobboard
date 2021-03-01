
DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `title` varchar(255) NOT NULL,
                        `description` text NOT NULL,
                        `photo` varchar(255) DEFAULT NULL,
                        `user_id` bigint NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `blog` */

/*Table structure for table `blog_category` */

DROP TABLE IF EXISTS `blog_category`;

CREATE TABLE `blog_category` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `blog_category` */

/*Table structure for table `blog_comment` */

DROP TABLE IF EXISTS `blog_comment`;

CREATE TABLE `blog_comment` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `text` text,
                                `blog_id` bigint DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `blog_id` (`blog_id`),
                                CONSTRAINT `blog_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `blog_comment` */

/*Table structure for table `blogs_categories` */

DROP TABLE IF EXISTS `blogs_categories`;

CREATE TABLE `blogs_categories` (
                                    `blog_id` bigint DEFAULT NULL,
                                    `category_id` bigint DEFAULT NULL,
                                    KEY `blog_id` (`blog_id`),
                                    KEY `category_id` (`category_id`),
                                    CONSTRAINT `blogs_categories_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`),
                                    CONSTRAINT `blogs_categories_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `blogs_categories` */

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) DEFAULT NULL,
                           `location` varchar(255) DEFAULT NULL,
                           `photo` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*Data for the table `favorite_list` */

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `title` varbinary(255) NOT NULL,
                       `published_on` datetime NOT NULL,
                       `vacancy` int NOT NULL,
                       `employment_status` enum('FULL_TIME','PART_TIME','FREELANCE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                       `country` varchar(255) DEFAULT NULL,
                       `salary` int NOT NULL,
                       `deadline` datetime NOT NULL,
                       `description` text NOT NULL,
                       `responsibilities` text NOT NULL,
                       `experience` text NOT NULL,
                       `other` text,
                       `company_id` bigint DEFAULT NULL,
                       PRIMARY KEY (`id`),
                       KEY `company_id` (`company_id`),
                       CONSTRAINT `job_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `job` */

/*Table structure for table `job_category` */

DROP TABLE IF EXISTS `job_category`;

CREATE TABLE `job_category` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `name` varchar(255) NOT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `job_category` */

/*Table structure for table `jobs_categories` */

DROP TABLE IF EXISTS `jobs_categories`;

CREATE TABLE `jobs_categories` (
                                   `job_id` bigint DEFAULT NULL,
                                   `category_id` bigint DEFAULT NULL,
                                   KEY `job_id` (`job_id`),
                                   KEY `category_id` (`category_id`),
                                   CONSTRAINT `jobs_categories_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
                                   CONSTRAINT `jobs_categories_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `job_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `jobs_categories` */

/*Table structure for table `resume` */



/*Data for the table `resume` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        `email` varchar(255) NOT NULL,
                        `phone` varchar(255) DEFAULT NULL,
                        `password` varchar(255) NOT NULL,
                        `description` text,
                        `photo` varchar(255) DEFAULT NULL,
                        `facebook` varchar(255) DEFAULT NULL,
                        `twitter` varchar(255) DEFAULT NULL,
                        `whatsapp` varchar(255) DEFAULT NULL,
                        `resume_id` bigint DEFAULT NULL,

                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_role` */

/*Table structure for table `users_roles` */

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
                               `user_id` bigint DEFAULT NULL,
                               `user_role_id` bigint DEFAULT NULL,
                               KEY `user_id` (`user_id`),
                               KEY `user_role_id` (`user_role_id`),
                               CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                               CONSTRAINT `users_roles_ibfk_2` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `users_roles` */

/*Table structure for table `users_jobs` */

DROP TABLE IF EXISTS `users_jobs`;

CREATE TABLE `users_jobs` (
                              `user_id` bigint DEFAULT NULL,
                              `job_id` bigint DEFAULT NULL,
                              KEY `user_id` (`user_id`),
                              KEY `job_id` (`job_id`),
                              CONSTRAINT `users_jobs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                              CONSTRAINT `users_jobs_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `favorite_list`;

CREATE TABLE `favorite_list` (
                                 `user_id` bigint DEFAULT NULL,
                                 `job_id` bigint DEFAULT NULL,
                                 KEY `user_id` (`user_id`),
                                 KEY `job_id` (`job_id`),
                                 CONSTRAINT `favorite_list_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                                 CONSTRAINT `favorite_list_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `resume`;

CREATE TABLE `resume` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) NOT NULL,
                          `professional_title` varchar(255) NOT NULL,
                          `email` varchar(255) NOT NULL,
                          `location` varchar(255) NOT NULL,
                          `photo` varchar(255) DEFAULT NULL,
                          `content` text,
                          PRIMARY KEY (`id`),
                          CONSTRAINT `resume_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;