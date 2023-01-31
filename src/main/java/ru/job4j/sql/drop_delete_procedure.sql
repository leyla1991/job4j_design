CREATE OR REPLACE PROCEDURE drop_data()
language 'plpgsql'
as $$
   BEGIN
   	DELETE FROM products
	WHERE count > 25;
	END
$$;
