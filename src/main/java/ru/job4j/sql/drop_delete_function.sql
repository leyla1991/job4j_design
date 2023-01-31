create or replace function f_del_data()
returns void
language 'plpgsql'
as
$$
	BEGIN
		DELETE FROM products
		WHERE price = 0;
	END;
$$;