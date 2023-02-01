begin;

DECLARE curs_products SCROLL CURSOR FOR select * from products;

MOVE LAST FROM curs_products;

MOVE BACKWARD 5 FROM curs_products;

FETCH FROM curs_products;

MOVE BACKWARD 9 FROM curs_products;

MOVE BACKWARD 5 FROM curs_products;

MOVE BACKWARD 1 FROM curs_products;

FETCH FROM curs_products;

CLOSE curs_products;

COMMIT;
