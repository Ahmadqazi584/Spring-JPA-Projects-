INSERT INTO social_user (id, username) VALUES
(10, 'john_doe'),
(23, 'alice_smith'),
(31, 'michael_ross');

INSERT INTO social_profile (id, user_id, bio, created_at) VALUES
(45, 10, 'Loves coding and open-source.', '2024-02-22 10:15:30'),
(46, 23, 'Nature and travel enthusiast.', '2024-02-22 11:05:20');

INSERT INTO social_post (id, user_id, title, content, created_at) VALUES
(98, 10, 'Spring Boot Guide', 'How to build REST APIs with Spring Boot', '2024-02-22 12:00:00'),
(87, 23, 'My Travel Diaries', 'Visited the Grand Canyon last weekend!', '2024-02-22 14:30:45');

INSERT INTO social_group (id, name) VALUES
(56, 'Java Developers'),
(67, 'Travel Enthusiasts');

INSERT INTO user_groups (user_id, group_id) VALUES
(10, 56), -- User 10 joins Java Developers
(23, 67); -- User 23 joins Travel Enthusiasts
