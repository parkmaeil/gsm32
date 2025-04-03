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

INSERT INTO cart (quantity, cartdate, customer_id, book_id) VALUES
(1, DATE_SUB(NOW(), INTERVAL 9 DAY), 1, 1),  -- 홍길동 → 자바의 정석
(2, DATE_SUB(NOW(), INTERVAL 8 DAY), 2, 2),  -- 이순신 → 스프링 입문
(1, DATE_SUB(NOW(), INTERVAL 7 DAY), 3, 3),  -- 유관순 → JPA 완전 정복
(3, DATE_SUB(NOW(), INTERVAL 6 DAY), 4, 4),  -- 장보고 → React 제대로 배우기
(2, DATE_SUB(NOW(), INTERVAL 5 DAY), 5, 5),  -- 안중근 → AI 서비스 구축
(1, DATE_SUB(NOW(), INTERVAL 4 DAY), 1, 3),  -- 홍길동 → JPA 완전 정복
(1, DATE_SUB(NOW(), INTERVAL 3 DAY), 2, 5),  -- 이순신 → AI 서비스 구축
(2, DATE_SUB(NOW(), INTERVAL 2 DAY), 3, 1),  -- 유관순 → 자바의 정석
(1, DATE_SUB(NOW(), INTERVAL 1 DAY), 4, 2),  -- 장보고 → 스프링 입문
(2, NOW(),                      5, 4);  -- 안중근 → React 제대로 배우기


select *
from customer c
left join cart ct
on c.id=ct.customer_id
left join book b
on b.id=ct.book_id
where c.username='user1'
