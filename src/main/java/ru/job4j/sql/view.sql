create view where_namesakes_take_1_book
	as select s.name as student, COUNT(s.name),  a.name as author
	from students as s
		join orders o on s.id = o.student_id
		join books b on o.book_id = b.id
		join authors a on b.author_id = a.id
		GROUP BY (s.name, a.name)
		HAVING COUNT(s.name) > 1 AND a.name = 'Александр Пушкин';