-- INSERT CATEGORIES
INSERT INTO CATEGORY (id, category_name)
VALUES (NEXTVAL('CATEGORY_ID_SEQ'), 'American'),
       (NEXTVAL('CATEGORY_ID_SEQ'), 'Italian'),
       (NEXTVAL('CATEGORY_ID_SEQ'), 'Brazilian'),
       (NEXTVAL('CATEGORY_ID_SEQ'), 'Mexican'),
       (NEXTVAL('CATEGORY_ID_SEQ'), 'Fast Food')
;

-- INSERT UNIT OF MEASURE
INSERT INTO UNIT_OF_MEASURE (id, description)
VALUES (NEXTVAL('UNIT_OF_MEASURE_ID_SEQ'), 'Teaspoon'),
       (NEXTVAL('UNIT_OF_MEASURE_ID_SEQ'), 'Tablespoon'),
       (NEXTVAL('UNIT_OF_MEASURE_ID_SEQ'), 'Cup'),
       (NEXTVAL('UNIT_OF_MEASURE_ID_SEQ'), 'Pinch'),
       (NEXTVAL('UNIT_OF_MEASURE_ID_SEQ'), 'Ounce'),
       (NEXTVAL('UNIT_OF_MEASURE_ID_SEQ'), 'Each')
;

-- INSERT RECIPE
insert into RECIPE (ID, COOK_TIME, DESCRIPTION, DIFFICULTY, DIRECTIONS, IMAGE, PREPARATION_TIME, SERVING, SOURCE, URL,
                    NOTE_ID)
values (NEXTVAL('RECIPE_ID_SEQ'), 0, 'Perfect Guacamole', 'EASY', '16473', null, 10, null, null, null, null),
       (NEXTVAL('RECIPE_ID_SEQ'), 9, 'Spicy Grilled Chicken Taco', 'MEDIUM', '16475', null, 20, null, null, null, null)
;

-- INSERT INGREDIENT
insert into INGREDIENT (ID, AMOUNT, DESCRIPTION, RECIPE_ID, UNIT_OF_MEASURE_ID)
values (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'freshly grated black pepper', 1, 1),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'fresh lime juice or lemon juice', 1, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 0.50, 'Kosher salt', 1, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'Cilantro', 1, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'ripe avocados', 1, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'minced red onion or thinly sliced green onion', 1, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'serrano chiles, stems and seeds removed, minced', 1, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 0.50, 'ripe tomato, seeds and pulp removed, chopped', 1, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 1.00, 'finely grated orange zestr', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 0.50, 'Salt', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 4.00, 'cup sour cream thinned with 1/4 cup milk', 2, 3),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 1.00, 'Dried Oregano', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 1.00, 'Sugar', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 4.00, 'radishes, thinly sliced', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 3.00, 'fresh-squeezed orange juice', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'Olive Oil', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 4.00, 'boneless chicken thighs', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 1.00, 'Dried Cumin', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 1.00, 'Clove of Garlic, Choppedr', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 0.50, 'cherry tomatoes, halved', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 4.00, 'lime, cut into wedges', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 4.00, 'Roughly chopped cilantro', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'Ancho Chili Powder', 2, 2),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 0.25, 'red onion, thinly sliced', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 8.00, 'small corn tortillasr', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 2.00, 'medium ripe avocados, slic', 2, 6),
       (NEXTVAL('INGREDIENT_ID_SEQ'), 3.00, 'packed baby arugula', 2, 3)
;

-- INSERT NOTE
insert into NOTE (ID, RECIPE_NOTE, RECIPE_ID)
values (1, '16476', 1),
       (2, '16477', 2)
;
UPDATE RECIPE
set note_id = 1
where id = 1;
UPDATE RECIPE
set note_id = 2
where id = 2;

-- INSERT RECIPE CATEGORY
insert into recipe_category (recipe_id, category_id)
values (1, 4),
       (1, 1),
       (2, 4),
       (2, 1)
;