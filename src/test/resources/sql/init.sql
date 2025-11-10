-- coupon.coupon_entity definition

CREATE TABLE `coupon_entity` (
                                 `coupon_id` varchar(255) NOT NULL,
                                 `coupon_type` enum('ALL','PANTS','SHIRTS') DEFAULT NULL,
                                 `created_at` date DEFAULT NULL,
                                 `expired_date` datetime(6) DEFAULT NULL,
                                 `percent` int(11) NOT NULL,
                                 `size` int(11) NOT NULL,
                                 `title` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;


-- coupon.coupon_log_entity definition

CREATE TABLE `coupon_log_entity` (
                                     `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                     `coupon_id` varchar(255) DEFAULT NULL,
                                     `created_at` datetime(6) DEFAULT NULL,
                                     `user_id` varchar(255) DEFAULT NULL,
                                     PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;