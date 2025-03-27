INSERT INTO book (title, price, author, page) VALUES
('자바의 정석', 30000, '남궁성', 800),
('스프링 입문', 25000, '이순신', 600),
('JPA 완전 정복', 35000, '강감찬', 700),
('React 제대로 배우기', 27000, '김유신', 500),
('AI 서비스 구축', 40000, '최무선', 550);

INSERT INTO customer (username, password, name, age) VALUES
('user1', 'pass1', '홍길동', 25),
('user2', 'pass2', '이순신', 30),
('user3', 'pass3', '유관순', 28),
('user4', 'pass4', '장보고', 35),
('user5', 'pass5', '안중근', 40);

INSERT INTO review (cost, content, createdat, book_id, customer_id) VALUES
(5, '정말 유익한 책입니다!', NOW(), 1, 1),
(4, '초보자에게 좋아요.', NOW(), 1, 2),
(3, '조금 어렵지만 괜찮아요.', NOW(), 2, 3),
(5, '실무에 도움이 많이 됩니다.', NOW(), 3, 4),
(2, '기대에 못 미쳤어요.', NOW(), 5, 5);
